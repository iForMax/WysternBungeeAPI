package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import me.firas.corebungeeapi.guild.GuildId;

import java.time.Instant;
import java.util.Map;

public interface GuildQuestGoal extends DocumentSerializable {
    String id();
    String name();
    String description();
    int requiredCompletions();
    Map<String, Object> guildRewards();
    Map<String, Object> playerRewards();
    boolean isCompleted(GuildId guildId);
    Instant expiresAt();
}