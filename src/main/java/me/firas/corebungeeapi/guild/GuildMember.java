package me.firas.corebungeeapi.guild;

import java.time.Instant;
import java.util.Optional;

public interface GuildMember {
    PlayerId playerId();
    GuildRank rank();
    Instant joinedAt();
    GuildMemberSettings settings();

    Optional<String> currentQuestId(); // ID of the currently assigned quest
    Instant lastQuestCompletion(); // When the player last completed a quest
}
