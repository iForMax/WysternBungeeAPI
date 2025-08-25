package me.firas.corebungeeapi.guild;

import org.bson.Document;

import java.util.Map;
import java.util.Optional;

public interface GuildStats extends DocumentSerializable {
    void setStat(String key, Object value);
    Optional<Object> getStat(String key);
    Map<String, Object> asMap();

    @Override
    default Document toDocument() {
        return new Document(asMap());
    }
}