package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.models.utils.Point;

public class Route {
    private Point end;
    private Point start;

    public Route(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getEnd() {
        return end;
    }

    public Point getStart() {
        return start;
    }
}
