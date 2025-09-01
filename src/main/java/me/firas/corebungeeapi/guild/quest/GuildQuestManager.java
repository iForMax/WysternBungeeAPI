package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.GuildId;
import me.firas.corebungeeapi.guild.PlayerId;

import java.util.List;

public interface GuildQuestManager {
    // Weekly refresh functionality
    void refreshWeeklyQuests(GuildId guildId);
    List<Quest> getActiveQuests(GuildId guildId);
    GuildGoalQuest getGuildGoalQuest(GuildId guildId);

    // Quest progress tracking
    void updateQuestProgress(PlayerId playerId, QuestId questId, int progressIncrement);
    List<QuestProgress> getPlayerQuestProgress(PlayerId playerId);
    List<QuestProgress> getGuildQuestProgress(GuildId guildId);

    // Game-specific progress tracking
    void onPlayerWin(PlayerId playerId, String gameType);
    void onPlayerKill(PlayerId playerId, String gameType, int killCount);
    void onPlayerDeath(PlayerId playerId, String gameType);
    void onPlayerJoinGame(PlayerId playerId, String gameType);
    void onObjectiveComplete(PlayerId playerId, String gameType, String objectiveType);

    // Quest completion
    void completeQuest(PlayerId playerId, QuestId questId);
    void checkGuildGoalProgress(GuildId guildId);

    // Quest pool management
    List<Quest> getAvailableQuestsPool();
    List<Quest> getQuestsByGameType(String gameType);
    List<Quest> selectRandomQuests(int count, QuestDifficulty minDifficulty, QuestDifficulty maxDifficulty);
    List<Quest> selectRandomQuestsWithGameVariety(int count); // Ensures variety across game types
}
