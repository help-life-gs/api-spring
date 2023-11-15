package br.com.fiap.helplife.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.fiap.helplife.entities.Historico;
import br.com.fiap.helplife.entities.Usuario;
import br.com.fiap.helplife.repositories.HistoricoRepository;

@Service
public class HistoricoService {
    
    @Autowired
    HistoricoRepository repository;

    public List<Historico> findAll(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();

        return repository.findByUsuario(usuario);
    }
}
