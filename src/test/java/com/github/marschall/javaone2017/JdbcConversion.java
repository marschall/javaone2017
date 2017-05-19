package com.github.marschall.javaone2017;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;

import org.junit.Test;

public class JdbcConversion {

  @Test
  public void lossyConversion() {
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
    LocalDateTime notExisting = transition.getDateTimeBefore().plus(gap.dividedBy(2L));

    Timestamp timestamp = java.sql.Timestamp.valueOf(notExisting);
    assertEquals(notExisting, timestamp.toLocalDateTime());
  }

}
