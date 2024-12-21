import java.util.ArrayList;
import java.util.Scanner;

public class SimpleHotelReservation {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    public SimpleHotelReservation() {
        // Initialize some rooms
        rooms.add(new Room(101, "Standard", 2000));
        rooms.add(new Room(201, "Deluxe", 3500));
        rooms.add(new Room(301, "Suite", 5000));
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Hotel Booking System ===");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View My Booking");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: showRooms(); break;
                case 2: bookRoom(); break;
                case 3: viewBooking(); break;
                case 4: return;
            }
        }
    }

    private void showRooms() {
        System.out.println("\nAvailable Rooms:");
        System.out.println("Room\tType\tPrice");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println(room.number + "\t" + room.type + "\t₹" + room.price);
            }
        }
    }

    private void bookRoom() {
        showRooms();
        System.out.print("\nEnter room number: ");
        int roomNum = scanner.nextInt();
        scanner.nextLine();

        Room room = findRoom(roomNum);
        if (room != null && room.isAvailable) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            
            System.out.print("Number of days: ");
            int days = scanner.nextInt();
            
            double total = room.price * days;
            System.out.println("Total: ₹" + total);
            
            System.out.print("Confirm booking (y/n)? ");
            scanner.nextLine();
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                room.isAvailable = false;
                Booking booking = new Booking(name, room, days, total);
                bookings.add(booking);
                System.out.println("Booked! Your booking ID is: " + booking.id);
            }
        } else {
            System.out.println("Invalid room or room not available!");
        }
    }

    private void viewBooking() {
        System.out.print("Enter booking ID: ");
        int id = scanner.nextInt();
        
        for (Booking booking : bookings) {
            if (booking.id == id) {
                System.out.println("\nBooking Details:");
                System.out.println(booking);
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    private Room findRoom(int number) {
        for (Room room : rooms) {
            if (room.number == number) return room;
        }
        return null;
    }

    public static void main(String[] args) {
        new SimpleHotelReservation().start();
    }
}

class Room {
    int number;
    String type;
    double price;
    boolean isAvailable = true;

    Room(int number, String type, double price) {
        this.number = number;
        this.type = type;
        this.price = price;
    }
}

class Booking {
    static int nextId = 1;
    int id;
    String guestName;
    Room room;
    int days;
    double totalPrice;

    Booking(String guestName, Room room, int days, double totalPrice) {
        this.id = nextId++;
        this.guestName = guestName;
        this.room = room;
        this.days = days;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "ID: " + id + "\nGuest: " + guestName + 
               "\nRoom: " + room.number + " (" + room.type + ")" +
               "\nDays: " + days + "\nTotal: ₹" + totalPrice;
    }
}