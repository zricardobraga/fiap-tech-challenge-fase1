package br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;
import java.util.Optional;

public class AtualizarProprietario {

    private final RepositorioDeProprietario repositorioProprietario;

    public AtualizarProprietario(RepositorioDeProprietario repositorioProprietario) {
        this.repositorioProprietario = repositorioProprietario;
    }

    public Proprietario atualizarProprietario(Long id, Proprietario proprietario){
        return this.repositorioProprietario.atualizar(id, proprietario);
    }
}
