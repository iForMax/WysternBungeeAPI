package me.firas.corebungeeapi.guild;

import me.firas.corebungeeapi.guild.quest.GuildQuestData;
import me.firas.corebungeeapi.guild.quest.QuestId;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Guild extends DocumentSerializable {
    GuildId id();
    String name();
    GuildTag tag();
    GuildBanner banner();
    long xp();
    int level();
    PlayerId ownerId();
    Collection<GuildMember> members();
    default int maximumPlayers(){
        return 150;
    }
    int bankBezants();
    default int maximumBankBezants(){
        return 10000;
    }
    Instant createdAt();
    GuildSocial socials();
    List<GuildRank> ranks();
    List<GuildId> allies();
    List<GuildId> enemies();
    GuildStats stats();
    Collection<GuildRequest> requests();
    GuildQuestData questData();
    default List<QuestId> weeklyQuests() {
        return questData().weeklyQuests();
    }

    default QuestId guildGoalQuestId() {
        return questData().guildGoalQuestId();
    }

    default Instant weeklyQuestRefreshDate() {
        return questData().refreshDate();
    }

    default Set<PlayerId> guildGoalCompletedMembers() {
        return questData().guildGoalCompletedMembers();
    }

    default boolean isGuildGoalCompleted() {
        return questData().isGuildGoalCompleted();
    }

    // Helper methods for quest management
    default int guildGoalProgress() {
        return guildGoalCompletedMembers().size();
    }

    default boolean needsQuestRefresh() {
        Instant lastSunday8PM = getLastTime();
        return weeklyQuestRefreshDate().isBefore(lastSunday8PM);
    }

    private static Instant getLastTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sunday8PM = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
                .withHour(20).withMinute(0).withSecond(0).withNano(0);

        if (now.isBefore(sunday8PM)) {
            sunday8PM = sunday8PM.minusWeeks(1);
        }

        return sunday8PM.atZone(ZoneId.systemDefault()).toInstant();
    }

}
