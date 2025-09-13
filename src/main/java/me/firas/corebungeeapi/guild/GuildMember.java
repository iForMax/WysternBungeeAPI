package me.firas.corebungeeapi.guild;


import java.time.Instant;

public interface GuildMember {
    PlayerId playerId();
    GuildRank rank();
    Instant joinedAt();
    GuildMemberSettings settings();

}
