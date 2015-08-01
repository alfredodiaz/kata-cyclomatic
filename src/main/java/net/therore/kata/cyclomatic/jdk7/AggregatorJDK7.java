package net.therore.kata.cyclomatic.jdk7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class AggregatorJDK7 {

    public Double average(Collection<Double> collection) {
        int count = 0;
        double sum = 0D;

        if (collection!=null) {
            for (Double item : collection) {
                if (item != null) {
                    count++;
                    sum += item;
                }
            }
        }

        if (count==0)
            return null;
        else
            return sum/count;
    }


    public Double median(Collection<Double> collection) {
        List<Double> values = new ArrayList<Double>();
        if (collection!=null) {
            for (Double item : collection) {
                if (item != null)
                    values.add(item);
            }
        }

        if (values.isEmpty())
            return null;
        else
            return values.get((values.size()-1)/2);
    }
}
