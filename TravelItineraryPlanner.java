import java.util.Scanner;

public class TravelItineraryPlanner {
    private Scanner scanner = new Scanner(System.in);

    public void createPlan() {
        System.out.println("=== Simple Travel Planner ===");
        
        // Get basic travel info
        System.out.print("Where do you want to go? ");
        String destination = scanner.nextLine();

        System.out.print("When are you going? (DD/MM/YYYY): ");
        String date = scanner.nextLine();

        System.out.print("What's your budget? $");
        double budget = scanner.nextDouble();

        // Display the plan
        System.out.println("\nYour Travel Plan:");
        System.out.println("Destination: " + destination);
        System.out.println("Date: " + date);
        System.out.println("Budget: $" + budget);
        
        // Show some basic recommendations
        System.out.println("\nRecommendations:");
        System.out.println("- Daily budget: $" + (budget / 3) + " (estimated for 3 days)");
        System.out.println("- Don't forget to check the weather!");
        System.out.println("- Remember to book your accommodation");
    }

    public static void main(String[] args) {
        TravelItineraryPlanner planner = new TravelItineraryPlanner();
        planner.createPlan();
    }
}
