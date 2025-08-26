package me.firas.corebungeeapi.guild;

import org.bson.Document;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GuildSocial implements DocumentSerializable {

    private final Map<String, String> socials = new HashMap<>();

    public GuildSocial() {}

    public void addSocial(String type, String link) {
        socials.put(type.toLowerCase(), link);
    }

    public void removeSocial(String type) {
        socials.remove(type.toLowerCase());
    }

    public Optional<String> getSocial(String type) {
        return Optional.ofNullable(socials.get(type.toLowerCase()));
    }

    public Map<String, String> getAllSocials() {
        return Collections.unmodifiableMap(socials);
    }

    @Override
    public Document toDocument() {
        return new Document("socials", new Document(socials));
    }

    public static GuildSocial fromDocument(Document doc) {
        GuildSocial guildSocial = new GuildSocial();
        Document socialsDoc = doc.get("socials", Document.class);
        socialsDoc.forEach((key, value) -> guildSocial.addSocial(key, value.toString()));
        return guildSocial;
    }
}
