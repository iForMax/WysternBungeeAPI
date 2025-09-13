package me.firas.corebungeeapi.guild.quest;

import me.firas.corebungeeapi.guild.DocumentSerializable;
import org.bson.Document;

import java.util.Objects;
import java.util.UUID;

// Guild Quest ID
public final class GuildQuestId implements DocumentSerializable {
    private final UUID value;
    
    public GuildQuestId(UUID value) {
        this.value = Objects.requireNonNull(value, "value");
    }
    
    public static GuildQuestId random() { return new GuildQuestId(UUID.randomUUID()); }
    public static GuildQuestId of(UUID value) { return new GuildQuestId(value); }
    public UUID value() { return value; }
    
    @Override public boolean equals(Object o) { 
        return o instanceof GuildQuestId && ((GuildQuestId)o).value.equals(value); 
    }
    @Override public int hashCode() { return value.hashCode(); }
    @Override public String toString() { return value.toString(); }
    
    @Override
    public Document toDocument() {
        return new Document("uuid", value.toString());
    }
    
    public static GuildQuestId fromDocument(Document doc) {
        return new GuildQuestId(UUID.fromString(doc.getString("uuid")));
    }
}