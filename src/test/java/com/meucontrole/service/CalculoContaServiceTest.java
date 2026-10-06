package com.meucontrole.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculoContaServiceTest {

    private final CalculoContaService service =
            new CalculoContaService();


    @Test
    public void deveCalcularValorRestante() {

        double resultado =
                service.calcularValorRestante(237.00, 100.00);

        assertEquals(137.00, resultado, 0.001);
    }


    @Test
    public void deveRejeitarPagamentoNegativo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.calcularValorRestante(
                        237.00,
                        -10.00
                )
        );
    }


    @Test
    public void deveRejeitarPagamentoMaiorQueConta() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.calcularValorRestante(
                        100.00,
                        150.00
                )
        );
    }


    @Test
    public void deveRejeitarContaComValorZero() {

        assertThrows(
                IllegalArgumentException.class,
                () -> service.calcularValorRestante(
                        0.00,
                        0.00
                )
        );
    }


    @Test
    public void deveCalcularPagamentoTotal() {

        double resultado =
                service.calcularValorRestante(
                        200.00,
                        200.00
                );

        assertEquals(0.00, resultado, 0.001);
    }
}