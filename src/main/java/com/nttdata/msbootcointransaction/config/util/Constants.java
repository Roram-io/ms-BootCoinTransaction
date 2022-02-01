package com.nttdata.msbootcointransaction.config.util;

import org.springframework.beans.factory.annotation.Value;

public abstract class Constants {

    @Value("${value.exchangeRate}")
    public static final double exchangeRate=20.35;
}
