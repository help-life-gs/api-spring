package br.com.fiap.helplife.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "HISTORICO")
public class Historico {

    @Id
    @Column(name = "ID_HISTORICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "historico")
    private Long id;

    @Column(name = "TEMPERATURA")
    private Long temperatura;

    @Column(name = "OXIGENIO")
    private Long oxigenio;

    @Column(name = "BATIMENTOS")
    private Long batimentos;

    @Column(name = "DT_MEDICAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMedicao;

    @Column(name = "LATITUDE")
    private Long latitude;

    @Column(name = "LONGITUDE")
    private Long longitude;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    public Historico() {
    }

    public Historico(Long temperatura, Long oxigenio, Long batimentos, Long latitude, Long longitude, Date dataMedicao,
            Usuario usuario) {
        super();
        this.temperatura = temperatura;
        this.oxigenio = oxigenio;
        this.batimentos = batimentos;
        this.dataMedicao = dataMedicao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Long temperatura) {
        this.temperatura = temperatura;
    }

    public Long getOxigenio() {
        return oxigenio;
    }

    public void setOxigenio(Long oxigenio) {
        this.oxigenio = oxigenio;
    }

    public Long getBatimentos() {
        return batimentos;
    }

    public void setBatimentos(Long batimentos) {
        this.batimentos = batimentos;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Date getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(Date dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
