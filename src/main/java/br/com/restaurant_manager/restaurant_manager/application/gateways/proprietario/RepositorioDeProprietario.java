package br.com.restaurant_manager.restaurant_manager.application.gateways.proprietario;

import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;

import java.util.List;
import java.util.Optional;

public interface RepositorioDeProprietario {
    Proprietario cadastrar(Proprietario proprietario);
    List<Proprietario> listar();
    Optional<Proprietario> buscarPorId(Long id);
    Proprietario atualizar(Long id, Proprietario proprietario);
    void remover(Long id);
    String trocarSenha(Long id, String senha);
    String validarAcesso(String login, String senha);
}
