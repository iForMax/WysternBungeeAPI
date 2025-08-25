package me.firas.corebungeeapi.guild;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface GuildService {
    Guild createGuild(String name, GuildTag tag, PlayerId ownerId, GuildBanner banner);
    void disband(GuildId guildId);
    void inviteMember(GuildId guildId, PlayerId playerId, PlayerId invitedBy);
    void removeMember(GuildId guildId, PlayerId playerId, PlayerId removedBy);
    void setMemberRank(GuildId guildId, PlayerId playerId, GuildRank newRank, PlayerId changedBy);
    void addXp(GuildId guildId, long amount, String reason);
    void setXp(GuildId guildId, long value);
    void setTag(GuildId guildId, GuildTag newTag, PlayerId changedBy);
    void setBanner(GuildId guildId, GuildBanner banner, PlayerId changedBy);
    Optional<Guild> findById(GuildId id);
    Optional<Guild> findByTag(GuildTag tag);
    Optional<Guild> getGuildByUserUUID(UUID playerUUID);
    void setStat(GuildId guildId, String key, Object value);
    Optional<Object> getStat(GuildId guildId, String key);
    Collection<Guild> listGuilds();
    void startWeeklyQuest(GuildId guildId, GuildQuest quest);
    void endWeeklyQuest(GuildId guildId);
}
