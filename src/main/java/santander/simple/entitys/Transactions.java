package santander.simple.entitys;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import santander.simple.Enums.TypeAcount;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "transactions")
@Table(name = "TB_transactions")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private TypeAcount sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private TypeAcount receiver;
    private LocalDateTime dataTransaction;

}
