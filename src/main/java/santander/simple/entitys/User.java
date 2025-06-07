package santander.simple.entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import santander.simple.Enums.TypeAcount;

import java.util.UUID;

@Entity(name = "users")
@Table(name = "TB_users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String FirstName;
    private String LastName;
    @Column(unique = true)
    private String CPF;
    @Column(unique = true)
    private  String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private TypeAcount typeAcount;

}
