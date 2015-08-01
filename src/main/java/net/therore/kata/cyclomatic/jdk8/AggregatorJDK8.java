package net.therore.kata.cyclomatic.jdk8;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggregatorJDK8 {

    public OptionalDouble average(Optional<Stream<Double>> stream) {
        return stream
                .map(s -> s
                    .filter(Objects::nonNull)
                    .mapToDouble(Double::doubleValue)
                    .average()
                ).orElse(OptionalDouble.empty());

    }

    public OptionalDouble median(Optional<Stream<Double>> stream) {
        return stream
                .map(s -> {
                            List<Double> list =
                                    s.filter(Objects::nonNull).collect(Collectors.toList());

                            return list.isEmpty() ?
                                    OptionalDouble.empty() : OptionalDouble.of(list.get((list.size()-1)/2));
                        }
                    ).orElse(OptionalDouble.empty());

                }
    }