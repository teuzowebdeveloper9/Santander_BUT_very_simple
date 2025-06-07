package santander.simple.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import santander.simple.entitys.User;

import java.util.UUID;

public interface userRepositorie  extends JpaRepository<User, UUID> {
}
