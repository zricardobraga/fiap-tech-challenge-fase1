package br.com.restaurant_manager.restaurant_manager.infra.persistance.cliente.repository;

import br.com.restaurant_manager.restaurant_manager.infra.persistance.cliente.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByEmail(String email);
    Optional<ClienteEntity> findByLogin(String login);
}
