package ru.netology.domain;

public class Tickets implements Comparable<Tickets> {

    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int time;

    public Tickets(int id, int price, String from, String to, int time) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public int compareTo(Tickets o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

}