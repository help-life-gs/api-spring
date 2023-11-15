package br.com.fiap.helplife.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.helplife.entities.Endereco;
import br.com.fiap.helplife.entities.Usuario;
import br.com.fiap.helplife.repositories.EnderecoRepository;
import br.com.fiap.helplife.services.EnderecoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    EnderecoRepository repository;

    @Autowired
    EnderecoService service;

    @GetMapping
    public List<Endereco> index() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Endereco> show(@PathVariable Long id) {
        return ResponseEntity.ok(getEndereco(id));
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody @Valid Endereco endereco) {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        endereco.setUsuario(usuario);
        repository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @PutMapping("{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody @Valid Endereco endereco) {
        getEndereco(id);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        endereco.setUsuario(usuario);
        endereco.setId(id);
        repository.save(endereco);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Endereco> delete(@PathVariable Long id) {
        repository.delete(getEndereco(id));
        return ResponseEntity.noContent().build();
    }

    private Endereco getEndereco(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "endereço não encontrado"));
    }

}
