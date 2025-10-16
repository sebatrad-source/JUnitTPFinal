package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CuentaBancaria {
    private double saldo;

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El deposito debe ser mayor a cero");
        }
        saldo += monto;
    }
    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El retiro debe ser mayor a cero");
        }
        if (monto > saldo) {
            throw new IllegalStateException("Fondos Insuficientes");
        }
        saldo -= monto;
    }
}