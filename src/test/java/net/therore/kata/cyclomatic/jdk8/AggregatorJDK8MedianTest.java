package net.therore.kata.cyclomatic.jdk8;

import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;

public class AggregatorJDK8MedianTest {

    private final AggregatorJDK8 aggregator;

    public AggregatorJDK8MedianTest() {
        this.aggregator = new AggregatorJDK8();
    }

    @Test
    public void whenCollectionContainsTwoNumbers() {
        Double[] array = {2D, 4D};

        OptionalDouble median = aggregator.median(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.of(2D), median);
    }

    @Test
    public void whenCollectionContainsFiveNumbers() {
        Double[] array = {1D, 2D, 3D, 4D, 5D};

        OptionalDouble median = aggregator.median(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.of(3D), median);
    }

    @Test
    public void whenCollectionContainsOneNumber() {
        Double[] array = {2D};

        OptionalDouble median = aggregator.median(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.of(2D), median);
    }


    @Test
    public void whenCollectionContainsNoNumbers() {
        Double[] array = {};

        OptionalDouble median = aggregator.median(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.empty(), median);
    }


    @Test
    public void whenCollectionIsNull() {
        OptionalDouble median = aggregator.median(Optional.empty());

        assertEquals(OptionalDouble.empty(), median);
    }

    @Test
    public void whenCollectionContainsANull() {
        Double[] array = {2D, null};

        OptionalDouble median = aggregator.median(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.of(2D), median);
    }


    @Test
    public void whenCollectionContainsOnlyNulls() {
        Double[] array = {null, null};

        OptionalDouble median = aggregator.median(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.empty(), median);
    }
}
