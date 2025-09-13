package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;

import java.util.Map;

// Quest Type Interface - Base for all quest types
public interface QuestType extends DocumentSerializable {
    String getId();
    String getName();
    String getDescription();
    QuestDifficulty getDifficulty();
    Map<String, Object> getRequirements();
    Map<String, Object> getRewards();
}