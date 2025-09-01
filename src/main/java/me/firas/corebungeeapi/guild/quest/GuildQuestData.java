package me.firas.corebungeeapi.guild.quest;

import lombok.Getter;
import me.firas.corebungeeapi.guild.DocumentSerializable;
import me.firas.corebungeeapi.guild.PlayerId;
import org.bson.Document;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class GuildQuestData implements DocumentSerializable {
    private final List<QuestId> weeklyQuests; // The 3 quests available to the guild
    private final QuestId guildGoalQuestId;
    private final Instant refreshDate;
    private final Map<PlayerId, QuestId> memberAssignedQuests; // Each member gets 1 quest from the 3
    private final Set<PlayerId> guildGoalCompletedMembers; // Members who completed their assigned quest
    private final boolean guildGoalCompleted;
    private final int requiredMembersForGuildGoal;

    public GuildQuestData(List<QuestId> weeklyQuests, QuestId guildGoalQuestId,
                          Instant refreshDate, Map<PlayerId, QuestId> memberAssignedQuests,
                          Set<PlayerId> completedMembers, boolean goalCompleted,
                          int requiredMembers) {
        this.weeklyQuests = List.copyOf(weeklyQuests);
        this.guildGoalQuestId = guildGoalQuestId;
        this.refreshDate = refreshDate;
        this.memberAssignedQuests = Map.copyOf(memberAssignedQuests);
        this.guildGoalCompletedMembers = Set.copyOf(completedMembers);
        this.guildGoalCompleted = goalCompleted;
        this.requiredMembersForGuildGoal = requiredMembers;
    }

    public List<QuestId> weeklyQuests() { return weeklyQuests; }
    public QuestId guildGoalQuestId() { return guildGoalQuestId; }
    public Instant refreshDate() { return refreshDate; }
    public Map<PlayerId, QuestId> memberAssignedQuests() { return memberAssignedQuests; }
    public Set<PlayerId> guildGoalCompletedMembers() { return guildGoalCompletedMembers; }
    public boolean isGuildGoalCompleted() { return guildGoalCompleted; }
    public int requiredMembersForGuildGoal() { return requiredMembersForGuildGoal; }

    @Override
    public Document toDocument() {
        return new Document()
                .append("weeklyQuests", weeklyQuests.stream().map(QuestId::toDocument).toList())
                .append("guildGoalQuestId", guildGoalQuestId.toDocument())
                .append("refreshDate", refreshDate)
                .append("memberAssignedQuests", memberAssignedQuests.entrySet().stream()
                        .collect(Collectors.toMap(
                                entry -> entry.getKey().toString(),
                                entry -> entry.getValue().toDocument())))
                .append("completedMembers", guildGoalCompletedMembers.stream().map(PlayerId::toString).toList())
                .append("guildGoalCompleted", guildGoalCompleted)
                .append("requiredMembers", requiredMembersForGuildGoal);
    }
}