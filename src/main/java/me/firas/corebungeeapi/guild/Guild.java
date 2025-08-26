package me.firas.corebungeeapi.guild;

import java.util.Collection;
import java.util.List;

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
    GuildSocial socials();
    List<GuildRank> ranks();
    GuildStats stats();
    Collection<GuildRequest> requests();

}
