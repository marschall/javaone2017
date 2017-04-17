package com.github.marschall.javaone2017;

import static org.junit.Assert.assertEquals;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.Test;

public class PhamNuwenTest {

  @Test
  public void epoch() {
    ZonedDateTime moonLanding = ZonedDateTime.of(1969, 7, 20, 20, 18, 4, 0, ZoneOffset.UTC);
    assertEquals(-14182916000L, moonLanding.toInstant().toEpochMilli());
  }

}
