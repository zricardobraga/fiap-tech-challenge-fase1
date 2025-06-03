package br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;

import java.util.Optional;

public class BuscarProprietarioPorId {

    private final RepositorioDeProprietario repositorioProprietario;

    public BuscarProprietarioPorId(RepositorioDeProprietario repositorioProprietario) {
        this.repositorioProprietario = repositorioProprietario;
    }

    public Optional<Proprietario> buscarProprietarioPorId(Long id) {
        return this.repositorioProprietario.buscarPorId(id);
    }
}
