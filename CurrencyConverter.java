import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);       
        exchangeRates.put("EUR", 0.85);      
        exchangeRates.put("GBP", 0.75);      
        exchangeRates.put("INR", 74.0);      
        exchangeRates.put("JPY", 110.0);     
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Currencies: USD, EUR, GBP, INR, JPY");
        System.out.print("Enter the base currency: ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency: ");
        String targetCurrency = scanner.next().toUpperCase();
        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid currency entered. Please try again.");
            return;
        }
        System.out.print("Enter the amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();
        double baseToUsdRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);
        double amountInUsd = amount / baseToUsdRate;
        double convertedAmount = amountInUsd * targetRate;
        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        scanner.close();
    }
}
