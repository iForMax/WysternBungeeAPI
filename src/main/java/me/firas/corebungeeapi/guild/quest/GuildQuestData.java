package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import me.firas.corebungeeapi.guild.PlayerId;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Guild Quest Data - Contains all quest-related data for a guild
public interface GuildQuestData extends DocumentSerializable {
    // The 3 current guild quests
    List<GuildQuest> getCurrentQuests();
    
    // Player assignments to the 3 quests
    Map<PlayerId, PlayerQuestAssignment> getPlayerAssignments();
    
    // Quest refresh schedule
    Instant getLastRefresh();
    Instant getNextRefresh();
    int getRefreshCount();
    
    // Guild goals and their progress
    List<GuildQuestGoal> getActiveGoals();
    Map<String, GuildQuestGoalProgress> getGoalProgress();
    
    // Helper methods
    default boolean hasActiveQuests() {
        return getCurrentQuests().size() == 3;
    }
    
    default boolean isRefreshDue() {
        return Instant.now().isAfter(getNextRefresh());
    }
    
    default Optional<PlayerQuestAssignment> getPlayerAssignment(PlayerId playerId) {
        return Optional.ofNullable(getPlayerAssignments().get(playerId));
    }
    
    default boolean canAssignQuestToPlayer(PlayerId playerId) {
        return !getPlayerAssignments().containsKey(playerId) && hasActiveQuests();
    }
}
