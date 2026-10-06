package com.meucontrole.service;

import org.springframework.stereotype.Service;

@Service
public class CalculoContaService {

    public double calcularValorRestante(double valorConta, double valorPago) {

        if (valorConta <= 0) {
            throw new IllegalArgumentException(
                    "O valor da conta deve ser maior que zero."
            );
        }

        if (valorPago < 0) {
            throw new IllegalArgumentException(
                    "O valor pago não pode ser negativo."
            );
        }

        if (valorPago > valorConta) {
            throw new IllegalArgumentException(
                    "O valor pago não pode ser maior que o valor da conta."
            );
        }

        return valorConta - valorPago;
    }
}