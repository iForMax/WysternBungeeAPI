package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import me.firas.corebungeeapi.guild.GuildId;
import me.firas.corebungeeapi.guild.PlayerId;

public interface QuestReward extends DocumentSerializable {
    String getDescription();
    void applyToPlayer(PlayerId playerId);
    void applyToGuild(GuildId guildId);
}