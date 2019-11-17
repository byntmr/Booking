package App;
import Flights.User;
import Menu.Menu;
import Service.Service;
import java.io.IOException;
import java.util.Scanner;
public class Console {
    public static void main(String[] args) throws IOException {
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        int command;
        int ID;
        String Destination;
        String Starting;
        int Num_of_Seats;
        String Name;
        String Surname;
        System.out.print("Please enter Name: ");
        Name = scanner.next();
        System.out.print("Please enter Surname: ");
        Surname = scanner.next();
        User user = new User(Name, Surname);
        while (!flag) {
            Menu.menu();
            System.out.println("Please Select a Menu Option:\n");
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println(service.getOnlineBoard());
                    break;
                case 2:
                    System.out.println("Show the Flight information\n");
                    System.out.print ("Please Enter Flight ID: ");
                    ID = scanner.nextInt();
                    System.out.println(service.getFlightInfo(ID));
                    break;
                case 3:
                    System.out.println("Search Flight\n");
                    System.out.print("Please enter Starting City: ");
                    Starting = scanner.next();
                    System.out.print("Please enter Destination: ");
                    Destination = scanner.next();
                    System.out.println(service.search(Starting, Destination));
                    break;
                case 4:
                    System.out.println("Book a Flight\n");
                    System.out.print("Please Enter Flight ID: ");
                    ID = scanner.nextInt();
                    System.out.print("Please Enter  Number of Seats: ");
                    Num_of_Seats = scanner.nextInt();
                    System.out.println(service.book(user, ID, Num_of_Seats));
                    break;
                case 5:
                    System.out.println("Cancel Booking\n");
                    System.out.println("Please Enter Flight ID: ");
                    ID = scanner.nextInt();
                    System.out.println(service.cancelBooking(ID));
                    break;
                case 6:
                    System.out.println("My Bookings\n");
                    User user1 = new User(Name,Surname);
                    System.out.println(service.getMyFlights(user1));
                    break;
                case 7:
                    System.out.println(" Bye\n");
                    flag = true;
                    break;
                default:
                    throw new IllegalArgumentException("Command Not Found.");
            }
        }

    }
}
