package br.com.alura.codechella.naousar.service;

import br.com.alura.codechella.infra.persistence.UserEntity;

import java.util.List;

public interface UsuarioService {
    UserEntity cadastrarUsuario(UserEntity usuario);

    List<UserEntity> listarTodos();
}
