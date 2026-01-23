package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserTest {

    @Test
    public void shouldNotRegisterCpfOutOfPattern() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("123456789-99", "Lucas", LocalDate.parse("1990-01-01"), "email@email.com"));
    }

    @Test
    public void shouldNotRegisterUnderLegalAge() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("123.456.789-99", "Lucas", LocalDate.now().minusYears(17), "email@email.com"));
    }

    @Test
    public void shouldNotRegisterUsingUserFactory (){
        UserFactory factory = new UserFactory();

        IllegalArgumentException exception =
                Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    factory.nameCpfDateOfBorn(
                            "Emily",
                            "654.123.897-88",
                            LocalDate.parse("2011-10-01")
                    );
                });

        Assertions.assertEquals(
                "The user does not have legal age",
                exception.getMessage()
        );
    }
}
