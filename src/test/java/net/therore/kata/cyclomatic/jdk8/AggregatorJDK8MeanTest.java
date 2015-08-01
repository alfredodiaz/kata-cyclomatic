package net.therore.kata.cyclomatic.jdk8;

import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;

public class AggregatorJDK8MeanTest {

    private final AggregatorJDK8 aggregator;

    public AggregatorJDK8MeanTest() {
        this.aggregator = new AggregatorJDK8();
    }

    @Test
    public void whenCollectionContainsTwoNumbers() {
        Double[] array = {2D, 4D};

        OptionalDouble mean = aggregator.average(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.of(3D), mean);
    }

    @Test
    public void whenCollectionContainsOneNumber() {
        Double[] array = {2D};

        OptionalDouble result = aggregator.average(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.of(2D), result);
    }


    @Test
    public void whenCollectionContainsNoNumbers() {
        Double[] array = {};

        OptionalDouble result = aggregator.average(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.empty(), result);
    }


    @Test
    public void whenCollectionIsNull() {
        OptionalDouble result = aggregator.average(Optional.empty());

        assertEquals(OptionalDouble.empty(), result);
    }

    @Test
    public void whenCollectionContainsANull() {
        Double[] array = {2D, null};

        OptionalDouble result = aggregator.average(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.of(2D), result);
    }


    @Test
    public void whenCollectionContainsOnlyNulls() {
        Double[] array = {null, null};

        OptionalDouble result = aggregator.average(Optional.of(Stream.of(array).parallel()));

        assertEquals(OptionalDouble.empty(), result);
    }
}
