package pl.agh.kis.soa.ejb3.server.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class UserBean {
    public int getMoney() {
        return money;
    }
    private String seatId;
    private int money;
    private List<Seat> reservedSeats=new ArrayList<>();

    SeatsBean seatsBean=new SeatsBean();

    @PostConstruct
    public void init() {
        money=500;
    }

    public void reserveTicket(String id) throws IllegalAccessException {
        int seatPrice=seatsBean.getSeatPrice(id);

        if(money<seatPrice){
            throw new IllegalAccessException("Not enough money");
        }
        seatsBean.buyTicket(id);
        money=money-seatPrice;
    }

    public List<Seat> getSeatsUser() {
        return seatsBean.getSeats();
    }

}
