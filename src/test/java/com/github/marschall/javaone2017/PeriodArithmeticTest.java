package com.github.marschall.javaone2017;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

public class PeriodArithmeticTest {

  @Test
  public void addYear() {
    LocalDateTime february29 = LocalDateTime.of(2016, 2, 29, 12, 0);
    assertEquals(LocalDateTime.of(2017, 2, 28, 12, 0), february29.plusYears(1L));
  }

  @Test
  public void addMonth() {
    LocalDateTime january31 = LocalDateTime.of(2017, 1, 31, 12, 0);
    assertEquals(LocalDateTime.of(2017, 2, 28, 12, 0), january31.plusMonths(1L));
  }

}
