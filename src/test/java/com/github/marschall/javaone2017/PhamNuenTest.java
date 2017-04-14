package com.github.marschall.javaone2017;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.Test;

public class PhamNuenTest {

  @Test
  public void epoch() {
    ZonedDateTime moonLanding = ZonedDateTime.of(1969, 7, 20, 20, 18, 4, 0, ZoneOffset.UTC);
    System.out.println(moonLanding.toInstant().toEpochMilli());
  }

}
