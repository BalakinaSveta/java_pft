package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodPointTests {

    @Test

    public void testDistance(){

      MethodPoint p1 = new MethodPoint(2, 4);
      MethodPoint p2 = new MethodPoint(6, 10);

      assert p1.distance(p2) == 7.211102550927978;
      Assert.assertEquals(p1.distance(p2), 7.211102550927978);
      Assert.assertTrue(p1.distance(p2) == 7.211102550927978);
      Assert.assertFalse(p1.distance(p2) == 8.211102550927978);
    }
  }

