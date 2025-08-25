package me.firas.corebungeeapi.guild;

import lombok.Getter;

import java.util.Set;

public interface GuildRank {
    Type name();
    int priority();
    Set<GuildPermission> permissions();
    default boolean has(GuildPermission p){ return permissions().contains(p); }

    public enum Type{
        MASTER("&cFounder"),
        CO_MASTER("&6Co Master"),
        OFFICER("&aOfficer"),
        MEMBER("&9Member"),
        NEW("&7New");

        @Getter
        private final String displayName;

        Type(String displayName) {
            this.displayName = displayName;
        }
    }
}
