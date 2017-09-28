package com.spacefrog.app;

import com.spacefrog.Grid;
import com.spacefrog.Unit;

public class App {

  public static void main(String[] args) {
    Grid grid = new Grid();
    new Unit(grid, 1, 1);
    new Unit(grid, 1, 3);
    grid.evaluateGrid();
  }
}
