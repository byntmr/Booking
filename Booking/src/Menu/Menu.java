package Menu;

public class Menu {
    public static void menu() {
        System.out.println("\n<----MENU---->");
        System.out.println("1)"+Commands.Online_Board);
        System.out.println("2)"+Commands.Show_the_Flight_information);
        System.out.println("3)"+Commands.Search_Flight);
        System.out.println("4)" +Commands.Book_a_Flight);
        System.out.println("5)"+Commands.Cancel_Booking);
        System.out.println("6)" +Commands.My_Bookings);
        System.out.println("7)"+Commands.Exit);
    }


}
