package me.firas.corebungeeapi.guild;

import java.time.Instant;

public final class QuestPeriod {
    private final Instant start;
    private final Instant end;

    public QuestPeriod(Instant start, Instant end) {
        if (end.isBefore(start)) throw new IllegalArgumentException("end before start");
        this.start = start; this.end = end;
    }
    public Instant start(){ return start; }
    public Instant end(){ return end; }
    public boolean contains(Instant instant){ return !instant.isBefore(start) && instant.isBefore(end); }
}