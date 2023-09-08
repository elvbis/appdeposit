package com.polyglot.appdeposit.controller;


import com.polyglot.appdeposit.dto.TransactionRequest;
import com.polyglot.appdeposit.model.TransactionModel;
import com.polyglot.appdeposit.service.ITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    ITransactionService transactionService;

    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody TransactionRequest request) throws Exception {

        logger.info("Post: AccountId {} - Ammount {}", request.getAccountId(), request.getAmount());
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setAccountId(request.getAccountId());
        transactionModel.setAmount(request.getAmount());
        transactionModel.setType("deposit");
        transactionModel = transactionService.add(transactionModel);
        logger.info("transactionModel {}",transactionModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionModel);

    }

}
