package patterns.builder;

import models.Movie;
import models.Seat;
import models.Ticket;
import patterns.factory.TicketFactory;

public class BookingBuilder {
    private Movie movie;
    private Seat seat;
    private double price;

    public BookingBuilder setMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public BookingBuilder setSeat(Seat seat) {
        this.seat = seat;
        return this;
    }

    public BookingBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Ticket build() {
        if (movie == null || seat == null || price <= 0) {
            throw new IllegalArgumentException("Invalid booking details!");
        }
        return new TicketFactory().createTicket(movie, seat, price);
    }
}
