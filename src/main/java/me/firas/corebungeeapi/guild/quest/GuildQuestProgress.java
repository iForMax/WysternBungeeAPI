package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import me.firas.corebungeeapi.guild.PlayerId;

import java.time.Instant;
import java.util.Map;

public interface GuildQuestProgress extends DocumentSerializable {
    GuildQuest quest();
    PlayerId playerId();
    Map<String, Object> progress();
    boolean isCompleted();
    Instant assignedAt();
    Instant completedAt();
}
