package com.conversor;

public class App {
    
    // Método 1: Celsius para Fahrenheit
    public double celsiusParaFahrenheit(double celsius) {
        return (celsius * 1.8) + 32
    }

    // Método 2: Fahrenheit para Celsius
    public double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

    public static void main(String[] args) {
        System.out.println("Conversor de Temperatura Pronto!");
    }
}