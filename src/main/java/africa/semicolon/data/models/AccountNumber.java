package africa.semicolon.data.models;

import java.security.SecureRandom;

public class AccountNumber {

    public static void main(String[] args) {
        System.out.println(accountNumber());
    }
    private static String accountNumber() {
        String a = "0123456789";

        char[] arr = new char[10];
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 10; i++) {
            arr[i] = a.charAt(random.nextInt(a.length()));
        }
        return new String(arr);
    }

}


