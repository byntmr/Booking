package Service;

import DAO.*;
import Flights.Booking;
import Flights.Flight;
import Flights.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Service {
    private FlightDB flight_Database;
    private FlightDB Booking_Database;

    public Service() throws IOException {
        flight_Database = new FlightDB();
        Booking_Database = new FlightDB();
    }

    public String getOnlineBoard() {
        return flight_Database.toString();
    }

    public String getFlightInfo(int id) {
        return flight_Database.getFlight(id).toString2();
    }

    public Flight getFlightByID(int id) {
        return flight_Database.getFlight(id);
    }


    public List<Flight> search(String Starting,String destination) {
        List<Flight> result = new LinkedList<>();
        ArrayList<Flight> database = flight_Database.getFlightArrayList();
        for (Flight flight : database) {
            if ( flight.getStarting().toLowerCase().equals(Starting.toLowerCase()) && flight.getDestination().toLowerCase().equals(destination.toLowerCase()) ){
                result.add(flight);
            }
        }
        return result;
    }



    public String book(User user, int id, int seats) throws IOException {
        Flight flight = getFlightByID(id);
        flight.book(seats);
        if(flight_Database.update(flight)){
            Writer writer = new Writer();
            writer.Flight_Writer(flight_Database.getFlightArrayList());
            Booking_Database.add(new Booking(user, flight, Booking_Database.getLastId() + 1));
            Writer.Booking_Writer(Booking_Database.getDataBase());
            return "Successfully  Booked ";
        }
        return "ID not Found";
    }

    public String cancelBooking(int id) throws IOException {
        List<Booking> bookingList = Booking_Database.getDataBase();
        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getID() == id){
                bookingList.remove(bookingList.get(i));
                Writer writer = new Writer();
                writer.Booking_Writer(bookingList);
                return "Book successfully canceled.";
            }
        }
        return "ID not found";
    }

    public String getMyFlights(User p) {
        List<Booking> database = Booking_Database.getDataBase();
        ArrayList<Booking> bookings = new ArrayList<>();
     if (bookings==null) return " you dont have any booking";
        for (Booking booking: database) {
            if (booking.getUser().equals(p)){
                bookings.add(booking);
            }
        }
        return bookings.toString();
    }



}
