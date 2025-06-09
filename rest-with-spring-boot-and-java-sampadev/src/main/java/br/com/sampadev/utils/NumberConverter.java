package br.com.sampadev.utils;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return 0D;
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
