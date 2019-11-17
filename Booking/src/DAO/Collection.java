package DAO;

import Flights.Flight;

import java.util.ArrayList;

public class Collection {
    public ArrayList<Flight> Generator(int Num) {
        ArrayList<Flight> flights = new ArrayList<>();
        Flight_Generator flightGenerator = new Flight_Generator();
        while (Num!=0){

            Flight flight = flightGenerator.generate();
            flight.setId(flights.size());
            flights.add(flight);
            Num--;
        }

        return flights;
    }
}