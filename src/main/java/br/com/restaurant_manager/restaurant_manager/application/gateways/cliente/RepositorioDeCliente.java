package br.com.restaurant_manager.restaurant_manager.application.gateways.cliente;

import br.com.restaurant_manager.restaurant_manager.model.entities.cliente.Cliente;

import java.util.List;
import java.util.Optional;

public interface RepositorioDeCliente {

    Cliente cadastrar(Cliente cliente);
    List<Cliente> listar();
    Optional<Cliente> buscarPorId(Long id);
    Cliente atualizar(Long id, Cliente cliente);
    void remover(Long id);
    String trocarSenha(Long id, String senha);
    String validarAcesso(String login, String senha);
}
