package com.imsteam.sell;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {
    @Test
    public void doTest() {
        int num = new Integer(1);
        Assert.assertEquals(num, 1);
    }
}
