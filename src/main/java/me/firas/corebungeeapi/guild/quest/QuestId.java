package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import org.bson.Document;

import java.util.Objects;
import java.util.UUID;

public final class QuestId implements DocumentSerializable {
    private final UUID value;

    public QuestId(UUID value) {
        this.value = Objects.requireNonNull(value, "value");
    }

    public static QuestId random() { return new QuestId(UUID.randomUUID()); }
    public UUID value() { return value; }
    
    @Override public boolean equals(Object o) { 
        return o instanceof QuestId && ((QuestId)o).value.equals(value); 
    }
    @Override public int hashCode() { return value.hashCode(); }
    @Override public String toString() { return value.toString(); }
    
    @Override
    public Document toDocument() {
        return new Document("uuid", value.toString());
    }
}
