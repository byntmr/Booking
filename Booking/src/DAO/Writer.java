package DAO;

import Flights.Booking;
import Flights.Flight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

public class Writer {

    public void Flight_Writer(List<Flight> origin) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/flights.txt")));
        int size = origin.size();

        for (Flight oneflight : origin) {
            StringJoiner joiner = new StringJoiner(",");
            StringJoiner stringJoiner = new StringJoiner(":");
            joiner.add(String.valueOf(oneflight.getId()));
            joiner.add(oneflight.getStarting());
            joiner.add(oneflight.getDestination());
            stringJoiner.add(String.valueOf(oneflight.getHour()));
            stringJoiner.add(String.valueOf(oneflight.getMin()));
            joiner.add(stringJoiner.toString());
            joiner.add(String.valueOf(oneflight.getSeats()));
            writer.write(joiner.toString() + "\n");
        }
        writer.close();

    }
    public static void Booking_Writer(List<Booking> origin) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/bookings.txt")));
        int size = origin.size();

        for (Booking onebooking: origin) {
            StringJoiner sj = new StringJoiner(",");
            StringJoiner sjt = new StringJoiner(":");
            sj.add(String.valueOf(onebooking.getID()));
            sj.add(onebooking.getUser().getName());
            sj.add(onebooking.getUser().getSurname());
            sj.add(String.valueOf(onebooking.getFlight().getId()));
            sj.add(onebooking.getFlight().getStarting());
            sj.add(onebooking.getFlight().getDestination());
            sjt.add(String.valueOf(onebooking.getFlight().getHour()));
            sjt.add(String.valueOf(onebooking.getFlight().getMin()));
            sj.add(sjt.toString());
            sj.add(String.valueOf(onebooking.getFlight().getSeats()));
            writer.write(sj.toString() + "\n");
        }
        writer.close();
    }

}
