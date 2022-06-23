package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VorstellungTest {

    private Vorstellung vorstellung;
    private KinoSaal kinoSaal;
    private Zeitfenster zeitfenster;
    private Ticket ticket;


    @BeforeEach
    void setup() {
        //Saal anlegen
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        kinoSaal = new KinoSaal("KS2", map);
        zeitfenster = Zeitfenster.ABEND;
        LocalDate datum = LocalDate.now();
        String film = "TDD";
        float preis = 25.12f;
        vorstellung = new Vorstellung(kinoSaal, zeitfenster, datum, film, preis);
        ticket = vorstellung.kaufeTicket('A', 3, 29f);
    }


    @Test
    void getFilm() {
        assertEquals("TDD", vorstellung.getFilm());
    }

    @Test
    void getSaal() {
        assertEquals(kinoSaal, vorstellung.getSaal());
    }

    @Test
    void getZeitfenster() {
        assertEquals(Zeitfenster.ABEND, vorstellung.getZeitfenster());
    }

    @Test
    void getDatum() {
        assertEquals(LocalDate.now(), vorstellung.getDatum());
    }

    @Test
    void kaufeTicket() {
        Ticket ticket2 = vorstellung.kaufeTicket('A', 4, 29f);
        assertNotEquals(ticket2, ticket);
    }

    @Test
    void testEquals() {
        Vorstellung vorstellung2 = new Vorstellung(kinoSaal, zeitfenster, LocalDate.now(), "TDD", 25.12f);
        assertTrue(vorstellung.equals(vorstellung2));
    }
}