package me.firas.corebungeeapi.guild;

public interface GuildQuest {
    String id();
    String title();
    String description();
    QuestPeriod period();
}
