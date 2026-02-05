package br.com.alura.codechella.infra.gateways;


import br.com.alura.codechella.domain.entities.usuario.User;
import br.com.alura.codechella.infra.persistence.UserEntity;
import br.com.alura.codechella.infra.persistence.UserRepository;

import java.util.List;

public class UserRepositoryJpa implements br.com.alura.codechella.application.gateways.UserRepository {

    private final UserRepository repository;

    private final UserEntityMapper mapper;

    public UserRepositoryJpa(UserRepository repository, UserEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User createUser(User user) {
        UserEntity entity = mapper.toEntity(user);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<User> listAll() {
        //return repository.findAll();
        return null;
    }

    @Override
    public User updateUser(String cpf, String email) {
        UserEntity entity = repository.findByCpf(cpf);
        entity.setEmail(email);
        repository.save(entity);
        return mapper.toDomain(entity);
    }
}
