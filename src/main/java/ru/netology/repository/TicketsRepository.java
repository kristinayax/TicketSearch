package ru.netology.repository;

import ru.netology.domain.Tickets;

public class TicketsRepository {
    private Tickets[] tickets = new Tickets[0];


    public void save(Tickets ticket) {
        Tickets[] tmp = new Tickets[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;

    }

    public Tickets[] findAll() {
        return tickets;
    }

}