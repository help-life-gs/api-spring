package br.com.fiap.helplife.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @Column(name = "ID_ENDERECO")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "endereco")
    private Long id;

    @Column(name = "CEP", nullable = false, length = 8)
    private String cep;

    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;

    @Column(name = "CIDADE", nullable = false, length = 100)
    private String cidade;

    @Column(name = "LOGRADOURO", nullable = false, length = 100)
    private String logradouro;

    @Column(name = "NUMERO", nullable = false, length = 5)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    public Endereco() {
    }

    public Endereco(String cep, String estado, String cidade, String logradouro, String numero, Usuario usuario) {
        super();
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
