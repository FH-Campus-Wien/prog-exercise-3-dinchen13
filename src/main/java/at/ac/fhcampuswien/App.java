package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    //methods

    public static void oneMonthCalendar(int numberOfTheDays, int firstDayOfMonth) {

        for (int i = 1; i<firstDayOfMonth; i++){
            System.out.print("   ");
        }
        int sprung =firstDayOfMonth;
        for (int i = 1; i<=numberOfTheDays;i++) {
            System.out.printf("%2d ", i);
            if ((sprung % 7 == 0)||(i==numberOfTheDays)) {
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


    public static long[] lcg(long seed){

        long [] randomNumbers= new long[10];
        long m =(long) Math.pow(2,31);
        int c = 12345;
        int a = 1103515245;
        randomNumbers[0]=(a*seed+c)%m;
        for (int i = 1; i< randomNumbers.length; i++){
            randomNumbers[i]=(a*randomNumbers[i-1]+c)%m;
        }
        return randomNumbers;
    }






    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results

        int numberOfTheDays = 31;
        int firstDayOfMonth = 3;
        oneMonthCalendar(numberOfTheDays, firstDayOfMonth);

        long seed=0;
        long[] randomNumbers = lcg(seed);
        for (int i = 0; i<randomNumbers.length; i++) {
            System.out.println(randomNumbers[i]);
        }
    }
}