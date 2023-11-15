package br.com.fiap.helplife.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.helplife.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}