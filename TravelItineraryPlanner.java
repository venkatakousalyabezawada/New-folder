import java.util.*;

public class TravelItineraryPlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Destination> itinerary = new ArrayList<>();
        double totalBudget = 0;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (true) {
            System.out.println("\n1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. View Weather Information");
            System.out.println("5. Simulate Map Route");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addDestination(scanner, itinerary);
                    break;
                case 2:
                    viewItinerary(itinerary);
                    break;
                case 3:
                    calculateTotalBudget(itinerary);
                    break;
                case 4:
                    viewWeather(scanner, itinerary);
                    break;
                case 5:
                    simulateMapRoute(itinerary);
                    break;
                case 6:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Happy travels!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addDestination(Scanner scanner, List<Destination> itinerary) {
        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();

        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        System.out.print("Enter estimated cost for this destination: ");
        double cost = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter any specific preferences (e.g., cultural, adventure, leisure): ");
        String preferences = scanner.nextLine();

        itinerary.add(new Destination(name, startDate, endDate, cost, preferences));
        System.out.println("Destination added successfully!");
    }

    private static void viewItinerary(List<Destination> itinerary) {
        if (itinerary.isEmpty()) {
            System.out.println("Your itinerary is empty.");
        } else {
            System.out.println("\nYour Itinerary:");
            for (int i = 0; i < itinerary.size(); i++) {
                Destination dest = itinerary.get(i);
                System.out.printf("%d. %s (From %s to %s, Cost: $%.2f, Preferences: %s)%n",
                        i + 1, dest.getName(), dest.getStartDate(), dest.getEndDate(), dest.getCost(), dest.getPreferences());
            }
        }
    }

    private static void calculateTotalBudget(List<Destination> itinerary) {
        double totalBudget = itinerary.stream().mapToDouble(Destination::getCost).sum();
        System.out.printf("Total estimated budget for the trip: $%.2f%n", totalBudget);
    }

    private static void viewWeather(Scanner scanner, List<Destination> itinerary) {
        if (itinerary.isEmpty()) {
            System.out.println("Your itinerary is empty. Add destinations to view weather.");
            return;
        }

        System.out.println("Enter the destination number to view weather information:");
        viewItinerary(itinerary);
        int destIndex = scanner.nextInt() - 1;

        if (destIndex >= 0 && destIndex < itinerary.size()) {
            Destination dest = itinerary.get(destIndex);
            System.out.printf("Weather forecast for %s: Mostly sunny with a high of 75°F.%n", dest.getName());
                   } else {
            System.out.println("Invalid destination number.");
        }
    }

    private static void simulateMapRoute(List<Destination> itinerary) {
        if (itinerary.isEmpty()) {
            System.out.println("Your itinerary is empty. Add destinations to simulate a route.");
            return;
        }

        System.out.println("\nSimulating map route for your itinerary:");
        for (int i = 0; i < itinerary.size(); i++) {
            Destination dest = itinerary.get(i);
            System.out.printf("%d. %s (Start: %s, End: %s)%n",
                    i + 1, dest.getName(), dest.getStartDate(), dest.getEndDate());
        }
        System.out.println("Map route simulation completed. Safe travels!");
            }

    static class Destination {
        private String name;
        private String startDate;
        private String endDate;
        private double cost;
        private String preferences;

        public Destination(String name, String startDate, String endDate, double cost, String preferences) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
            this.cost = cost;
            this.preferences = preferences;
        }

        public String getName() {
            return name;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public double getCost() {
            return cost;
        }

        public String getPreferences() {
            return preferences;
        }
    }
}

