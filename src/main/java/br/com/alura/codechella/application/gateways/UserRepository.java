package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.usuario.User;

import java.util.List;

public interface UserRepository {

    User createUser(User user);

    List<User> listAll();

    User updateUserEmail(String cpf, String email);

    void deleteUser(String cpf);
}
