package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import me.firas.corebungeeapi.guild.PlayerId;

import java.time.Instant;
import java.util.Set;

// Guild Quest Goal Progress Tracking
public interface GuildQuestGoalProgress extends DocumentSerializable {
    String getGoalId();
    int getCurrentCompletions();
    Set<PlayerId> getCompletedPlayers();
    boolean isGoalMet();
    Instant getLastUpdated();
}
