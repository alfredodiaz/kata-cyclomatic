package net.therore.kata.cyclomatic.jdk7;

import net.therore.kata.cyclomatic.jdk8.AggregatorJDK8;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;

public class AggregatorJDK7MedianTest {

    private final AggregatorJDK7 aggregator;

    public AggregatorJDK7MedianTest() {
        this.aggregator = new AggregatorJDK7();
    }

    @Test
    public void whenCollectionContainsTwoNumbers() {
        Double[] array = {2D, 4D};

        Double median = aggregator.median(Arrays.asList(array));

        assertEquals(2D, median);
    }

    @Test
    public void whenCollectionContainsFiveNumbers() {
        Double[] array = {1D, 2D, 3D, 4D, 5D};

        Double median = aggregator.median(Arrays.asList(array));

        assertEquals(3D, median);
    }

    @Test
    public void whenCollectionContainsOneNumber() {
        Double[] array = {2D};

        Double median = aggregator.median(Arrays.asList(array));

        assertEquals(2D, median);
    }


    @Test
    public void whenCollectionContainsNoNumbers() {
        Double[] array = {};

        Double median = aggregator.median(Arrays.asList(array));

        assertEquals(null, median);
    }


    @Test
    public void whenCollectionIsNull() {
        Double median = aggregator.median(null);

        assertEquals(null, median);
    }

    @Test
    public void whenCollectionContainsANull() {
        Double[] array = {2D, null};

        Double median = aggregator.median(Arrays.asList(array));

        assertEquals(2D, median);
    }


    @Test
    public void whenCollectionContainsOnlyNulls() {
        Double[] array = {null, null};

        Double median = aggregator.median(Arrays.asList(array));

        assertEquals(null, median);
    }
}
