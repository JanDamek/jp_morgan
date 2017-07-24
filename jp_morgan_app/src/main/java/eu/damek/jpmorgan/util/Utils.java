package eu.damek.jpmorgan.util;

import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

/**
 * Project: jp_morgan
 * For: basic helper class
 * Created by damekjan on 24/07/2017.
 */
public class Utils {

    /**
     * output on onsole
     *
     * @param string to write
     */
    public static void printLn(String string) {
        System.out.println(string);
    }

    /**
     * get char from input by console
     *
     * @return char
     */
    public static char readKeybordChar() {
        try {
            return (char) new InputStreamReader(System.in).read();
        } catch (IOException e) {
            return 0;
        }
    }

    /**
     * print test on console without line feed
     *
     * @param s String to print
     */
    public static void print(String s) {
        System.out.print(s);
    }

    /**
     * read from console Double value
     *
     * @return Double
     */
    public static double readLineDouble() {
        String line = readLine();
        return Double.valueOf(line);
    }

    /**
     * read from console String value
     *
     * @return String
     */
    public static String readLine() {
        Console console = System.console();
        if (console == null) {
            System.out.println("Unable to fetch console");
            return "";
        }
        return console.readLine();
    }

    /**
     * read from console integer value
     *
     * @return Integer
     */
    public static int readLineInteger() {
        String line = readLine();
        return Integer.valueOf(line);
    }

    /**
     * raed from console Date value
     *
     * @return Date
     */
    public static Date readLineDate() {
        String line = readLine();
        final String[] split = line.split("\\.");
        return date(Integer.valueOf(split[2]), Integer.valueOf(split[1]), Integer.valueOf(split[0]));
    }

    /**
     * make date byte given year, month and day
     *
     * @param day   day
     * @param month month
     * @param year  year
     * @return Date time
     */
    public static Date date(int day, int month, int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day, 0, 0, 0);
        return c.getTime();
    }
}
