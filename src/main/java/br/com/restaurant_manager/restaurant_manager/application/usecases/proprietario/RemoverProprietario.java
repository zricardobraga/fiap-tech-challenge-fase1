package br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;

public class RemoverProprietario {

    private final RepositorioDeProprietario repositorioProprietario;

    public RemoverProprietario(RepositorioDeProprietario repositorioProprietario) {
        this.repositorioProprietario = repositorioProprietario;
    }

    public void removerProprietario(Long id) {
        this.repositorioProprietario.remover(id);
    }
}
