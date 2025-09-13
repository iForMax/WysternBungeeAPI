package me.firas.corebungeeapi.guild.quest;

public enum QuestDifficulty {
    EASY(1, "Easy"),
    MEDIUM(2, "Medium"),
    HARD(3, "Hard"),
    EXTREME(4, "Extreme");
    
    private final int level;
    private final String displayName;
    
    QuestDifficulty(int level, String displayName) {
        this.level = level;
        this.displayName = displayName;
    }
    
    public int getLevel() { return level; }
    public String getDisplayName() { return displayName; }
}