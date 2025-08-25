package me.firas.corebungeeapi.guild;

import java.util.Optional;

public interface GuildRepository {
    Optional<Guild> findById(GuildId id);
    Optional<Guild> findByTag(GuildTag tag);
    Guild save(Guild guild);
    void delete(GuildId id);
}