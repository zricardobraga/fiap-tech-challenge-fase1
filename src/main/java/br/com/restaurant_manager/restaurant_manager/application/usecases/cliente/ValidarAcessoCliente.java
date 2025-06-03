package br.com.restaurant_manager.restaurant_manager.application.usecases.cliente;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;

public class ValidarAcessoCliente {

    private final RepositorioDeCliente repositorioCliente;

    public ValidarAcessoCliente(RepositorioDeCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public String validarAcessoCliente(String login, String senha) {return this.repositorioCliente.validarAcesso(login, senha);}
}
