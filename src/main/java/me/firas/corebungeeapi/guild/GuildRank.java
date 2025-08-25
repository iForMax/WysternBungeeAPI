package me.firas.corebungeeapi.guild;

import java.util.Set;

public interface GuildRank {
    String name();
    int priority();
    Set<GuildPermission> permissions();
    default boolean has(GuildPermission p){ return permissions().contains(p); }
}
