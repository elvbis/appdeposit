package com.polyglot.appdeposit.service;

import com.polyglot.appdeposit.model.TransactionModel;
import com.polyglot.appdeposit.respository.ITransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService  implements ITransactionService {

    @Autowired
    private ITransactionRepository transactionRepositoy;

    @Override
    @Transactional
    public TransactionModel add(TransactionModel transactionModel) {
        return transactionRepositoy.save(transactionModel);
    }

}