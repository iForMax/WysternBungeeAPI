package me.firas.corebungeeapi.guild;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.Document;

import java.time.Instant;

import java.util.Objects;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
public final class GuildRequest implements DocumentSerializable {
    private UUID id;          // unique id for request
    private PlayerId sender;  // who sent (inviter or applicant)
    private  PlayerId target;  // who is invited or applying
    private Instant createdAt;

    @Override
    public Document toDocument() {
        return new Document("uuid",id.toString()).append("sender",sender.toDocument()).append("target",target.toDocument()).append("createdAt",createdAt.toEpochMilli());
    }

    public static GuildRequest fromDocument(Document doc) {
        UUID id = UUID.fromString(doc.getString("id"));
        PlayerId sender = PlayerId.fromDocument(doc.get("sender", Document.class));
        PlayerId target = PlayerId.fromDocument(doc.get("target", Document.class));
        Instant createdAt = Instant.ofEpochMilli(doc.getLong("createdAt"));
        Type type = Type.valueOf(doc.getString("type"));
        return new GuildRequest(id, sender, target, createdAt, type);
    }
    public enum Type { INVITE, APPLY }

    private Type type;

    public GuildRequest(PlayerId sender, PlayerId target, Type type) {
        this.id = UUID.randomUUID();
        this.sender = Objects.requireNonNull(sender);
        this.target = Objects.requireNonNull(target);
        this.type = Objects.requireNonNull(type);
        this.createdAt = Instant.now();
    }

    public UUID id() { return id; }
    public PlayerId sender() { return sender; }
    public PlayerId target() { return target; }
    public Instant createdAt() { return createdAt; }
    public Type type() { return type; }
}
