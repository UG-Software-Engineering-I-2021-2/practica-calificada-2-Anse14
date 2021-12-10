package com.utec.lab;

import com.utec.lab.classes.Pair;
import org.junit.Assert;
import org.junit.Test;

public class PairTest {
    @Test
    public void pair_creator() {
        var p = new Pair<Integer, Float>(10, 0.5f);

        Integer first = 10;
        Float second = 0.5f;

        Assert.assertEquals(first, p.first());
        Assert.assertEquals(second, p.second());
    }
}
