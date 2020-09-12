package ru.netology.repository;

import ru.netology.domain.Route;
import ru.netology.exception.NotFoundException;

public class RouteRepository {
    private Route[] items = new Route[0];

    public void save(Route item) {
        int length = items.length + 1;
        Route[] tmp = new Route[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int index = tmp.length - 1;
        tmp[index] = item;
        items = tmp;
    }

    public Route[] findAll(){
        return items;
    }

    public Route findById(int id){
        for(Route product : items){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public void removeById(int id){
        if (findById(id) == null){
            throw new NotFoundException("Element with id " + id + " not found");
        }
        int length = items.length - 1;
        Route[] tmp = new Route[length];
        int index = 0;
        for (Route item : items){
            if (item.getId() != id){
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
