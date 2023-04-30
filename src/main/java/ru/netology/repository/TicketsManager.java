package ru.netology.repository;

import ru.netology.domain.Tickets;

import java.util.Arrays;


public class TicketsManager {
    protected TicketsRepository repo;

    public TicketsManager(TicketsRepository repo) {
        this.repo = repo;
    }


    public void add(Tickets ticket) {
        repo.save(ticket);
    }


    public Tickets[] findAll(String from, String to) {
        Tickets[] result = new Tickets[0];
        for (Tickets ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Tickets[] tmp = new Tickets[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


    public boolean matches(Tickets ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true;
            }

        }
        return false;
    }

}