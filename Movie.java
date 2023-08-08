import java.io.*;
import java.util.*;

public class Movie {
    static File file = new File("movies.txt");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Movie Rating Application");
            System.out.println("1. View all movie ratings");
            System.out.println("2. Add a movie rating");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewMovieRatings();
                    break;
                case 2:
                    addMovieRating(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void viewMovieRatings() {
        System.out.println(" ");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int count=0;
            while ((line = reader.readLine()) != null) {
                count++;
                System.out.println(count+". "+line);

            }
            if (count==0){

                    System.out.println("No info");

            }
            System.out.println(" ");

        } catch (IOException e) {
            System.out.println("Error reading movie ratings: " + e.getMessage());
        }
    }

    private static void addMovieRating(Scanner scanner) {
        System.out.println(" ");
        System.out.print("Enter the movie name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter the movie rating: ");
        double rating = scanner.nextDouble();
        scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(movieName + "- Ratings: " + rating);
            writer.newLine();
            System.out.println("Movie rating added successfully.");
            System.out.println(" ");
        } catch (IOException e) {
            System.out.println("Error adding movie rating: " + e.getMessage());
        }
    }
}
