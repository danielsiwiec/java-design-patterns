package com.spacefrog;

public class Grid {
    private static int CELL_COUNT = 4;

    private static int MELEE_DISTANCE = 3;
    private Unit[][] cells = new Unit[CELL_COUNT][CELL_COUNT];

    public void handleMelee() {
        for (int x = 0; x < CELL_COUNT; x++) {
            for (int y = 0; y < CELL_COUNT; y++) {
                handleCell(x, y);
            }
        }
    }

    void add(Unit newUnit) {
        int cellX = (int) newUnit.x / CELL_COUNT;
        int cellY = (int) newUnit.y / CELL_COUNT;

        newUnit.previous = null;

        Unit original = cells[cellX][cellY];
        if (original != null) {
            newUnit.next = original;
            original.previous = newUnit;
        }
        cells[cellX][cellY] = newUnit;

    }

    public void move(Unit unit, double x, double y) {
        int oldCellX = (int) unit.x / CELL_COUNT;
        int oldCellY = (int) unit.y / CELL_COUNT;

        int newCellX = (int) x / CELL_COUNT;
        int newCellY = (int) y / CELL_COUNT;

        unit.x = x;
        unit.y = y;

        if (oldCellX == newCellX && oldCellY == newCellY) {
            return;
        }

        // Unlink it from the list of its old cell.
        if (unit.previous != null) {
            unit.previous.next = unit.next;
        }

        if (unit.next != null) {
            unit.next.previous = unit.next;
        }

        // If it's the head of a list, remove it.
        if (cells[oldCellX][oldCellY] == unit) {
            cells[oldCellX][oldCellY] = unit.next;
        }

        add(unit);
    }

    private void handleCell(int x, int y) {
        Unit unit = cells[x][y];
        while (unit != null) {
            // Handle other units in this cell.
            handleUnit(unit, unit.next);

            // Also try the neighboring cells.
            if (x > 0 && y > 0) handleUnit(unit, cells[x - 1][y - 1]);
            if (x > 0) handleUnit(unit, cells[x - 1][y]);
            if (y > 0) handleUnit(unit, cells[x][y - 1]);
            if (x > 0 && y < CELL_COUNT - 1) {
                handleUnit(unit, cells[x - 1][y + 1]);
            }

            unit = unit.next;
        }
    }

    private void handleUnit(Unit unit, Unit other) {
        while (other != null) {
            if (unit.distance(other) < MELEE_DISTANCE) {
                handleAttack(unit, other);
            }
            other = other.next;
        }
    }

    private void handleAttack(Unit unit, Unit other) {
        System.out.println(String.format("Units at combat:\n%s\n%s", unit, other ));
    }
}
