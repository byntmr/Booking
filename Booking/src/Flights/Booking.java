package Flights;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Booking {

    private User user;
    private Flight flight;
    private int ID;

    public Booking(User user, Flight flight, int ID) {
        this.user = user;
        this.flight = flight;
        this.ID = ID;
    }



    public User getUser() {
        return user;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getID() {
        return flight.getId();
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return  String.format("|" +getUser().getName()+" "+getUser().getSurname()+" |"+
                flight.getStarting() + "===>" +
                flight.getDestination() +
                " | Time " +  flight.getHour() +
                ":" + flight.getMin() +"|"+
                "  ID " + flight.getId() +

                "]\n ");
    }
}
