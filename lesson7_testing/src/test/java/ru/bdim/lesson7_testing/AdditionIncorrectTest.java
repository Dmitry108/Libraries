package ru.bdim.lesson7_testing;

import org.junit.Assert;
import org.junit.Test;

import ru.bdim.lesson7_testing.unit.Addition;

public class AdditionIncorrectTest {

    @Test
    public void addIsNotCorrect() {
        int sum = Addition.add(1, 1);
        Assert.assertNotEquals(1, sum);
    }
}
