package controller;

import model.*;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * CancelSuccessController class is used to control information moving in and out of the database
 * It also connects to the model to pass all required information.
 */
public class DatabaseController {

    ArrayList<Movie> movieList;
    Database database;

    public DatabaseController() throws SQLException {
        // PULL ALL MOVIES INTO MOVIE LIST
        database = Database.getDatabase();
        movieList = database.getMovieDB();
    }

    public String displayAllMovies(){
        StringBuilder movies = new StringBuilder();
        for(Movie movie: movieList){
            movies.append(movie.getTitle()).append("\n").append(movie.getDescription()).append("\n\n");
        }
        return movies.toString();
    }

    public Movie getMovieByTitle(String search) {
        for(Movie movie: movieList){
            if(search.equals(movie.getTitle())){
                return movie;
            }
        }
        return null;
    }

    public ArrayList<Showing> getMovieShowingsByTitle(Movie movie) {
        return movie.getShowings();
    }

    public String displayMovieShowingsByTitle(String search){

        Movie movie = getMovieByTitle(search);
        if(movie == null){
            return "Movie not found!";
        }
        ArrayList<Showing> showingList = getMovieShowingsByTitle(movie);
        StringBuilder showings = new StringBuilder();

        showings.append(movie.getTitle()).append("\n").append(movie.getDescription()).append("\n\n");

        for(Showing show: showingList){
            showings.append("Show ID: ").append(show.getShowingId()).append("\n")
                    .append("Show Time: ").append(show.getShowTime()).append("\n")
                    .append("Ticket Price: ").append(show.getTicketPrice()).append("\n\n");
        }
        return showings.toString();

    }


    public ArrayList<Movie> getMovieList() {
        return movieList;
    }


    public ArrayList<Message> getUserMail(User user) throws SQLException {
        ArrayList<Message> userMail = database.getUserMessages(user);
        return  userMail;
    }

    public void updateReadStatus(Message m) throws SQLException {
        database.markAsRead(m);
    }

    public void addMessageToDB (User user, String message, String subjectLine) throws SQLException {
        database.addMessage(user, message, subjectLine);

    }

}
