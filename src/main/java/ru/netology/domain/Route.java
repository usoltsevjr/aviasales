package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Route implements Comparable<Route> {

    private int id;
    private int price;
    private String from;
    private String to;
    private int travelTime;

    @Override
    public int compareTo(Route o) {
        return price - o.price;
    }
}
