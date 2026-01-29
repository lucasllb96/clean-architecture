package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.usuario.User;
import br.com.alura.codechella.infra.persistence.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getCpf(), user.getName(),
                user.getDateOfBorn(), user.getEmail());
    }

    public User toDomain(UserEntity user) {
        return new User(user.getCpf(), user.getName(),
                user.getDateOfBorn(), user.getEmail());
    }

}
