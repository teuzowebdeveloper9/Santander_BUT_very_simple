package santander.simple.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import santander.simple.entitys.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositorie extends JpaRepository<User, UUID> {

    Optional<User> findUserById(UUID id);

    @Query("SELECT u FROM User u" +
            " WHERE u.firstName = :firstName AND u.lastName = " +
            ":lastName AND (u.email = :email OR u.document = :document)")
    Optional<User> findForAuth(@Param("firstName") String firstName,
                               @Param("lastName") String lastName,
                               @Param("email") String email,
                               @Param("document") String document);
}
