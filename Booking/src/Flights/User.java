package Flights;

import java.util.Objects;

public class User {

    private String Name;
    private String Surname;
    public User(String name, String surname) {
        this.Name = name;
        this.Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public boolean equals(User p) {
        return (this.Name.equals(p.Name)&& this.Surname.equals(p.Surname));
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Surname);
    }

    @Override
    public String toString() {
        return "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }
}
