package pl.agh.kis.soa.ejb3.server.impl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Seats {
    private List<Seat> seats= new ArrayList<>(Arrays.asList(
            new Seat("1", 20, false, false),
            new Seat("2", 20, false, false),
            new Seat("3", 20, false, false),
            new Seat("4", 20, false, false),
            new Seat("5", 30, false, false),
            new Seat("6", 40, false, false),
            new Seat("7", 550, false, false)
    ));

    public Seats() {
    }


    public boolean addSeat(Seat seat){ return seats.add(seat);};
    public List<Seat> getSeats(){return seats;};

    public Seat getSeatById(String id,List<Seat> list){

        for(Seat seat : list){
            if(seat.getId().equals(id)){
                System.out.println(seat.getId());
                return seat;
            }
        }

        return  new Seat();
    }
}
