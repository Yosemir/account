package com.nttdata.account.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Account {


    private Long id;
    private Integer balance;        //Cuanto dinero tiene
    private String coin;            // Tipo de moneda
    private String typerAccount;    // Tipo de cuenta (Corriente, ahorro y plazo fijo)
    private Integer customer;       //Cliente
    private LocalDate date;           //Fecha de creacion

}