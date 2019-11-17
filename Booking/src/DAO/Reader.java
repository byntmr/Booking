package DAO;

import Flights.Booking;
import Flights.Flight;
import Flights.User;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Reader {

    public List<Flight> Read_Flight() throws IOException {
        LinkedList<Flight> Res = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/flights.txt")));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            int number = 0;
            StringBuilder Id = new StringBuilder();
            StringBuilder City = new StringBuilder();
            StringBuilder Start = new StringBuilder();
            StringBuilder Hour = new StringBuilder();
            StringBuilder minute = new StringBuilder();
            StringBuilder Num_of_Seats = new StringBuilder();
            for (char c : line.toCharArray()) {
                if (c != ',' && c != ':') {
                    if (number == 0) {
                        Id.append(c);
                    }
                    if (number == 2) {
                        Start.append(c);
                    }
                    if (number == 2) {
                        City.append(c);
                    }
                    if (number == 3) {
                        Hour.append(c);
                    }
                    if (number == 4) {
                        minute.append(c);
                    }
                    if (number == 5) {
                        Num_of_Seats.append(c);
                    }
                } else number++;
            }
            Res.add(new Flight(Integer.parseInt(Id.toString()),Start.toString(),City.toString(),Integer.parseInt(Hour.toString()),Integer.parseInt(minute.toString()),Integer.parseInt(Num_of_Seats.toString())));
        }
        return new ArrayList<>(Res);
    }
    public List<Booking> Read_Booking() throws IOException {
        LinkedList<Booking> result = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/bookings.txt")));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            int number = 0;
            StringBuilder stringBuilder_Name = new StringBuilder();
            StringBuilder StringBuilder_Surname = new StringBuilder();
            StringBuilder StringBuilder_Destination = new StringBuilder();
            StringBuilder StringBuilder_Start = new StringBuilder();
            StringBuilder StringBuilder_Hour = new StringBuilder();
            StringBuilder StringBuilder_minunte = new StringBuilder();
            StringBuilder stringBuilder_Numofseats = new StringBuilder();
            StringBuilder ID = new StringBuilder();
            StringBuilder sb_id_booking = new StringBuilder();
            for (char ch : line.toCharArray()) {
                if (ch != ',' && ch != ':') {
                    if (number == 0) {
                        sb_id_booking.append(ch);
                    }
                    if (number == 1) {
                        stringBuilder_Name.append(ch);
                    }
                    if (number == 2) {
                        StringBuilder_Surname.append(ch);
                    }
                    if (number == 3) {
                        ID.append(ch);
                    }
                    if (number == 4) {
                        StringBuilder_Destination.append(ch);
                    }
                    if (number == 5) {
                        StringBuilder_Hour.append(ch);
                    }
                    if (number == 6) {
                        StringBuilder_minunte.append(ch);
                    }
                    if (number == 7) {
                        stringBuilder_Numofseats.append(ch);
                    }

                } else number++;
            }
            result.add(new Booking(new User(stringBuilder_Name.toString(),
                    StringBuilder_Surname.toString()),
                    new Flight(Integer.parseInt(ID.toString()),StringBuilder_Start.toString(),
                            StringBuilder_Destination.toString(),
                            Integer.parseInt(StringBuilder_Hour.toString()),
                            Integer.parseInt(StringBuilder_minunte.toString()),
                            Integer.parseInt(stringBuilder_Numofseats.toString())),
                    Integer.parseInt(sb_id_booking.toString())));
        }
        return result;
    }

}
