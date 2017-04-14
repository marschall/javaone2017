package com.github.marschall.javaone2017;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class ZonedVsOffsetTest {

  @Test
  public void addSemantics() {
    // 03:00 -> 02:00
    ZonedDateTime zonedBefore = ZonedDateTime.of(2017, 10, 29, 1, 0, 0, 0, ZoneId.of("Europe/Berlin"));
    ZonedDateTime zonedAfter = zonedBefore.plusDays(1L);
    assertEquals(Duration.ofHours(25L), Duration.between(zonedBefore, zonedAfter));

    OffsetDateTime offsetBefore = zonedBefore.toOffsetDateTime();
    OffsetDateTime offsetAfter = offsetBefore.plusDays(1L);
    assertEquals(Duration.ofHours(24L), Duration.between(offsetBefore, offsetAfter));
  }

}
