package me.firas.corebungeeapi.guild;

import java.time.Instant;
import java.util.Optional;

public interface QuestRepository {
    Optional<GuildQuest> findActiveFor(GuildId guildId, Instant at);
    void saveActive(GuildId guildId, GuildQuest quest);
    void clearActive(GuildId guildId);
}