package br.com.fiap.helplife.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.helplife.entities.Usuario;
import br.com.fiap.helplife.models.Credencial;
import br.com.fiap.helplife.repositories.UsuarioRepository;
import br.com.fiap.helplife.services.TokenService;
import jakarta.validation.Valid;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @PostMapping("/api/registrar")
    public ResponseEntity<Object> registrar(@RequestBody @Valid Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);
        Credencial credencial = new Credencial(usuario.getEmail(), usuario.getSenha());
        var token = tokenService.generateToken(credencial);
        return ResponseEntity.status(HttpStatus.CREATED).body(token);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }

}