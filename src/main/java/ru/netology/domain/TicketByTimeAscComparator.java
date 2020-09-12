package ru.netology.domain;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<Route> {
    public int compare(Route o1, Route o2){
    return o1.getTravelTime() - o2.getTravelTime();
    }
}
