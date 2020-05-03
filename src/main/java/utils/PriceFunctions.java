package utils;

public class PriceFunctions {

    private static final String CURRENCY_SIGN = "£";

    public static double parsePrice(String value) {
        return Double.parseDouble(value.replace(CURRENCY_SIGN, ""));
    }
}
