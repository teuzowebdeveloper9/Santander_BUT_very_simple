package santander.simple.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import santander.simple.entitys.Transactions;

import java.util.UUID;

public interface TransactionRepository  extends JpaRepository<Transactions, UUID> {

}
