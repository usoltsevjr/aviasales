package ru.netology.manager;

import ru.netology.domain.Route;
import ru.netology.repository.RouteRepository;

import java.util.Arrays;

public class RouteManager {
    private RouteRepository repository;

    public RouteManager(RouteRepository repository){
        this.repository = repository;
    }

    public void add(Route item){
        repository.save(item);
    }

    public Route[] findAll(String From, String To){
        Route[] result = new Route[0];
        for (Route route : repository.findAll()){
            if(route.getFrom().equalsIgnoreCase(From) && route.getTo().equalsIgnoreCase(To)){
                Route[] tmp = new Route[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length -1] = route;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
