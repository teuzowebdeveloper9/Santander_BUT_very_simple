package santander.simple.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import santander.simple.entitys.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositorie extends JpaRepository<User, UUID> {


    Optional<User> findUserByDocument(String document);

    Optional<User> findUserById(UUID id);
}
