package me.firas.corebungeeapi.guild;

import org.bson.Document;

import java.util.Objects;
import java.util.UUID;

public final class GuildId implements DocumentSerializable {
    private final UUID value;

    public GuildId(UUID value) {
        this.value = Objects.requireNonNull(value, "value");
    }

    public static GuildId random() { return new GuildId(UUID.randomUUID()); }
    public UUID value() { return value; }
    @Override public boolean equals(Object o) { return o instanceof GuildId && ((GuildId)o).value.equals(value); }
    @Override public int hashCode() { return value.hashCode(); }
    @Override public String toString() { return value.toString(); }
    @Override
    public Document toDocument() {
        return new Document("uuid", value.toString());
    }
}