package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.usuario.User;

import java.util.List;

public class ListUsers {

    private final UserRepository repository;

    public ListUsers(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> listAllUsers() {
        return this.repository.listAll();
    }
}
