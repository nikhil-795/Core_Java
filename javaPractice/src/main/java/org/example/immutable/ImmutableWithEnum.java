package org.example.immutable;

//100% immutable against reflection
enum Currency {
    USD("United States Dollar", "$"),
    EUR("Euro", "€"),
    INR("Indian Rupee", "₹");

    private final String fullName;
    private final String symbol;

    // Private constructor - ensures immutability
     Currency(String fullName, String symbol) {
        this.fullName = fullName;
        this.symbol = symbol;
    }

    // Only getters - no setters
    public String getFullName() {
        return fullName;
    }

    public String getSymbol() {
        return symbol;
    }
}


public class ImmutableWithEnum {
    public static void main(String[] args) {
        Currency c1 = Currency.USD;
        System.out.println(c1.getFullName()); // United States Dollar
        System.out.println(c1.getSymbol());   // $

        // Cannot change values → fully immutable
        // c1.symbol = "??"; ❌ compile error
    }
}
