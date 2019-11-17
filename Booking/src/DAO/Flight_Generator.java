package DAO;

import Flights.Flight;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Flight_Generator {

    public static final ArrayList<String> cities = new ArrayList<>(Arrays.asList(
            "Berlin", "Istanbul", "Jakarta", "Kabul", "Bratislava", "Lagos",
            "Lahore", "Ljubljana", "London", "Los Angeles", "Luxembourg",
            "Madrid", "Bogota", "Baku", "Kiev", "Moscow", "London", "Jerusalem",
            "Johannesburg", "Tokyo", "Paris", "Rome", "California", "Washington",
            "Prague", "Berlin", "Dehli"));

    public Flight generate(){

        Random r =  new Random();
        Random k =  new Random();

        int index = Math.abs(r.nextInt())%cities.size();
        int index2 = Math.abs(r.nextInt())%cities.size();

        String Dest = cities.get(index);
        String Start = cities.get(index2);
        int min = Math.abs(r.nextInt())%15*4;
        int hour = Math.abs(r.nextInt())%24;
        int seats = Math.abs(r.nextInt())%100;
        return new Flight(hour,min,Dest,seats,Start);

    }





}
