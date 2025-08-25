package me.firas.corebungeeapi.guild;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

public interface QuestScheduler {
    QuestPeriod currentWeeklyPeriod(ZoneId serverZone, Instant referenceTime);
    QuestPeriod nextWeeklyPeriod(ZoneId serverZone, Instant referenceTime);

    DayOfWeek RESET_DAY = DayOfWeek.SATURDAY;
    LocalTime RESET_TIME = LocalTime.of(20,0);
}
