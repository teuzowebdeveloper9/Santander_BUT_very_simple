package santander.simple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santander.simple.DTOs.UserDTO;
import santander.simple.Enums.TypeAcount;
import santander.simple.Repositories.UserRepositorie;
import santander.simple.entitys.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class UserServices {

    @Autowired
    private UserRepositorie userRepositorie;


    public BigDecimal applyTaxIfBusiness(User sender, BigDecimal amount) {
        if (sender.getTypeAcount() == TypeAcount.BUSINESS) {
            BigDecimal taxRate = new BigDecimal("0.0015");
            BigDecimal tax = amount.multiply(taxRate);
            return amount.add(tax);
        }
        return amount;
    }
    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getBalance().compareTo(amount) < 0 ){
            throw  new Exception("your transaction goes beyond your balance");
        }
        if (sender == null || sender.getBalance() == null || amount == null) {
            throw new IllegalArgumentException("Invalid sender or amount");
        }
    }

    public User findUserByid(UUID id) throws Exception {
       return this.userRepositorie.findUserById(id).orElseThrow(() -> new  Exception("USER NOT FOUND"));
    }

    public void saveUser(User user){
        this.userRepositorie.save(user);
    }
    public User createUser(UserDTO data){
          User newUser = new User(data);
          saveUser(newUser);
          return  newUser;
    }
    public List<User> getAllUsers(){
        return this.userRepositorie.findAll();
    }

}
