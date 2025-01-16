package models;

public class Seat {
    private final int row;
    private final int number;
    private boolean isBooked;

    public Seat(int row, int number) {
        this.row = row;
        this.number = number;
        this.isBooked = false;
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookSeat() {
        if (!isBooked) {
            isBooked = true;
        } else {
            throw new IllegalStateException("Seat is already booked!");
        }
    }

    public void releaseSeat() {
        isBooked = false;
    }

    @Override
    public String toString() {
        return "Seat [Row: " + row + ", Number: " + number + ", Booked: " + isBooked + "]";
    }
}
