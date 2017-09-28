package com.spacefrog;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class GridTest {

  @Test
  public void shouldProperlyAddUnits() {
    Grid grid = new Grid();
    Unit unit1 = new Unit(grid, 1, 1);
    Unit unit2 = new Unit(grid, 1, 3);
    assertThat(unit1.previous, is(unit2));
    assertThat(unit1.next, nullValue());
    assertThat(unit2.next, is(unit1));
    assertThat(unit2.previous, nullValue());
  }
}
