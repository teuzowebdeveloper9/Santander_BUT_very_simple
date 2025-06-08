package santander.simple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

@Service
public class TransactionServices {


    @Autowired
    private UserRepositorie userRepository;

    @Autowired
    private UserServices userServices;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    AlertService alertService;



    public void verifySenderAndReceiver(UUID senderId, UUID receiverId, BigDecimal amount) throws Exception {
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new Exception("Sender not found"));

        User receiver = userRepository.findById(receiverId)
                .orElseThrow(() -> new Exception("Receiver not found"));

        if (!this.autorizeTransaction(sender, amount)) {  // Usamos o amount passado como parâmetro
            throw new Exception("Authorization denied");
        }
    }

    public Transactions createTransaction(TransactionDTO transactionDTO) throws Exception {

        User senderUser = userRepository.findById(transactionDTO.sender())
                .orElseThrow(() -> new Exception("Sender not found"));

        User receiverUser = userRepository.findById(transactionDTO.receiver())
                .orElseThrow(() -> new Exception("Receiver not found"));

        BigDecimal amount = transactionDTO.amount();


        senderUser.setBalance(senderUser.getBalance().subtract(amount));
        receiverUser.setBalance(receiverUser.getBalance().add(amount));


        Transactions newTransaction = new Transactions();
        newTransaction.setAmount(amount);
        newTransaction.setSender(senderUser);
        newTransaction.setReceiver(receiverUser);
        newTransaction.setDataTransaction(LocalDateTime.now());


        userRepository.save(senderUser);
        userRepository.save(receiverUser);
        transactionRepository.save(newTransaction);


        return newTransaction;
    }

    public boolean autorizeTransaction(User sender, BigDecimal value) {
        ResponseEntity<Map> response = restTemplate.getForEntity(
                "https://util.devi.tools/api/v2/authorize", Map.class);

        return response.getStatusCode() == HttpStatus.OK &&
                "success".equals(response.getBody().get("status"));
    }
}