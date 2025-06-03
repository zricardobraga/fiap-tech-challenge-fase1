package br.com.restaurant_manager.restaurant_manager.config.cliente;

import br.com.restaurant_manager.restaurant_manager.application.gateways.cliente.RepositorioDeCliente;
import br.com.restaurant_manager.restaurant_manager.application.usecases.cliente.*;
import br.com.restaurant_manager.restaurant_manager.infra.gateways.cliente.ClienteEntityMapper;
import br.com.restaurant_manager.restaurant_manager.infra.gateways.cliente.RepositorioDeClienteJPA;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.cliente.repository.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    RepositorioDeClienteJPA criarRepositorioDeClienteJPA(ClienteRepository clienteRepository, ClienteEntityMapper clienteEntityMapper){
        return new RepositorioDeClienteJPA(clienteRepository, clienteEntityMapper);
    }

    @Bean
    ClienteEntityMapper retornarClienteEntityMapper(){
        return new ClienteEntityMapper();
    }

    @Bean
    CadastrarCliente criarCliente(RepositorioDeCliente repositorioDeCliente){
        return new CadastrarCliente(repositorioDeCliente);
    }

    @Bean
    ListarClientes listarClientes(RepositorioDeCliente repositorioDeCliente){
        return new ListarClientes(repositorioDeCliente);
    }

    @Bean
    BuscarClientePorId buscarClientePorId(RepositorioDeCliente repositorioDeCliente){
        return new BuscarClientePorId(repositorioDeCliente);
    }

    @Bean
    AtualizarCliente atualizarCliente(RepositorioDeCliente repositorioDeCliente){
        return new AtualizarCliente(repositorioDeCliente);
    }

    @Bean
    TrocarSenhaCliente trocarSenhaCliente(RepositorioDeCliente repositorioDeCliente){
        return new TrocarSenhaCliente(repositorioDeCliente);
    }

    @Bean
    RemoverCliente apagarCliente(RepositorioDeCliente repositorioDeCliente){
        return new RemoverCliente(repositorioDeCliente);
    }

    @Bean
    ValidarAcessoCliente validarAcessoCliente(RepositorioDeCliente repositorioDeCliente){
        return new ValidarAcessoCliente(repositorioDeCliente);
    }

}
