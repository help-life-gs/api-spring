package br.com.fiap.helplife.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.fiap.helplife.entities.Endereco;
import br.com.fiap.helplife.entities.Usuario;
import br.com.fiap.helplife.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    EnderecoRepository repository;

    public List<Endereco> findAll(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();

        return repository.findByUsuario(usuario);
    }
}
