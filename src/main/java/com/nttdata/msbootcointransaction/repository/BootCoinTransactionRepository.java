package com.nttdata.msbootcointransaction.repository;

import com.nttdata.msbootcointransaction.model.BootCoinTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootCoinTransactionRepository extends ReactiveMongoRepository<BootCoinTransaction, String> {
}
