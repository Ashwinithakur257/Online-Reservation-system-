import java.util.Scanner;

public class ReservationSystem {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean loggedIn = loginForm();
        if (loggedIn) {
            int choice;
            do {
                System.out.println("\nWelcome to the Reservation System");
                System.out.println("1. Make a reservation");
                System.out.println("2. Cancel a reservation");
                System.out.println("3. Exit");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        makeReservation();
                        break;
                    case 2:
                        cancelReservation();
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 3);
        }
    }

    private static boolean loginForm() {
        System.out.println("Welcome to the Reservation System Login Form");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // check if username and password are valid
        if (isValidLogin(username, password)) {
            System.out.println("Login successful. Welcome " + username + "!");
            return true;
        } else {
            System.out.println("Invalid login. Please try again.");
            return false;
        }
    }

    private static boolean isValidLogin(String username, String password) {
        // check if username and password are valid
        return (username.equals("admin") && password.equals("password"));
    }

    private static void makeReservation() {
        System.out.println("Welcome to the Reservation System");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your travel dates: ");
        String dates = scanner.nextLine();

        // generate PNR number
        String pnr = generatePNR();

        // display reservation details
        System.out.println("\nReservation successful!");
        System.out.println("Name: " + name);
        System.out.println("Travel Dates: " + dates);
        System.out.println("PNR Number: " + pnr);
    }

    private static void cancelReservation() {
        System.out.print("Enter your PNR number: ");
        String pnr = scanner.nextLine();

        // check if PNR number is valid
        if (isValidPNR(pnr)) {
            // cancel reservation and update status
            System.out.println("Reservation with PNR number " + pnr + " has been cancelled.");
        } else {
            System.out.println("Invalid PNR number. Please try again.");
        }
    }

    private static boolean isValidPNR(String pnr) {
        // check if PNR number is valid
        return (pnr.length() == 6 && pnr.matches("[A-Z0-9]+"));
    }

    private static String generatePNR() {
        // generate a random PNR number
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
}