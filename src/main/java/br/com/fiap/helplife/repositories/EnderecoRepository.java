package br.com.fiap.helplife.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.helplife.entities.Endereco;
import br.com.fiap.helplife.entities.Usuario;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    List<Endereco>findByUsuario(Usuario usuario);
}
