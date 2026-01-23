package br.com.alura.codechella.domain;

import br.com.alura.codechella.domain.entities.usuario.User;

import java.time.LocalDate;

public class UserFactory {

    private User user;

    public User nameCpfDateOfBorn(String name, String cpf, LocalDate dateOfBorn){
        this.user = new User(cpf, name, dateOfBorn, "");
        return this.user;
    }

    public User addAddress(String cep, Integer number, String complement) {
        this.user.setAddress(new Address(cep, number, complement));
        return this.user;
    }

}
