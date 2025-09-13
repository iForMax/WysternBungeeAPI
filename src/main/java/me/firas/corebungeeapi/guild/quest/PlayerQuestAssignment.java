package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import me.firas.corebungeeapi.guild.PlayerId;

import java.time.Instant;
import java.util.Map;

// Player Quest Assignment - Links player to one of the guild's 3 quests
public interface PlayerQuestAssignment extends DocumentSerializable {
    PlayerId playerId();
    GuildQuestId assignedQuestId();
    Instant assignedAt();
    Instant completedAt();
    QuestStatus status();
    Map<String, Object> progress();
    boolean isCompleted();
}