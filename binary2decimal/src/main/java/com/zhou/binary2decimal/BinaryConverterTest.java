package com.zhou.binary2decimal;

import java.util.Scanner;

/**
 * @Author: zhou.liu
 * @Date: 2022/5/13 13:47
 * @Description:
 */
public class BinaryConverterTest {

    static void decimToBin(int number) {

        int[] decimalArray = new int[50];
        int index = 0;

        while (number > 0) {
            decimalArray[index++] = number % 2;
            number = number / 2;
        }

        for (int i = index - 1; i >= 0; i--) {
            System.out.print(decimalArray[i]);
        }

    }

    static void floatingPointDecimToBin(double number) {

        int pointCount = 0;
//        System.out.print("0.");
        while (pointCount < 10) {
            number = number * 2;
            int x = (int) number;
            System.out.print(x);
            number = number - (double) x;
            pointCount++;
        }

    }

    static int binToDecim(int number) {

        int sum = 0;
        int power = 0;

        while (number > 0) {
            int x = number % 10;
            number = number / 10;
            sum = (int) (sum + (x * Math.pow(2, power)));
            power++;
        }
        return sum;

    }

    static double floatingPointBinToDecim(double number) {

        double sum = 0;
        int power = -1;

        String str1 = String.valueOf(number);
        int index = str1.indexOf(".");
        int NumberofDecimalPoints = str1.substring(index + 1).length();

        number = number * Math.pow(10, NumberofDecimalPoints);
        int newNumber = (int) number;
        String temp = Integer.toString(newNumber);
        int[] numbers = new int[temp.length()];

        for(int i=0; i<temp.length(); i++){
            numbers[i] = temp.charAt(i) - '0';
            sum = (sum + (numbers[i] * Math.pow(2, power)));
            power--;
        }
        return sum;

    }

    public static void main(String[] args) {

        System.out.println("Choose your conversion type");
        System.out.println("********************************************************\n"
                + "* Press 1 to Convert Decimal to Binary \n"
                + "* Press 2 to Convert floating point Decimal to Binary \n"
                + "* Press 3 to Convert Binary to Decimal \n"
                + "* Press 4 to Convert floating point Binary to Decimal \n"
                + "********************************************************\n");

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        switch (x) {

            case 1:
                System.out.print("Enter a decimal number: ");
                Scanner scan1 = new Scanner(System.in);
                int number1 = scan1.nextInt();
                decimToBin(number1);
                System.out.println();
                break;
            case 2:
                System.out.print("Enter a floating point Decimal number: ");
                Scanner scan2 = new Scanner(System.in);
                double number2 = scan2.nextDouble();

                int integerPart = (int) number2;
                String str = String.valueOf(number2);
                int index = str.indexOf(".");
                int numberOfDecimalPoints = str.substring(index + 1).length();
                double decimalPart = number2 - integerPart;
                String roundOffasString = String.format("%." + numberOfDecimalPoints + "f", decimalPart);
                decimalPart = Double.parseDouble(roundOffasString);
                decimToBin(integerPart);
                System.out.print(".");
                floatingPointDecimToBin(decimalPart);
                System.out.println();

                break;
            case 3:
                System.out.print("Enter a binary number: ");
                Scanner scan3 = new Scanner(System.in);
                int number3 = scan3.nextInt();
                System.out.println(binToDecim(number3));
                break;
            case 4:
                System.out.print("Enter a floating point Binary number: ");
                Scanner scan4 = new Scanner(System.in);
                double number4 = scan4.nextDouble();

                int integerPart1 = (int) number4;
                String str1 = String.valueOf(number4);
                int index1 = str1.indexOf(".");
                int numberOfDecimalPoints1 = str1.substring(index1 + 1).length();
                double decimalPart1 = number4 - integerPart1;
                String roundOffAsString1 = String.format("%." + numberOfDecimalPoints1 + "f", decimalPart1);
                decimalPart1 = Double.parseDouble(roundOffAsString1);
                System.out.println(binToDecim(integerPart1)+floatingPointBinToDecim(decimalPart1));

                break;
            default:
                System.out.println("Invalid input!");

        }

    }
}
