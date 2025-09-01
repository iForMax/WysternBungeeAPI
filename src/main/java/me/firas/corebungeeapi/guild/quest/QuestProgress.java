package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import me.firas.corebungeeapi.guild.PlayerId;

import java.time.Instant;

public interface QuestProgress extends DocumentSerializable {
    QuestId questId();
    PlayerId playerId();
    int currentProgress();
    int requiredProgress();
    QuestProgressStatus status();
    Instant startedAt();
    Instant completedAt();
    
    default boolean isCompleted() {
        return currentProgress() >= requiredProgress();
    }
    
    default int progressPercentage() {
        return Math.min(100, (currentProgress() * 100) / requiredProgress());
    }
}