package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    //methods

    public static void oneMonthCalendar(int numberOfTheDays, int firstDayOfMonth) {

        for (int i = 1; i < firstDayOfMonth; i++) {
            System.out.print("   ");
        }
        int sprung = firstDayOfMonth;
        for (int i = 1; i <= numberOfTheDays; i++) {
            System.out.printf("%2d ", i);
            if ((sprung % 7 == 0) || (i == numberOfTheDays)) {
                System.out.println();
            }
            sprung++;
        }

        /*
        int a =firstDayOfMonth;
        for (int i = 1; i<=numberOfTheDays;){
            if (firstDayOfMonth!=0){
                System.out.print("   ");
                firstDayOfMonth--;
            }
            else {
                System.out.printf("%2d ", i);
                a++;
                if ((a % 7 == 0)||(i==numberOfTheDays)){
                    System.out.println();
                }
                i++;
            }
        }
        System.out.println();
         */
    }


    public static long[] lcg(long seed) {

        long[] randomNumbers = new long[10];
        long m = (long) Math.pow(2, 31);
        int c = 12345;
        int a = 1103515245;
        randomNumbers[0] = (a * seed + c) % m;
        for (int i = 1; i < randomNumbers.length; i++) {
            randomNumbers[i] = (a * randomNumbers[i - 1] + c) % m;
        }
        return randomNumbers;
    }


    public static void guessingGame(int numberToGuess) {

        int guess = 0;
        int counter = 1;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.printf("Guess number %d: ", counter);
            guess = scanner.nextInt();

            if (guess == numberToGuess) {
                System.out.println("You won wisenheimer!");
            } else {
                if ((guess > numberToGuess) && (counter != 10)) {
                    System.out.println("The number AI picked is lower than your guess.");
                } else if ((numberToGuess > guess) && (counter != 10)) {
                    System.out.println("The number AI picked is higher than your guess.");
                }
                counter++;
            }
        } while (guess != numberToGuess && counter <= 10);

        if (counter > 10) {
            System.out.println("You lost! Have you ever heard of divide & conquer?");
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        return randomNumber;
    }


    public static boolean swapArrays(int[] array1, int[] array2) {
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                array1[i] = array1[i] + array2[i];
                array2[i] = array1[i] - array2[i];
                array1[i] = array1[i] - array2[i];
            }
            return true;
        } else {
            return false;
        }
    }


    public static String camelCase(String text) {
        char[] textNew = new char[text.length()];
        char[] zeichen = text.toCharArray();
        int lange=0;
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if ((i==0)&&(zeichen[i]>90)){
                zeichen[i] = (char) (zeichen[i] - 32);
            }
            if ((zeichen[i] >= 65) && (zeichen[i] <= 90) && (i != 0)) {
                zeichen[i] = (char) (zeichen[i] + 32);
            }
        }
        for (int i = 0; i < text.length(); i++) {

            if ((zeichen[i] == '.') || (zeichen[i] == '?') || (zeichen[i] == '!')||(zeichen[i] == '\'')|| (zeichen[i] == ',')|| (zeichen[i] == '-')){
                continue;
            }

            textNew[counter] = zeichen[i];

            if (zeichen[i] == ' ') {
                textNew[counter] = (char) (zeichen[i + 1] - 32);
                i++;
            }
            counter++;
            lange++;
        }

        char[] textNew2 = new char[lange];
        for (int i = 0; i < lange; i++) {
            textNew2[i] = textNew[i];
        }
        text = String.valueOf(textNew2);
        return text;
    }



    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results

        int numberOfTheDays = 31;
        int firstDayOfMonth = 3;
        oneMonthCalendar(numberOfTheDays, firstDayOfMonth);

        long seed = 0;
        long[] randomNumbers = lcg(seed);
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.println(randomNumbers[i]);
        }

        int number = randomNumberBetweenOneAndHundred();
        //guessingGame(number);

        int[] array1 = {1, 4, 6, 9};
        int[] array2 = {7, 6, 3, 0};
        swapArrays(array1, array2);
        for (int j : array1) {
            System.out.print(j);
        }
        System.out.println();
        for (int j : array2) {
            System.out.print(j);
        }

        Scanner scanner =new Scanner(System.in);
        System.out.println("gib einen text ein:");
        String text = scanner.nextLine();
        String result =camelCase(text);
        System.out.println(result);


    }
}