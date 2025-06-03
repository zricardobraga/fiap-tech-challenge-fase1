package br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.entity;

import br.com.restaurant_manager.restaurant_manager.model.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "proprietarios")
@Getter
@Setter
public class ProprietarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private Date ultimaAlteracao;
    @Embedded
    private Endereco endereco;

    public ProprietarioEntity() {}

    public ProprietarioEntity(Long id, String nome, String email, String login, String senha, Date ultimaAlteracao, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.ultimaAlteracao = ultimaAlteracao;
        this.endereco = endereco;
    }
}
