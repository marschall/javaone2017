package com.github.marschall.javaone2017;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;

import org.junit.Test;

public class JdbcConversion {

  @Test
  public void timestampConversion() {
    ZoneId systemTimezone = ZoneId.systemDefault();
    Instant now = Instant.now();

    ZoneRules rules = systemTimezone.getRules();
    ZoneOffsetTransition transition = rules.nextTransition(now);
    assertNotNull(transition);
    if (!transition.getDateTimeBefore().isBefore(transition.getDateTimeAfter())) {
      transition = rules.nextTransition(transition.getInstant().plusSeconds(1L));
      assertNotNull(transition);
    }

    Duration gap = Duration.between(transition.getDateTimeBefore(), transition.getDateTimeAfter());
    LocalDateTime betweenTransitions = transition.getDateTimeBefore().plus(gap.dividedBy(2L));

    Timestamp timestamp = java.sql.Timestamp.valueOf(betweenTransitions);
    assertEquals(betweenTransitions, timestamp.toLocalDateTime());
  }



  @Test
  public void timeConversion() {
    LocalTime expected = LocalTime.of(9, 50, 4, 45789000);

    Time time = java.sql.Time.valueOf(expected);
    assertEquals(expected, time.toLocalTime());
  }

}
