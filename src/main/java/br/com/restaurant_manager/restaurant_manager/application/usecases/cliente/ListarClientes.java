package br.com.restaurant_manager.restaurant_manager.application.usecases.cliente;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;

import java.util.List;

public class ListarClientes {

    public final RepositorioDeCliente repositorioCliente;

    public ListarClientes(RepositorioDeCliente repositorioCliente) {

        this.repositorioCliente = repositorioCliente;
    }

    public List<Cliente> listarTodosOsClientes() {return repositorioCliente.listar();}
}
