import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Tickets;
import ru.netology.repository.TicketsManager;
import ru.netology.repository.TicketsRepository;


public class TicketsManagerTest {
    TicketsRepository repo = new TicketsRepository();
    TicketsManager manager = new TicketsManager(repo);

    Tickets ticket1 = new Tickets(001, 7_000, "LED", "OVB", 240);
    Tickets ticket2 = new Tickets(002, 7_500, "LED", "OVB", 240);
    Tickets ticket3 = new Tickets(003, 4_000, "DME", "LED", 90);
    Tickets ticket4 = new Tickets(004, 4_300, "LED", "DME", 95);
    Tickets ticket5 = new Tickets(005, 10_000, "OVB", "DME", 300);
    Tickets ticket6 = new Tickets(006, 12_500, "DME", "LED", 90);


    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }


    @Test
    public void shouldFindAll() {

        Tickets[] expected = {ticket1, ticket2};
        Tickets[] actual = manager.findAll("LED", "OVB");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindWithSameTime() {

        Tickets[] expected = {ticket3, ticket6};
        Tickets[] actual = manager.findAll("DME", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindIfNoneFit() {
        Tickets[] expected = {};
        Tickets[] actual = manager.findAll("VKO", "AER");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindSeveralTickets() {
        Tickets[] expected = {ticket1, ticket2};
        Tickets[] actual = manager.findAll("LED", "OVB");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindOneTicket() {
        Tickets[] expected = {ticket5};
        Tickets[] actual = manager.findAll("OVB", "DME");

        Assertions.assertArrayEquals(expected, actual);
    }


}
