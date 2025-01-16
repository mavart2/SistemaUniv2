package com.example.uandesc.uandesnueva.services;

import com.example.uandesc.uandesnueva.models.UsuarioLogin;
import com.example.uandesc.uandesnueva.repository.UsuarioLoginRepositoryJPA;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private final UsuarioLoginRepositoryJPA userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UsuarioLoginRepositoryJPA userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Cargando usuario por nombre de usuario: {}", username);
        UsuarioLogin user = userRepository.findByNombre(username)
                .orElseThrow(() -> {
                    logger.error("Usuario no encontrado: {}", username);
                    return new UsernameNotFoundException("Usuario no encontrado");
                });

        logger.info("Usuario encontrado: {}", user.getNombre());

        return User.builder()
                .username(user.getNombre())
                .password(user.getPassword())
                .roles(user.getRol())
                .build();
    }
}
