package me.firas.corebungeeapi.guild;
import me.firas.corebungeeapi.guild.quest.GuildQuest;
import me.firas.corebungeeapi.guild.quest.GuildQuestGoal;
import me.firas.corebungeeapi.guild.quest.GuildQuestGoalProgress;
import me.firas.corebungeeapi.guild.quest.GuildQuestProgress;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

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

    List<GuildQuest> activeQuests();
    Optional<GuildQuest> getQuest(String questId);
    Map<PlayerId, GuildQuestProgress> getQuestProgress();
    Optional<GuildQuestProgress> getPlayerQuestProgress(PlayerId playerId);
    Optional<GuildQuestGoal> activeGoal();
    Optional<GuildQuestGoalProgress> goalProgress();
    Instant lastQuestRefresh();
    Instant nextQuestRefresh();
}
