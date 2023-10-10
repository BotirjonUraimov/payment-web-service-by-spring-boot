package com.payment.paymentwebservice.web.res;

import com.payment.paymentwebservice.domain.Transaction;
import com.payment.paymentwebservice.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionResource {

    public final TransactionService transactionService;

    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transactions")
    public ResponseEntity create(@RequestBody Transaction transaction) {
        Transaction transaction1 = transactionService.save(transaction);
        return ResponseEntity.ok(transaction1);
    }
    @GetMapping("/transactions")
    public ResponseEntity getAll() {
        List<Transaction> transactions = transactionService.findAll();
        return ResponseEntity.ok(transactions);
    }


}
