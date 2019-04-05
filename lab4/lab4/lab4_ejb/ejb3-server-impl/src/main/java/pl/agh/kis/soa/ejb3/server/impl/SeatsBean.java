package pl.agh.kis.soa.ejb3.server.impl;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.List;


@Singleton
@Startup
public class SeatsBean {
    private Seats seats = new Seats();

    @Lock(LockType.READ)
    public List<Seat> getSeatList() {
        List<Seat> seatsUnreserved = new ArrayList<>();
        for (Seat seat : seats.getSeats()) {
            if (seat.isReserved()) {
                seatsUnreserved.add(seat);
            }
        }
        return seatsUnreserved;
    }

    public int getSeatPrice(String id) {
        System.out.println(seats.getSeats());
        Seat seat = seats.getSeatById(id,seats.getSeats());
        return seat.getPrice();
    }

    @Lock(LockType.WRITE)
    public void buyTicket(String id) throws IllegalAccessException {
        Seat seat = seats.getSeatById(id,seats.getSeats());

        if (seat.isReserved()) {
            throw new IllegalAccessException("Seat is already reserved.");
        }
        seat.setReserved(true);

    }

    public void retrieve(String id) {
        Seat seat = seats.getSeatById(id,seats.getSeats());
        seat.setReserved(false);
    }

    public List<Seat> getSeats() {
        return seats.getSeats();
    }

}
