package br.com.azindustria.azsim.domain.cliente.model;

import br.com.azindustria.azsim.domain.monitor.model.Monitoramento;
import br.com.azindustria.azsim.domain.monitor.model.Ronda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name = "cliente_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq")
    private Long id;

    @NotBlank
    @Column(length = 100)
    private String unidade;

    @Column(length = 20)
    private String habil;

    @Column(length = 20)
    private String condor;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private NaturezaEnum natureza;

    @NotBlank
    @Column(length = 20)
    private String documento;

    @Column(length = 20)
    private String inscMunicipal;

    @NotBlank
    @Column(length = 255)
    private String nome;

    @Column(length = 255)
    private String nomeFantasia;

    @Column(length = 255)
    private String endereco;

    @Column(length = 100)
    private String bairro;

    @Column(length = 100)
    private String cidade;

    @Column(length = 2)
    private String uf;

    @Column(length = 10)
    private String cep;

    @Column(length = 600)
    private String observacao;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Monitoramento> monitoramentos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Ronda> rondas;

}