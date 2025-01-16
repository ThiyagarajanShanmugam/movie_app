package main;

import models.Movie;
import models.Seat;
import models.Ticket;
import patterns.builder.BookingBuilder;
import patterns.singleton.TheaterManager;
import patterns.prototype.TicketTemplate;
import patterns.prototype.TicketTemplateManager;

import java.util.Scanner;

public class MovieTheaterApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the Theater Manager (Singleton)
        TheaterManager theaterManager = TheaterManager.getInstance();

        // Add Movies
        System.out.println("Enter the number of movies to add:");
        int movieCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < movieCount; i++) {
            System.out.println("Enter movie title:");
            String title = scanner.nextLine();
            System.out.println("Enter movie duration (in minutes):");
            int duration = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            theaterManager.addMovie(new Movie(title, duration));
        }

        System.out.println("\nAvailable movies:");
        for (int i = 0; i < theaterManager.getMovies().size(); i++) {
            System.out.println((i + 1) + ". " + theaterManager.getMovies().get(i));
        }

        System.out.println("\nSelect a movie by number:");
        int movieIndex = scanner.nextInt() - 1;

        // Select Seat
        Seat selectedSeat = null;
        boolean validSeat = false;
        while (!validSeat) {
            System.out.println("\nEnter row number of the seat:");
            int row = scanner.nextInt();
            System.out.println("Enter seat number in the row:");
            int seatNumber = scanner.nextInt();

            try {
                selectedSeat = new Seat(row, seatNumber);
                validSeat = true;
            } catch (Exception e) {
                System.out.println("Invalid seat selection. Try again.");
            }
        }

        System.out.println("Enter the ticket price:");
        double price = scanner.nextDouble();

        // Create a ticket using the Builder Pattern
        BookingBuilder builder = new BookingBuilder()
                .setMovie(theaterManager.getMovies().get(movieIndex))
                .setSeat(selectedSeat)
                .setPrice(price);

        Ticket ticket = builder.build();
        System.out.println("\nTicket booked successfully!");
        System.out.println(ticket);

        // Demonstrating the Prototype Pattern
        TicketTemplateManager templateManager = new TicketTemplateManager();
        templateManager.addTemplate("Standard", new TicketTemplate("Standard", "Default Movie", "Grand Cinema", 12.5));
        templateManager.addTemplate("VIP", new TicketTemplate("VIP", "Default Movie", "Grand Cinema", 25.0));

        System.out.println("\nAvailable ticket templates: Standard, VIP");
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the template you want to use: ");
        String selectedTemplate = scanner.nextLine();

        try {
            TicketTemplate clonedTemplate = templateManager.getTemplate(selectedTemplate);

            System.out.print("Enter a new movie title (press Enter to keep '" + clonedTemplate.getMovieTitle() + "'): ");
            String newMovieTitle = scanner.nextLine();
            if (!newMovieTitle.isEmpty()) {
                clonedTemplate.setMovieTitle(newMovieTitle);
            }

            System.out.print("Enter a new base price (press Enter to keep '" + clonedTemplate.getBasePrice() + "'): ");
            String newPrice = scanner.nextLine();
            if (!newPrice.isEmpty()) {
                clonedTemplate.setBasePrice(Double.parseDouble(newPrice));
            }

            System.out.println("\nCustomized Ticket Template:");
            System.out.println(clonedTemplate);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}




// package main;

// import models.Movie;
// import models.Seat;
// import models.Ticket;
// import patterns.builder.BookingBuilder;
// import patterns.singleton.TheaterManager;
// //import patterns.objectpool.SeatPool;

// import java.util.Scanner;

// public class MovieTheaterApplication {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Initialize system
//         TheaterManager manager = TheaterManager.getInstance();
//         System.out.println("Enter the number of movies to add:");
//         int movieCount = scanner.nextInt();
//         scanner.nextLine(); // Consume newline

//         for (int i = 0; i < movieCount; i++) {
//             System.out.println("Enter movie title:");
//             String title = scanner.nextLine();
//             System.out.println("Enter movie duration (in minutes):");
//             int duration = scanner.nextInt();
//             scanner.nextLine(); // Consume newline
//             manager.addMovie(new Movie(title, duration));
//         }

//         System.out.println("\nAvailable movies:");
//         for (int i = 0; i < manager.getMovies().size(); i++) {
//             System.out.println((i + 1) + ". " + manager.getMovies().get(i));
//         }

//         System.out.println("\nSelect a movie by number:");
//         int movieIndex = scanner.nextInt() - 1;

//         //System.out.println("Enter the number of rows in the theater:");
//         //int rows = scanner.nextInt();
//         //System.out.println("Enter the number of seats per row:");
//         //int seatsPerRow = scanner.nextInt();
//         //SeatPool seatPool = new SeatPool(rows, seatsPerRow);

//         Seat selectedSeat = null;
//         boolean validSeat = false;
//         while (!validSeat) {
//             System.out.println("\nEnter row number of the seat:");
//             int row = scanner.nextInt();
//             System.out.println("Enter seat number in the row:");
//             int seatNumber = scanner.nextInt();

//             try {
//                 selectedSeat = new Seat(row, seatNumber);
//                 validSeat = true;
//             } catch (Exception e) {
//                 System.out.println("Invalid seat selection. Try again.");
//             }
//         }

//         System.out.println("Enter the ticket price:");
//         double price = scanner.nextDouble();


        
//         // Create a ticket using builder
//         BookingBuilder builder = new BookingBuilder()
//                 .setMovie(manager.getMovies().get(movieIndex))
//                 .setSeat(selectedSeat)
//                 .setPrice(price);

//         Ticket ticket = builder.build();
//         System.out.println("\nTicket booked successfully!");
//         System.out.println(ticket);

//         scanner.close();
//     }
// }
