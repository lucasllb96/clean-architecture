package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.application.usecases.DeleteUser;
import br.com.alura.codechella.application.usecases.ListUsers;
import br.com.alura.codechella.application.usecases.UpdateUser;
import br.com.alura.codechella.domain.entities.usuario.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;
    private final ListUsers listUsers;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;

    public UserController(CreateUser createUser, ListUsers listUsers, UpdateUser updateUser, DeleteUser deleteUser) {
        this.createUser = createUser;
        this.listUsers = listUsers;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
    }

    @PostMapping
    public UserDto registerUser(@RequestBody UserDto dto) {
        User user = createUser.registerUser(new User(dto.cpf(), dto.name(), dto.dateOfBorn(), dto.email()));

        return new UserDto(user.getCpf(), user.getName(), user.getDateOfBorn(), user.getEmail());
    }

    @GetMapping
    public List<UserDto> ListUser() {
        return listUsers.listAllUsers().stream().map(user -> new UserDto(user.getCpf(), user.getName(),
                user.getDateOfBorn(), user.getEmail())).collect(Collectors.toList());
    }

    @PutMapping
    public UserDto updateUserEmail(@RequestBody UserDto dto) {
        User user = updateUser.updateUser(new User(dto.cpf(), dto.name(), dto.dateOfBorn(), dto.email()));

        return new UserDto(user.getCpf(), user.getName(), user.getDateOfBorn(), user.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void deleteUser(@PathVariable String cpf) {
        deleteUser.deleteUser(cpf);
    }
}
