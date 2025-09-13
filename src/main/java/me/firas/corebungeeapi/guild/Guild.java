package me.firas.corebungeeapi.guild;


import me.firas.corebungeeapi.guild.quest.GuildQuest;
import me.firas.corebungeeapi.guild.quest.GuildQuestData;
import me.firas.corebungeeapi.guild.quest.PlayerQuestAssignment;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
    // NEW: Quest-related methods
    GuildQuestData getQuestData();

    // Helper methods for quests
    default List<GuildQuest> getCurrentQuests() {
        return getQuestData().getCurrentQuests();
    }

    default Optional<PlayerQuestAssignment> getPlayerQuest(PlayerId playerId) {
        return getQuestData().getPlayerAssignment(playerId);
    }

    default boolean hasQuests() {
        return getQuestData().hasActiveQuests();
    }

    default boolean needsQuestRefresh() {
        return getQuestData().isRefreshDue();
    }
}
