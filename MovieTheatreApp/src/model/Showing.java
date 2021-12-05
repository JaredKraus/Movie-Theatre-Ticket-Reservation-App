package model;

import java.util.ArrayList;
import java.util.Date;

public class Showing {

    int showingId;
    int movieId;
    Date showTime;
    double ticketPrice;

    Movie movie;
    Theatre theatre;
    int ticketCount;
    Seat [][] seats;
    ArrayList<Seat> selectedSeats;

    public Showing(int showingId, int movieId, Date showTime, double ticketPrice) {
        this.showingId = showingId;
        this.movieId = movieId;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        seats = new Seat[5][5];
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public ArrayList<Seat> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(ArrayList<Seat> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public void addSeat(int row, int col)
    {
        selectedSeats.add(seats[row][col]);
    }

    public void removeSeat(int row, int col)
    {
        selectedSeats.remove(seats[row][col]);
    }

    public Transaction checkout(User customer)
    {
        Transaction t = new Transaction(customer);
        for (Seat s: selectedSeats)
        {
            t.addTicket(new Ticket(ticketCount++ , s, this));
            s.setReserved(false);
        }
        return t;
    }

    public int getShowingId() {
        return showingId;
    }

    public void setShowingId(int showingId) {
        this.showingId = showingId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return this.showingId + ". " + this.showTime + "            $" + this.ticketPrice;
    }
}
