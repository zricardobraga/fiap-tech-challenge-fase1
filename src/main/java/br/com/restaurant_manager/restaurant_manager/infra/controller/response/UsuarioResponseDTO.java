package br.com.restaurant_manager.restaurant_manager.infra.controller.response;

import br.com.restaurant_manager.restaurant_manager.model.Endereco;

import java.util.Date;

public record UsuarioResponseDTO(Long id, String nome, String email, String login, String senha, Date ultimaAlteracao, Endereco endereco) {
}
