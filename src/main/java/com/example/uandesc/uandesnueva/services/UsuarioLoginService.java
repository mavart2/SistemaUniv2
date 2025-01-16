package com.example.uandesc.uandesnueva.services;

import com.example.uandesc.uandesnueva.repository.UsuarioLoginRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioLoginService implements UserDetailsService{

    @Autowired
    private UsuarioLoginRepositoryJPA usuarioLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
