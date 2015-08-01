package net.therore.kata.cyclomatic.jdk7;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class AggregatorJDK7Test {

    private final AggregatorJDK7 aggregator;

    public AggregatorJDK7Test() {
        this.aggregator = new AggregatorJDK7();
    }

    @Test
    public void whenCollectionContainsTwoNumbers() {
        Double[] array = {2D, 4D};

        Double result = aggregator.average(Arrays.asList(array));

        assertEquals(3D, result);
    }

    @Test
    public void whenCollectionContainsOneNumber() {
        Double[] array = {2D};

        Double result = aggregator.average(Arrays.asList(array));

        assertEquals(2D, result);
    }


    @Test
    public void whenCollectionContainsNoNumbers() {
        Double[] array = {};

        Double result = aggregator.average(Arrays.asList(array));

        assertEquals(null, result);
    }


    @Test
    public void whenCollectionIsNull() {

        Double result = aggregator.average(null);

        assertEquals(null, result);
    }

    @Test
    public void whenCollectionContainsANull() {
        Double[] array = {2D, null};

        Double result = aggregator.average(Arrays.asList(array));

        assertEquals(2D, result);
    }


    @Test
    public void whenCollectionContainsOnlyNulls() {
        Double[] array = {null, null};

        Double result = aggregator.average(Arrays.asList(array));

        assertEquals(null, result);
    }

}