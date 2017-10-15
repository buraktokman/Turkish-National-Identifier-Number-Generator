import java.util.Random;

public class TNI {
    protected static String getSaltString() {
        String SALTCHARS = "0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 11) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static boolean checkNumber(String number) {
        int oddDigits = 0;
        int evenDigits = 0;
        // (sum of the 1,3,5,7,9 digits multiplied with 7) - (sum of the 2,4,6,8 digit)
        // modulus 10 of the number must be equal to 10th digit
        int rule;
        int sum = 0;

        // lenght must be 11
        if (number.length() < 11) { return false; }

        // cannot start with 0
        if (number.startsWith("0")) { return false; }

        // char array to int array.
        char arrChar[] = number.toCharArray();
        int[] arr = new int[arrChar.length];
        for (int i = 0; i < arrChar.length; i++) { arr[i] = Integer.parseInt(arrChar[i] + "");  }

        //last digit cannnot be an odd digit
        if (arr[10] % 2 != 0) { return false; }

        //modulus 10 of the subtraction of the odd digits and even digits must be equal to 10th digit
        for (int i = 0; i < 9; i++) {
            // System.out.println("Data : " + i + " : " + arr[i]);
            sum += arr[i];
            if ((i % 2) == 0) { oddDigits += arr[i]; }
            else { evenDigits += arr[i]; }
        }

        sum += arr[9];
        rule = ((oddDigits * 7) - evenDigits);

        if (rule % 10 != arr[9]) { return false; }

        // modulus 10 of the sum of the first 10 digit must be equal to 11st digit
        if ((sum % 10) != arr[10]) { return false; }

        return true;
    }
}
