package me.firas.corebungeeapi.guild;

import me.firas.corebungeeapi.guild.quest.QuestId;

import java.time.Instant;

public interface GuildMember {
    PlayerId playerId();
    GuildRank rank();
    Instant joinedAt();
    GuildMemberSettings settings();
    // Quest tracking for individual members
    QuestId assignedQuestId(); // The single quest assigned to this member from guild's 3 weekly quests
    boolean hasCompletedAssignedQuest(); // Whether they completed their assigned quest
    Instant lastQuestCompletionDate(); // When they completed their quest
    int weeklyQuestStreak(); // How many consecutive weeks they completed their assigned quest
    int completedQuests();
}
