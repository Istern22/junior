package ru.job4j.solid.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CinemaTest {

/*    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        Session session1 = new Session3D();
        Session session2 = new Session3D();
        cinema.add(session1);
        cinema.add(session2);
        assertThat(cinema.find(session -> session.equals(session1)), is(Arrays.asList(session1)));
    }*/

}