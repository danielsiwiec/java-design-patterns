package com.spacefrog;

public class Unit {

    private Grid grid;
    double x;
    double y;

    Unit previous;
    Unit next;

    public Unit(Grid grid, double x, double y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        grid.add(this);
    }

    public void move(double x, double y) {
        grid.move(this, x, y);
    }

    public double distance(Unit other) {
        return Math.sqrt(Math.pow((this.x - other.x), 2) + Math.pow((this.y - other.y), 2));
    }

    public String toString() {
        return String.format("Unit at %f %f", x, y);
    }
}
