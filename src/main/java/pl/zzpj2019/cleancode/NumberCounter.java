package pl.zzpj2019.cleancode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NumberCounter {

    private Map<Integer, Integer> numbersCounts = new HashMap<>();
    private int minValue = Integer.MAX_VALUE;
    private int maxValue = Integer.MIN_VALUE;

    public NumberCounter(List<Integer> valueList) {
        addValues(valueList);
    }

    public void addValues(List<Integer> numbers) {
        numbers.forEach(this::addValue);
    }

    public void addValue(Integer number) {
        addNumberOccurrence(number);
        updateMinAndMaxValue(number);
    }

    private void addNumberOccurrence(Integer number) {
        Integer currentNumberCount = numbersCounts.getOrDefault(number, 0);
        numbersCounts.put(number, currentNumberCount + 1);
    }

    private void updateMinAndMaxValue(Integer number) {
        if (number < minValue) {
            minValue = number;
        }

        if (number > maxValue) {
            maxValue = number;
        }
    }

    public int getValueOrDefault(int i) {
        return numbersCounts.getOrDefault(i, 0);
    }

    public double calculateAverageValue() {
        double sum = 0;
        double numberCount = 0;

        for (Entry<Integer, Integer> entry : numbersCounts.entrySet()) {
            numberCount += entry.getValue();
            sum += entry.getKey() * entry.getValue();
        }

        if (numberCount != 0) {
            return sum / numberCount;
        } else {
            return 0;
        }
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}