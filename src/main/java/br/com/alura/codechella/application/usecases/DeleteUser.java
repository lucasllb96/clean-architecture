package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.usuario.User;

import java.util.List;

public class DeleteUser {

    private final UserRepository repository;

    public DeleteUser(UserRepository repository) {
        this.repository = repository;
    }

    public void deleteUser(String cpf) {
        this.repository.deleteUser(cpf);
    }

}
