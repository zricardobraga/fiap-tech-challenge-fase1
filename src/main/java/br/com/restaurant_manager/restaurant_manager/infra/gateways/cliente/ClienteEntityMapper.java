package br.com.restaurant_manager.restaurant_manager.infra.gateways.cliente;

import br.com.restaurant_manager.restaurant_manager.infra.persistance.cliente.entity.ClienteEntity;
import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;

public class ClienteEntityMapper {

    public ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(cliente.getId(), cliente.getNome(), cliente.getEmail(),
                cliente.getLogin(), cliente.getSenha(), cliente.getUltimaAlteracao(), cliente.getEndereco());
    }

    public Cliente toDomain(ClienteEntity clienteEntity) {
        return new Cliente(clienteEntity.getId(), clienteEntity.getNome(), clienteEntity.getEmail(),
                clienteEntity.getLogin(), clienteEntity.getSenha(), clienteEntity.getUltimaAlteracao(), clienteEntity.getEndereco());
    }
}
