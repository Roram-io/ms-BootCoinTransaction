package com.nttdata.msbootcointransaction.service.impl;

import com.nttdata.msbootcointransaction.model.BootCoinTransaction;
import com.nttdata.msbootcointransaction.model.BootCoinUser;
import com.nttdata.msbootcointransaction.repository.BootCoinTransactionRepository;
import com.nttdata.msbootcointransaction.service.BootCoinTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootCoinTransactionServiceImpl implements BootCoinTransactionService {
    @Autowired
    WebClient webClientUser;

    @Autowired
    BootCoinTransactionRepository bootCoinTransactionRepository;

    Logger log = LoggerFactory.getLogger(BootCoinTransactionServiceImpl.class);

    @Override
    public Mono<BootCoinTransaction> createBootCoinTransaction(BootCoinTransaction bootCoinTransaction) {
        log.info("Creating order, validating amount and price of bootcoin");
        if (bootCoinTransaction.getBcAmount()>0 && bootCoinTransaction.getPrice()>0) return
        bootCoinTransactionRepository.save(bootCoinTransaction);
        else return Mono.empty();
    }

    @Override
    public Mono<BootCoinTransaction> processBootCoinTransaction(String id, String response) {
        return bootCoinTransactionRepository.findById(id).flatMap(element-> {
            if (response.equals("Accept")){
                element.setStatus("Accepted");
                return webClientUser.post()
                        .uri("http://localhost:8886/api/v1/bootcoinuser/transaction")
                        .body(Mono.just(element), BootCoinTransaction.class)
                        .retrieve().bodyToMono(BootCoinTransaction.class);
            }

            else if (response.equals("Reject")) element.setStatus("Rejected");
                return bootCoinTransactionRepository.save(element);
        });

    }

    @Override
    public Flux<BootCoinTransaction> getTransactions() {
        log.info("Listing all transactions. ");
        return bootCoinTransactionRepository.findAll();
    }
}
