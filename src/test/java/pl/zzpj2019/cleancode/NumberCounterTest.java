package pl.zzpj2019.cleancode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberCounterTest {

    ArrayList<Integer> testNumbers;
    Double expectedAverage;
    Integer expectedMin;
    Integer expectedMax;

    @BeforeEach
    void setupNumberCounter() {
        testNumbers =  new ArrayList<>(Arrays.asList(5, 4, 6, 7, 8, 1, 10, 22));
        expectedAverage = testNumbers.stream().mapToInt(i -> i).average().getAsDouble();
        expectedMin = testNumbers.stream().min(Integer::compareTo).get();
        expectedMax = testNumbers.stream().max(Integer::compareTo).get();
    }

    @Test
    void calculateAverageValue() {
        // given
        NumberCounter numberCounter = new NumberCounter(testNumbers);

        // when
        double resultAverage = numberCounter.calculateAverageValue();

        // then
        assertEquals(expectedAverage, resultAverage);
    }

    @Test
    void getMinValue() {
        // given
        NumberCounter numberCounter = new NumberCounter(testNumbers);

        // when
        int resultMinValue = numberCounter.getMinValue();

        // then
        assertEquals(expectedMin, resultMinValue);
    }

    @Test
    void getMaxValue() {
        // given
        NumberCounter numberCounter = new NumberCounter(testNumbers);

        // when
        int resultMaxValue = numberCounter.getMaxValue();

        // then
        assertEquals(expectedMax, resultMaxValue);
    }
}