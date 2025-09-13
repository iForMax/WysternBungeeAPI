package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.Guild;
import me.firas.corebungeeapi.guild.PlayerId;

import java.util.List;
import java.util.Optional;

// Quest Service Interface - For quest logic operations (not data persistence)
public interface GuildQuestService {
    
    // Quest Assignment Operations
    void assignRandomQuestsToGuild(Guild guild);
    boolean assignQuestToPlayer(Guild guild, PlayerId playerId);
    void refreshGuildQuests(Guild guild);
    void performScheduledRefresh(Guild guild);
    
    // Quest Progress Operations
    void updatePlayerProgress(Guild guild, PlayerId playerId, String progressKey, Object value);
    boolean checkAndCompleteQuest(Guild guild, PlayerId playerId);
    
    // Guild Goal Operations
    void updateGoalProgress(Guild guild);
    void checkAndAwardGoalRewards(Guild guild);
    
    // Quest Type Management
    List<QuestType> getAllQuestTypes();
    List<QuestType> getRandomQuests(int count);
    Optional<QuestType> getQuestType(String questTypeId);
}
