package br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;

public class ValidarAcessoProprietario {

    private final RepositorioDeProprietario repositorioProprietario;

    public ValidarAcessoProprietario(RepositorioDeProprietario repositorioProprietario) {
        this.repositorioProprietario = repositorioProprietario;
    }

    public String validarAcessoProprietario(String login, String senha) {
        return this.repositorioProprietario.validarAcesso(login, senha);
    }
}
