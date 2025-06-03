package br.com.restaurant_manager.restaurant_manager.infra.exceptions.dtos;

import java.util.List;

public record ValidationErrorDTO(List<String> errors, int status) {
}
