package br.com.fiap.helplife.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.helplife.models.Credencial;
import br.com.fiap.helplife.models.LoginResponse;
import br.com.fiap.helplife.entities.Usuario;
import br.com.fiap.helplife.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    public LoginResponse logar(Credencial credencial) {
        LoginResponse login = new LoginResponse();
        manager.authenticate(credencial.toAuthentication());
        login.setToken(tokenService.generateToken(credencial));
        login.setUser(findByEmail(credencial.email()).get());
        return login;
    }

    public Usuario registrar(Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        usuario.setId(findByEmail(usuario.getEmail()).get().getId());
        return usuario;
    }

    public Optional<Usuario> findByEmail(String email) {
        Usuario retornoUsuario = usuarioRepository.findByEmail(email);
        return Optional.ofNullable(retornoUsuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario replace(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }
}