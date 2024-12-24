package com.ProprioConnect.ProprioConnect.configuration;

import com.ProprioConnect.ProprioConnect.locataire.model.Locataire;
import com.ProprioConnect.ProprioConnect.locataire.repository.LocataireRepository;
import com.ProprioConnect.ProprioConnect.proprietaire.model.Proprietaire;
import com.ProprioConnect.ProprioConnect.proprietaire.repository.ProprietaireRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    private final ProprietaireRepository proprietaireRepository;

    private final LocataireRepository locataireRepository;

    public JwtAuthenticationFilter(JwtUtils jwtUtils, ProprietaireRepository proprietaireRepository, LocataireRepository locataireRepository) {
        this.jwtUtils = jwtUtils;
        this.proprietaireRepository = proprietaireRepository;
        this.locataireRepository = locataireRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String email = jwtUtils.getEmailFromJwtToken(token);

            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                Proprietaire proprietaire = proprietaireRepository.findByEmail(email);
                Locataire locataire = locataireRepository.findLocataireByEmail(email);

                if (jwtUtils.validateJwtToken(token)) {
                    if (proprietaire != null){
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( proprietaire, null, null);
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }else {
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( locataire, null, null);
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                }

            }
        }
        filterChain.doFilter(request, response);
    }


}
