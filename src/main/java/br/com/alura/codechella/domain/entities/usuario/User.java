package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;
import java.time.Period;

import br.com.alura.codechella.domain.Address;

public class User {

    private String cpf;

    private String name;

    private LocalDate dateOfBorn;

    private String email;

    private Address address;

    public User(String cpf, String name, LocalDate dateOfBorn, String email) {
        validateCpf(cpf);
        isUserLegalAge(dateOfBorn);

        this.cpf = cpf;
        this.name = name;
        this.dateOfBorn = dateOfBorn;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(LocalDate dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    private void validateCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Cpf out of pattern!");
        }
    }

    private void isUserLegalAge(LocalDate born) {
        if (born == null) {
            throw new IllegalArgumentException("The user does not have date of birth");
        }

        if (Period.between(born, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("The user does not have legal age");
        }
    }
}
