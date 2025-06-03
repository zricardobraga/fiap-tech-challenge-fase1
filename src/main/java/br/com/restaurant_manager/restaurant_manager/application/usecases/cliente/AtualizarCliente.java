package br.com.restaurant_manager.restaurant_manager.application.usecases.cliente;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;

public class AtualizarCliente {

    private final RepositorioDeCliente repositorioCliente;

    public AtualizarCliente(RepositorioDeCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Cliente atualizarCliente(Long id, Cliente cliente){return this.repositorioCliente.atualizar(id, cliente);}
}
