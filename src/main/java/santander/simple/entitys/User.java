package santander.simple.entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import santander.simple.DTOs.UserDTO;
import santander.simple.Enums.TypeAcount;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "TB_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private BigDecimal balance;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private  String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private TypeAcount typeAcount;

    public User() {
    }


    public User(UUID id, String firstName, String lastName, BigDecimal balance,
                String document, String email, String password, TypeAcount typeAcount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.document = document;
        this.email = email;
        this.password = password;
        this.typeAcount = typeAcount;
    }


    public User(UserDTO data){

        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.balance = data.balance();
        this.typeAcount = data.typeAcount();
        this.password = data.password();
        this.email = data.email();
        this.document = data.document();

    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TypeAcount getTypeAcount() {
        return typeAcount;
    }

    public void setTypeAcount(TypeAcount typeAcount) {
        this.typeAcount = typeAcount;
    }
}
