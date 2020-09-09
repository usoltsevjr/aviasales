package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Route;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class RouteRepositoryTest {
    private RouteRepository repository = new RouteRepository();
    private Route first = new Route(1, 1000, "LED", "LPK", 200);
    private Route second = new Route(2, 3000, "MMK", "ROV", 400);
    private Route third = new Route(3, 10000, "LED", "LPK", 200);
    private Route fourth = new Route(4, 6000, "VKO", "OMS", 250);

    @BeforeEach
    public void setUp(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    public void ShouldFindAllTicket(){
        Route[] expected = new Route[]{first, second, third, fourth};
        Route[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldThrowException(){
        int idToRemove = 5;
        assertThrows(NotFoundException.class, ()-> repository.removeById(idToRemove));
    }

    @Test
    public void ShouldNotThrowException(){
        int idToRemove = 2;
        repository.removeById(idToRemove);
        Route[] expected = new Route[]{first, third, fourth};
        Route[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}