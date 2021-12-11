package org.example;

public class Test01 {
    public static void main(String[] args) {
        String str = "1 +2 -3+4 -5 + 6- 7+ 8 -9";

        str = str.replaceAll(" ","");
        int sum = Character.getNumericValue(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if('+' == str.charAt(i)) {
                i++;
                sum += Character.getNumericValue(str.charAt(i));
            } else if ('-' == str.charAt(i)) {
                i++;
                sum -= Character.getNumericValue(str.charAt(i));
            }
        }
        System.out.println(sum);
    }
}
