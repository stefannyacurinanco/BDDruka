package com.example.bddruka.services;

import com.example.bddruka.dto.RegistroDto;
import com.example.bddruka.entities.RolEntity;
import com.example.bddruka.entities.UserEntity;
import com.example.bddruka.repositories.RolRepository;
import com.example.bddruka.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity usuarioSeleccionado = userRepository.findUserEntityByUsername(username);


        //Verificamos la autoridad que tiene según sus roles y las guardamos en una variable authorities
        Set<GrantedAuthority> authorities = usuarioSeleccionado
                .getRolesUsuario()
                .stream()
                .map((rolEntity -> new SimpleGrantedAuthority(rolEntity.getNombreRol())))
                .collect(Collectors.toSet());
        System.out.println(authorities);

        //Retornamos el nuevo User para ser auntenticado por spring security
        return new User(username,
                usuarioSeleccionado.getPassword(),
                authorities);
    }

    //Método para guardar nuevo usuario
    public UserEntity guardarNuevoUsuario(RegistroDto datosUsuario) {
        UserEntity nuevoUsuario = new UserEntity();
        nuevoUsuario.setUsername(datosUsuario.getUsername());
        nuevoUsuario.setPassword(passwordEncoder.encode(datosUsuario.getPassword()));
        nuevoUsuario.setEmail(datosUsuario.getEmail());

        RolEntity rol = rolRepository.findRolEntityByNombreRol("ADMIN");
        nuevoUsuario.setRolesUsuario(Collections.singleton(rol));
        /*
        Boolean existe = userRepository.existsById(nuevoUsuario.getUserId());
        //Verificamos si existe para su creación
        if(existe) {
            return null;
        }
        //Si no existe, se guarda en la BDD
         */
        return userRepository.save(nuevoUsuario);
    }
}
