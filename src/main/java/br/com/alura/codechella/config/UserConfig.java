package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.application.usecases.CreateUser;
import br.com.alura.codechella.application.usecases.DeleteUser;
import br.com.alura.codechella.application.usecases.ListUsers;
import br.com.alura.codechella.application.usecases.UpdateUser;
import br.com.alura.codechella.infra.gateways.UserEntityMapper;
import br.com.alura.codechella.infra.gateways.UserRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUser createUser(UserRepository userRepository) {
        return new CreateUser(userRepository);
    }

    @Bean
    ListUsers listUsers(UserRepository userRepository) {
        return new ListUsers(userRepository);
    }

    @Bean
    UpdateUser updateUser(UserRepository userRepository) {
        return new UpdateUser(userRepository);
    }

    @Bean
    DeleteUser deleteUser(UserRepository userRepository) {
        return new DeleteUser(userRepository);
    }

    @Bean
    UserRepositoryJpa createJpaRepository(br.com.alura.codechella.infra.persistence.UserRepository repository,
                                          UserEntityMapper mapper) {
        return new UserRepositoryJpa(repository, mapper);
    }

    @Bean
    UserEntityMapper createMapper() {
        return new UserEntityMapper();
    }
}
