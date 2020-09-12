package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Route;
import ru.netology.domain.TicketByTimeAscComparator;
import ru.netology.repository.RouteRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class RouteManagerTest {
    private RouteRepository repository = new RouteRepository();
    private RouteManager manager = new RouteManager(repository);
    private Route first = new Route(1, 1000, "LED", "LPK", 300);
    private Route second = new Route(2, 3000, "LED", "ROV", 400);
    private Route third = new Route(3, 10000, "LED", "LPK", 200);
    private Route fourth = new Route(4, 6000, "VKO", "OMS", 250);
    private Route fifth = new Route(5, 8000, "LED", "LPK", 240);

    @BeforeEach
    public void setUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void ShouldNotFound(){
        String airportFrom = "SVO";
        String airportTo = "DMO";

        Route[] expected = new Route[0];
        Route[] actual = manager.findAllPriceSort(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldNotFoundTicket(){
        String airportFrom = "LED";
        String airportTo = "DMO";

        Route[] expected = new Route[0];
        Route[] actual = manager.findAllPriceSort(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldNotFoundTicket2(){
        String airportFrom = "SVO";
        String airportTo = "LPK";

        Route[] expected = new Route[0];
        Route[] actual = manager.findAllPriceSort(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }


    @Test
    public void ShouldFoundAllTicket(){
       String airportFrom = "LED";
       String airportTo = "LPK";

       Route[] expected = new Route[]{first, fifth, third};
       Route[] actual = manager.findAllPriceSort(airportFrom, airportTo);
       assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFoundAllPriceSort(){
        String airportFrom = "LED";
        String airportTo = "LPK";

        Route[] expected = new Route[]{first, fifth, third};
        Route[] actual = manager.findAllPriceSort(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFoundAllTimeSort(){
        String airportFrom = "LED";
        String airportTo = "LPK";
        Comparator<Route> comparator = new TicketByTimeAscComparator();

        Route[] expected = new Route[]{third, fifth, first};
        Route[] actual = manager.findAllTimeSort(airportFrom, airportTo, comparator);
        assertArrayEquals(expected, actual);
    }
}