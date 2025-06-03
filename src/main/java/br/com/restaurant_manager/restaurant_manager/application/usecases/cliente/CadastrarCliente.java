package br.com.restaurant_manager.restaurant_manager.application.usecases.cliente;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;

public class CadastrarCliente {

    private final RepositorioDeCliente repositorioCliente;

    public CadastrarCliente(RepositorioDeCliente repositorioCliente) {

        this.repositorioCliente = repositorioCliente;
    }

    public Cliente cadastrarCliente(Cliente cliente){return this.repositorioCliente.cadastrar(cliente);}


}
