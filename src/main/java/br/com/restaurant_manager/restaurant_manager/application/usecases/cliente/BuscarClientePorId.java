package br.com.restaurant_manager.restaurant_manager.application.usecases.cliente;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;

import java.util.Optional;

public class BuscarClientePorId {
    private final RepositorioDeCliente repositorioCliente;

    public BuscarClientePorId(RepositorioDeCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }
    public Optional<Cliente> buscarClientePorId(Long id) {return this.repositorioCliente.buscarPorId(id);}
}
