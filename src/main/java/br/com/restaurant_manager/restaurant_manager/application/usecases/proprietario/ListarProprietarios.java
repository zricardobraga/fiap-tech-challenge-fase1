package br.com.restaurant_manager.restaurant_manager.application.usecases.proprietario;

import br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario.RepositorioDeProprietario;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;

import java.util.List;

public class ListarProprietarios {

    private final RepositorioDeProprietario repositorioProprietario;

    public ListarProprietarios(RepositorioDeProprietario repositorioProprietario) {
        this.repositorioProprietario = repositorioProprietario;
    }

    public List<Proprietario> listarTodosOsProprietarios() {
        return this.repositorioProprietario.listar();
    }
}
