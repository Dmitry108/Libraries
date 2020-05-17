package ru.bdim.lesson7_testing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import ru.bdim.lesson7_testing.unit.Addition;

@RunWith(Parameterized.class)
public class AdditionCorrectTest {

    @Parameterized.Parameters
    public static List<Integer[]> testData(){
        return Arrays.asList(new Integer[][]{
                {1, 1, 2},
                {-8, 8, 0},
                {2, 3, 5},
                {444, 111, 555},
                {123, 123, 246}
        });
    }

    private int a, b, c;

    public AdditionCorrectTest(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Test
    public void addIsCorrect(){
        Assert.assertEquals(c, Addition.add(a, b));
    }
}