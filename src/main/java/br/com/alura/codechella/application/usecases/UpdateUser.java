package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.usuario.User;

public class UpdateUser {

    private UserRepository repository;

    public UpdateUser(UserRepository repository) {
        this.repository = repository;
    }

    public User updateUser(User user) {
        return repository.updateUser(user.getCpf(), user.getEmail());
    }
}
