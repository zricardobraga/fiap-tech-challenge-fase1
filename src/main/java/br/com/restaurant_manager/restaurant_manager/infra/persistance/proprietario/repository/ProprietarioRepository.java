package br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.repository;

import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.entity.ProprietarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProprietarioRepository extends JpaRepository<ProprietarioEntity, Long> {
    Optional<ProprietarioEntity> findByEmail(String email);
    Optional<ProprietarioEntity> findByLogin(String login);
}
