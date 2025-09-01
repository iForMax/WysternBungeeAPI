package me.firas.corebungeeapi.guild.quest;

import lombok.Getter;

@Getter
public enum QuestDifficulty {
    VERY_EASY(1,"&2Very Easy"),
    EASY(2, "&aEasy"),
    MEDIUM(3, "&6Medium"),
    HARD(4, "&cHard"),
    VERY_HARD(5,"&4Very Hard"),
    DIFFICULT(6,"&c✪ &4Difficult");
    
    private final int difficultyScore;
    private final String displayName;
    
    QuestDifficulty(int difficultyScore, String displayName) {
        this.difficultyScore = difficultyScore;
        this.displayName = displayName;
    }
    

}