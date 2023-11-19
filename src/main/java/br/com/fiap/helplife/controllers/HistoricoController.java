package br.com.fiap.helplife.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.helplife.entities.Historico;
import br.com.fiap.helplife.entities.Usuario;
import br.com.fiap.helplife.repositories.HistoricoRepository;
import br.com.fiap.helplife.services.HistoricoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    @Autowired
    HistoricoRepository repository;

    @Autowired
    HistoricoService service;

    @GetMapping
    public List<Historico> index() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Historico> show(@PathVariable Long id) {
        return ResponseEntity.ok(getHistorico(id));
    }

    @PostMapping
    public ResponseEntity<Historico> create(@RequestBody @Valid Historico historico) {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        historico.setUsuario(usuario);

        Date dataMedicao = new Date();
        historico.setDataMedicao(dataMedicao);

        repository.save(historico);
        return ResponseEntity.status(HttpStatus.CREATED).body(historico);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Historico> delete(@PathVariable Long id) {
        repository.delete(getHistorico(id));
        return ResponseEntity.noContent().build();
    }

    private Historico getHistorico(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "historico não encontrado"));
    }

}
