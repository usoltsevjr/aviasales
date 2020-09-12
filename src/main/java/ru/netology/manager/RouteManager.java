package ru.netology.manager;

import ru.netology.domain.Route;
import ru.netology.repository.RouteRepository;

import java.util.Arrays;
import java.util.Comparator;

public class RouteManager {
    private RouteRepository repository;

    public RouteManager(RouteRepository repository){
        this.repository = repository;
    }

    public void add(Route item){
        repository.save(item);
    }

    public Route[] findAllPriceSort(String from, String to){
        Route[] result = new Route[0];
        for (Route item : repository.findAll()){
            if(item.getFrom().equalsIgnoreCase(from) && item.getTo().equalsIgnoreCase(to)){
                Route[] tmp = new Route[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length -1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Route[] findAllTimeSort(String from, String to, Comparator<Route> comparator){
        Route[] result = new Route[0];
        for (Route item : repository.findAll()){
            if(item.getFrom().equalsIgnoreCase(from) && item.getTo().equalsIgnoreCase(to)){
                Route[] tmp = new Route[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length -1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

}
