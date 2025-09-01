package me.firas.corebungeeapi.guild.quest;

import java.util.List;

public interface GuildGoalQuest extends Quest {
    List<QuestId> requiredQuests(); // The 3 weekly quests
    int requiredMemberCompletions(); // e.g., 8 members must complete all 3 quests
    List<QuestReward> guildWideRewards(); // Special rewards for entire guild
    
    default int getTotalDifficultyScore() {
        return requiredQuests().size() * 2;
    }
}