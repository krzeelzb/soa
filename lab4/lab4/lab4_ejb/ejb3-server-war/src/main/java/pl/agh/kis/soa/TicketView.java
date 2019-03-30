package pl.agh.kis.soa;

import pl.agh.kis.soa.ejb3.server.impl.Seat;
import pl.agh.kis.soa.ejb3.server.impl.Seats;
import pl.agh.kis.soa.ejb3.server.impl.SeatsBean;
import pl.agh.kis.soa.ejb3.server.impl.UserBean;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class TicketView implements Serializable {
    @EJB
    SeatsBean seatsBean;
    @EJB
    UserBean userBean;
    String chosenSeat;

    public TicketView() {
    }
    public int moneyLeft(){ return userBean.getMoney();}
    public void reserveSeat() throws IllegalAccessException {
        try {
            userBean.reserveTicket(chosenSeat);
        } catch (IllegalAccessException e) {
        }
    }


    public String getChosenSeat() {
        return chosenSeat;
    }

    public void setChosenSeat(String chosenSeat) {
        this.chosenSeat = chosenSeat;
    }

    public List<Seat> getSeats(){
        System.out.println(userBean.getSeatsUser());
        return userBean.getSeatsUser();}
}
