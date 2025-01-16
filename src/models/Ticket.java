package models;

public class Ticket {
    private final Movie movie;
    private final Seat seat;
    private final double price;

    public Ticket(Movie movie, Seat seat, double price) {
        this.movie = movie;
        this.seat = seat;
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket [Movie: " + movie.getTitle() + ", Seat: " + seat + ", Price: $" + price + "]";
    }
}
