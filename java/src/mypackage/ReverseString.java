package mypackage;

import java.util.Scanner;

public class ReverseString {

    public static String revString(String str) {

        String reversed = "";

        for (int i = str.length() - 1; 0 <= i; i--) {
            // append string starting from the last char
            reversed = reversed + str.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {

        String str = "";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        str = sc.nextLine();

        System.out.printf("The reversed string is '%s'", revString(str));

        // close resources
        sc.close();
    }

}
