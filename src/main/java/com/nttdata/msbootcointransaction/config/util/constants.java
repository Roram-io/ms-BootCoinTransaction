package com.nttdata.msbootcointransaction.config.util;

import org.springframework.beans.factory.annotation.Value;

public abstract class constants {

    @Value("${value.exchangeRate}")
    public static double exchangeRate;
}
