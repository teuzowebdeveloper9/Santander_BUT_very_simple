package santander.simple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import santander.simple.DTOs.TransactionDTO;
import santander.simple.entitys.Transactions;
import santander.simple.services.TransactionServices;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionServices transactionServices;

    @PostMapping("/")
    public ResponseEntity<Transactions> createTransaction( @RequestBody TransactionDTO transactionDTO) throws Exception{
      Transactions newTrandaction  = this.transactionServices.createTransaction(transactionDTO);

      return new ResponseEntity<>(newTrandaction, HttpStatus.OK);

    }
    @GetMapping("/")
    public ResponseEntity<List<Transactions>>  getTransactions (){
        List<Transactions> Alltransactions = this.transactionServices.getAllTransaction();

        return  new ResponseEntity<>(Alltransactions, HttpStatus.OK);
    }
}
