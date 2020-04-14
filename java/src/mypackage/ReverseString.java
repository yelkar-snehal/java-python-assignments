package mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

    public static String RevString(String str) {
    	//avoiding swap logic to reduce space complexity
    	
        String reversed = "";

        for (int i = str.length() - 1; 0 <= i; i--) {
            // append string starting from the last char
            reversed = reversed + str.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) throws IOException {

        String str = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string");
        str = br.readLine();

        System.out.printf("The reversed string is '%s'", RevString(str));
    }

}
