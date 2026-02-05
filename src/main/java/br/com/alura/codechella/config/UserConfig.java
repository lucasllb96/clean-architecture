package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.application.usecases.CreateUser;
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
    UserRepositoryJpa createJpaRepository(br.com.alura.codechella.infra.persistence.UserRepository repository,
                                          UserEntityMapper mapper) {
        return new UserRepositoryJpa(repository, mapper);
    }

    @Bean
    UserEntityMapper createMapper() {
        return new UserEntityMapper();
    }
}
