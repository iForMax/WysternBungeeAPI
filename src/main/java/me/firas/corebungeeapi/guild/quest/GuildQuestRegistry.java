package me.firas.corebungeeapi.guild.quest;

import java.util.Collection;
import java.util.Optional;

public interface GuildQuestRegistry {
    Collection<GuildQuest> getAllQuests();
    Collection<GuildQuest> getQuestsByDifficulty(QuestDifficulty difficulty);
    Optional<GuildQuest> getQuestById(String questId);
    Collection<GuildQuestGoal> getAllGoals();
    Optional<GuildQuestGoal> getGoalById(String goalId);
}