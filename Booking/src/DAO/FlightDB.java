package DAO;

import Flights.Booking;
import Flights.Flight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightDB {
    List<Booking> DataBase;
    public FlightDB() throws IOException {
        Reader read = new Reader();
        DataBase = read.Read_Booking();
        Reader reader = new Reader();
        ArrayList<Flight> Data = (ArrayList<Flight>) reader.Read_Flight();
        if (Data.size() == 0){
            Collection collection = new Collection();
            ArrayList<Flight> flights = collection.Generator(20);
            this.flightArrayList = flights;
        }else{
            flightArrayList = Data;
        }
    }

    private ArrayList<Flight> flightArrayList;

    public ArrayList<Flight> getFlightArrayList() {
        return flightArrayList;
    }

    public Flight getFlight(int id) {
        try {
            for (Flight oneflight : flightArrayList) {
                if (oneflight.getId() == id) return oneflight;
            }
            throw new IllegalArgumentException("Not Found");
        } catch (ArrayStoreException ex) {
            throw ex;
        }
    }

    public boolean update(Flight flight){
        for (int i = 0; i < flightArrayList.size(); i++) {
            if (flightArrayList.get(i).getId() == flight.getId()){
                flightArrayList.get(i).setSeats(flight.getSeats());
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < flightArrayList.size(); i++) {
            result += " " + flightArrayList.get(i);
        }
        return result;

    }




    public List<Booking> getDataBase() {
        return DataBase;
    }

    public void setDataBase(List<Booking> dataBase) {
        this.DataBase = dataBase;
    }

    public void add(Booking data){
        DataBase.add(data);
    }

    public int getLastId(){
        if (!DataBase.isEmpty()) {
            return DataBase.get(DataBase.size() - 1).getID();
        }
        return 0;
    }
}
