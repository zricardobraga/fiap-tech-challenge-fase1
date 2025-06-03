package br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;

public class CadastrarProprietario {

    private final RepositorioDeProprietario repositorioProprietario;

    public CadastrarProprietario(RepositorioDeProprietario repositorioProprietario) {
        this.repositorioProprietario = repositorioProprietario;
    }

    public Proprietario cadastrarProprietario(Proprietario proprietario) {
        return repositorioProprietario.cadastrar(proprietario);
    }
}
