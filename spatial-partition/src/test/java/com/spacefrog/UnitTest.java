package com.spacefrog;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnitTest {

    @Test
    public void shouldCalculateDistance() {
        Unit unit1 = new Unit(new Grid(), 1, 1);
        Unit unit2 = new Unit(new Grid(), 1, 3);
        assertThat(unit1.distance(unit2), is(2.0));
    }
}
