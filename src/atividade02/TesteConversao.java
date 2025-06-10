package atividade02;

public class TesteConversao {

    public static void main(String[] args) {

        // Caso de Teste 1: Converter 25°C para Fahrenheit
        double celsius1 = 25.0;
        double fahrenheit1 = ConversorTemperatura.celsiusParaFahrenheit(celsius1);
        System.out.println(celsius1 + "°C é igual a " + fahrenheit1 + "°F");

        // Caso de Teste 2: Converter 77°F para Celsius
        double fahrenheit2 = 77.0;
        double celsius2 = ConversorTemperatura.fahrenheitParaCelsius(fahrenheit2);
        System.out.println(fahrenheit2 + "°F é igual a " + celsius2 + "°C");
    }

}
