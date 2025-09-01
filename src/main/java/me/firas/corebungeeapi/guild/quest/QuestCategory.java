package me.firas.corebungeeapi.guild.quest;

public enum QuestCategory {
    COMBAT("Combat"),
    EXPLORATION("Exploration"),
    CRAFTING("Crafting"),
    SOCIAL("Social"),
    COLLECTION("Collection"),
    ACHIEVEMENT("Achievement");
    
    private final String displayName;
    
    QuestCategory(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() { return displayName; }
}