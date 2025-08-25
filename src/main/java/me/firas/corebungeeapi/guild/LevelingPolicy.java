package me.firas.corebungeeapi.guild;

public interface LevelingPolicy {
    int levelFor(long xp);
    default long xpRequiredForNext(int currentLevel){ return 0L; }
}
