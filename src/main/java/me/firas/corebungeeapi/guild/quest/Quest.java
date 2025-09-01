package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;

import java.time.Instant;
import java.util.List;

public interface Quest extends DocumentSerializable {
    QuestId id();
    String name();
    String description();
    QuestCategory category();
    QuestDifficulty difficulty();
    int completionRequirement();
    String completionDescription(); // e.g., "Kill 50 monsters", "Collect 100 resources"
    List<QuestReward> rewards();
    String gameType(); // The specific game this quest is for

    boolean isActive();
    Instant createdAt();
    Instant expiresAt();
}