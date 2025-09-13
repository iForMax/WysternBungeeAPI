package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import me.firas.corebungeeapi.guild.PlayerId;

import java.time.Instant;
import java.util.Set;

public interface GuildQuestGoalProgress extends DocumentSerializable {
    GuildQuestGoal goal();
    int currentCompletions();
    Set<PlayerId> completedPlayers();
    boolean isCompleted();
    Instant startedAt();
    Instant completedAt();
}