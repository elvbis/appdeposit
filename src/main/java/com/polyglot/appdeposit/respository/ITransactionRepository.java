package com.polyglot.appdeposit.respository;

import com.polyglot.appdeposit.model.TransactionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends CrudRepository<TransactionModel, Long> {

}
