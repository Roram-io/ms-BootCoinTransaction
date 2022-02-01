package com.nttdata.msbootcointransaction.service;

import com.nttdata.msbootcointransaction.model.BootCoinTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootCoinTransactionService {

    Mono<BootCoinTransaction> createBootCoinTransaction(BootCoinTransaction bootCoinTransaction);

    Mono<BootCoinTransaction> processBootCoinTransaction(String id, String response);

    Flux<BootCoinTransaction> getTransactions();
}
