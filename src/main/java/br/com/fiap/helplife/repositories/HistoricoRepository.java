package br.com.fiap.helplife.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.helplife.entities.Historico;
import br.com.fiap.helplife.entities.Usuario;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {
    List<Historico> findByUsuario(Usuario usuario);
}
