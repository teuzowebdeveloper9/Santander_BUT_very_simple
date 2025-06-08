package santander.simple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import santander.simple.DTOs.TransactionDTO;
import santander.simple.Repositories.TransactionRepository;
import santander.simple.Repositories.UserRepositorie;
import santander.simple.entitys.Transactions;
import santander.simple.entitys.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class TransactionServices {

     @Autowired
     private User user;

     @Autowired
     private UserRepositorie userRepository;

     @Autowired
     UserServices userServices;

     @Autowired
    TransactionRepository transactionRepository;

     @Autowired
     Transactions transactions;

     @Autowired
    RestTemplate restTemplate;

    public void VerifySenderAndReceiver(UUID senderId, UUID receiverId, BigDecimal amount ) throws Exception {
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new Exception("Sender not found"));

        User receiver = userRepository.findById(receiverId)
                .orElseThrow(() -> new Exception("Receiver not found"));



        if (!this.autorizeTransaction(sender, transactions.getAmount())){
            throw  new Exception("authorization denied");
        }

    }
    public void CreateTransaction(TransactionDTO transactionDTO) {
        User sender = transactionDTO.sender();
        User receiver = transactionDTO.receiver();
        BigDecimal amount = transactionDTO.amount();


        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));


        Transactions newTransaction = new Transactions();
        newTransaction.setAmount(amount);
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setDataTransaction(LocalDateTime.now());


        userRepository.save(sender);
        userRepository.save(receiver);
        transactionRepository.save(newTransaction);
    }



    public boolean autorizeTransaction(User sender, BigDecimal value) {
        ResponseEntity<Map> response = restTemplate.getForEntity(
                "https://util.devi.tools/api/v2/authorize", Map.class);

        return response.getStatusCode() == HttpStatus.OK &&
                "success".equals(response.getBody().get("status"));
    }


}
