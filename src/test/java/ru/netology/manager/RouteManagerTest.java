package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Route;
import ru.netology.repository.RouteRepository;

import static org.junit.jupiter.api.Assertions.*;

class RouteManagerTest {
    private RouteRepository repository = new RouteRepository();
    private RouteManager manager = new RouteManager(repository);
    private Route first = new Route(1, 1000, "LED", "LPK", 200);
    private Route second = new Route(2, 3000, "MMK", "ROV", 400);
    private Route third = new Route(3, 10000, "LED", "LPK", 200);
    private Route fourth = new Route(4, 6000, "VKO", "OMS", 250);

    @BeforeEach
    public void setUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    public void ShouldNotFound(){
        String airportFrom = "SVO";
        String airportTo = "DMO";

        Route[] expected = new Route[0];
        Route[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldNotFoundTicket(){
        String airportFrom = "LED";
        String airportTo = "DMO";

        Route[] expected = new Route[0];
        Route[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldNotFoundTicket2(){
        String airportFrom = "SVO";
        String airportTo = "LPK";

        Route[] expected = new Route[0];
        Route[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }


    @Test
    public void ShouldFoundAllTicket(){
       String airportFrom = "LED";
       String airportTo = "LPK";

       Route[] expected = new Route[]{first, third};
       Route[] actual = manager.findAll(airportFrom, airportTo);
       assertArrayEquals(expected, actual);
    }
}