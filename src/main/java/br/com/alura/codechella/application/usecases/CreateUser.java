package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.usuario.User;

public class CreateUser {

    private final UserRepository repository;

    public CreateUser(UserRepository repository) {
        this.repository = repository;
    }

    public User registerUser(User user) {
        return repository.createUser(user);
    }
}
