package patterns.factory;

import models.Movie;
import models.Seat;
import models.Ticket;

public class TicketFactory {
    public Ticket createTicket(Movie movie, Seat seat, double price) {
        return new Ticket(movie, seat, price);
    }
}
