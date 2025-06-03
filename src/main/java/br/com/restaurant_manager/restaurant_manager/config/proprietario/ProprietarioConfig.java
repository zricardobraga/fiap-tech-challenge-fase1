package br.com.restaurant_manager.restaurant_manager.config.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;
import br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario.*;
import br.com.restaurant_manager.restaurant_manager.infra.gateways.proprietario.ProprietarioEntityMapper;
import br.com.restaurant_manager.restaurant_manager.infra.gateways.proprietario.RepositorioDeProprietarioJPA;
import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.repository.ProprietarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProprietarioConfig {

    @Bean
    RepositorioDeProprietarioJPA criarRepositorioDeProprietarioJPA(ProprietarioRepository proprietarioRepository, ProprietarioEntityMapper proprietarioEntityMapper){
        return new RepositorioDeProprietarioJPA(proprietarioRepository, proprietarioEntityMapper);
    }

    @Bean
    ProprietarioEntityMapper retornarProprietarioEntityMapper(){
        return new ProprietarioEntityMapper();
    }

    @Bean
    CadastrarProprietario criarProprietario(RepositorioDeProprietario repositorioDeProprietario){
        return new CadastrarProprietario(repositorioDeProprietario);
    }

    @Bean
    ListarProprietarios listarProprietarios(RepositorioDeProprietario repositorioDeProprietario){
        return new ListarProprietarios(repositorioDeProprietario);
    }

    @Bean
    BuscarProprietarioPorId buscarProprietarioPorId(RepositorioDeProprietario repositorioDeProprietario){
        return new BuscarProprietarioPorId(repositorioDeProprietario);
    }

    @Bean
    AtualizarProprietario atualizarProprietario(RepositorioDeProprietario repositorioDeProprietario){
        return new AtualizarProprietario(repositorioDeProprietario);
    }

    @Bean
    TrocarSenhaProprietario trocarSenhaProprietario(RepositorioDeProprietario repositorioDeProprietario){
        return new TrocarSenhaProprietario(repositorioDeProprietario);
    }

    @Bean
    RemoverProprietario apagarProprietario(RepositorioDeProprietario repositorioDeProprietario){
        return new RemoverProprietario(repositorioDeProprietario);
    }

    @Bean
    ValidarAcessoProprietario validarAcessoProprietario(RepositorioDeProprietario repositorioDeProprietario){
        return new ValidarAcessoProprietario(repositorioDeProprietario);
    }
}
