package Flights;

import DAO.Flight_Generator;

import java.util.Objects;

public class Flight {
    private int hour;
    private int min;
    private  String starting ;
    private String destination;
    public int id;
    private int seats;



    private static int RandmID() {
        return (int) (Math.random()*1000000+1);
    }
    public Flight(int hour, int min, String destination, int seats ,String starting) {
        this.hour = hour;
        this.min = min;
        this.destination = destination;
        this.seats = seats;
        this.starting=starting;
    }

    public String getStarting() {
        return starting;
    }

    public Flight(int id, String starting, String destination, int hour, int min, int seats) {
  this.starting=starting;
        this.hour = hour;
        this.min = min;
        this.destination = destination;
        this.id =id;
        this.seats = seats;
    }
    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = RandmID();
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDestination() {
        return destination;
    }

    public void book(int seats){
        this.seats = this.seats - seats;
    }



    @Override
    public String toString() {
        return String.format("ID---%d---    %s ===> %s \n",id, starting, destination);
    }


    public String toString2() {
        return String.format("Flight[ " +
                starting + "===>" +
                destination +
                " | Time " + hour +
                ":" + min +"|"+
                "  ID " + id +
                "|  Aviable Seats " + seats +
                "] ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return hour == flight.hour &&
                min == flight.min &&
                id == flight.id &&
                seats == flight.seats &&
                destination.equals(flight.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, min, destination, id, seats);
    }

}
