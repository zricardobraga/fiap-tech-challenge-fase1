package br.com.restaurant_manager.restaurant_manager.model.entities.cliente;

import br.com.restaurant_manager.restaurant_manager.model.Endereco;

import java.util.Date;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private Date ultimaAlteracao;
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String nome, String email, String login, String senha, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Cliente(Long id, String nome, String email, String login, String senha, Date ultimaAlteracao, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public Date setUltimaAlteracao(Date ultimaAlteracao) { this.ultimaAlteracao = ultimaAlteracao;
        return ultimaAlteracao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
