package br.com.restaurant_manager.restaurant_manager.application.usecases.cliente;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;

public class RemoverCliente {

    private final RepositorioDeCliente repositorioCliente;

    public RemoverCliente(RepositorioDeCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void removerCliente(Long id) {this.repositorioCliente.remover(id);}
}
