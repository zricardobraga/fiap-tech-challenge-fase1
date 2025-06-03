package br.com.restaurant_manager.restaurant_manager.infra.gateways.proprietario;

import br.com.restaurant_manager.restaurant_manager.infra.persistance.proprietario.entity.ProprietarioEntity;
import br.com.restaurant_manager.restaurant_manager.model.entities.proprietario.Proprietario;

public class ProprietarioEntityMapper {

    public ProprietarioEntity toEntity(Proprietario proprietario) {
        return new ProprietarioEntity(proprietario.getId(), proprietario.getNome(), proprietario.getEmail(),
                proprietario.getLogin(), proprietario.getSenha(), proprietario.getUltimaAlteracao(), proprietario.getEndereco());
    }

    public Proprietario toDomain(ProprietarioEntity proprietarioEntity) {
        return new Proprietario(proprietarioEntity.getId(), proprietarioEntity.getNome(), proprietarioEntity.getEmail(),
                proprietarioEntity.getLogin(), proprietarioEntity.getSenha(), proprietarioEntity.getUltimaAlteracao(), proprietarioEntity.getEndereco());
    }
}
