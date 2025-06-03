package br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;

public class TrocarSenhaProprietario {

    private final RepositorioDeProprietario repositorioProprietario;

    public TrocarSenhaProprietario(RepositorioDeProprietario repositorioProprietario) {
        this.repositorioProprietario = repositorioProprietario;
    }

    public String trocarSenha(Long id, String senha){
        return this.repositorioProprietario.trocarSenha(id, senha);
    }
}
