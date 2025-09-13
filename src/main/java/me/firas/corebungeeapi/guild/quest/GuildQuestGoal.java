package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;

import java.time.Instant;
import java.util.Map;

// Guild Quest Goal - Requirements for guild-wide rewards
public interface GuildQuestGoal extends DocumentSerializable {
    String getId();
    String getName();
    String getDescription();
    int getRequiredCompletions();
    Map<String, Object> getGuildRewards();
    Map<String, Object> getPlayerRewards();
    boolean isActive();
    Instant getStartTime();
    Instant getEndTime();
}