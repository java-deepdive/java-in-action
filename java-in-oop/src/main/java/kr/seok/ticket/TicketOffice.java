package kr.seok.ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private final List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
