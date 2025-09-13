package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;

import java.time.Instant;

// Individual Guild Quest - One of the 3 assigned to guild
public interface GuildQuest extends DocumentSerializable {
    GuildQuestId id();
    String questTypeId();
    Instant assignedAt();
    Instant expiresAt();
    QuestStatus status();
}