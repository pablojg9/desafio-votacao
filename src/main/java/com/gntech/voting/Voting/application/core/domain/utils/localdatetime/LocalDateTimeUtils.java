package com.gntech.voting.Voting.application.core.domain.utils.localdatetime;

import java.time.LocalDateTime;
import java.time.LocalTime;

public final class LocalDateTimeUtils {

  public static boolean localDateVerification(LocalDateTime date1, LocalDateTime date2) {
    LocalTime time = LocalTime.now();
    return time.isBefore(date1.toLocalTime()) || time.isAfter(date2.toLocalTime());
  }
}
