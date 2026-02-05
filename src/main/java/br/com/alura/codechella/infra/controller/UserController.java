package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.application.usecases.UpdateUser;
import br.com.alura.codechella.domain.entities.usuario.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;

//    private final UpdateUser updateUser;


    public UserController(CreateUser createUser/*, UpdateUser updateUser*/) {
        this.createUser = createUser;
//        this.updateUser = updateUser;
    }

    @PostMapping
    public UserDto registerUser(@RequestBody UserDto dto) {
        User user = createUser.registerUser(new User(dto.cpf(), dto.name(), dto.dateOfBorn(), dto.email()));

        return new UserDto(user.getCpf(), user.getName(), user.getDateOfBorn(), user.getEmail());
    }

//    @PutMapping
//    public UserDto updateUser(@RequestBody UserDto dto) {
//        User user = updateUser.updateUser(new User(dto.cpf(), dto.name(), dto.dateOfBorn(), dto.email()));
//
//        return new UserDto(user.getCpf(), user.getName(), user.getDateOfBorn(), user.getEmail());
//    }
}
