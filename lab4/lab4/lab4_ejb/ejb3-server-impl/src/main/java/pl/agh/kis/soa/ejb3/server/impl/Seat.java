package pl.agh.kis.soa.ejb3.server.impl;

import javax.ejb.Lock;

import static javax.ejb.LockType.WRITE;

@Lock
public class Seat {
    private String id;
    private int price;
    private boolean chooseReserve;
    private boolean reserved = false;
    public Seat(){};
    public Seat(String id, int price, boolean chooseReserve, boolean reserved) {
        this.id = id;
        this.price = price;
        this.chooseReserve = chooseReserve;
        this.reserved = reserved;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getId() {  return id;}

    public int getPrice() {
        return price;
    }


    public boolean isReserved() {
        return reserved;
    }


    public boolean isChooseReserve() {
        return chooseReserve;
    }

    public void setChooseReserve(boolean chooseReserve) {
        this.chooseReserve = chooseReserve;
    }



}
