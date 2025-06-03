package br.com.restaurant_manager.restaurant_manager.application.usecases.cliente;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;

public class TrocarSenhaCliente {
    private final RepositorioDeCliente repositorioCliente;

    public TrocarSenhaCliente(RepositorioDeCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public String trocarSenhaCliente(Long id, String senha){return this.repositorioCliente.trocarSenha(id, senha);}
}
