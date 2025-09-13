package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import me.firas.corebungeeapi.guild.GuildId;
import me.firas.corebungeeapi.guild.PlayerId;

import java.time.Instant;
import java.util.Map;

// Quest-related interfaces and classes
public interface GuildQuest extends DocumentSerializable {
    String id();
    String name();
    String description();
    QuestDifficulty difficulty();
    Map<String, Object> requirements();
    Map<String, Object> rewards();
    Instant expiresAt();
    boolean isCompleted(PlayerId playerId, GuildId guildId);
}