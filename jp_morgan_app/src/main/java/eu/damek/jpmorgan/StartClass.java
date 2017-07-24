package eu.damek.jpmorgan;

import eu.damek.jpmorgan.controller.JPMorgan;

/**
 * Project: jp_morgan
 * For:
 * Created by damekjan on 24/07/2017.
 */
public class StartClass {

    /**
     * start point of appliaction to run on console
     *
     * @param args Argument given by command line
     */
    public static void main(String[] args) {
        JPMorgan jpMorgan = new JPMorgan();
        jpMorgan.run();
    }
}
