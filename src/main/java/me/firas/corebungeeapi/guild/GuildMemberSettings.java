package me.firas.corebungeeapi.guild;

import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

@Setter
@Getter
public class GuildMemberSettings implements DocumentSerializable {
    private boolean chatEnabled = true;
    private boolean officerChatEnabled = true;
    public GuildMemberSettings() {}

    @Override
    public Document toDocument() {
        Document doc = new Document();
        doc.append("chatEnabled", chatEnabled);
        doc.append("officerChatEnabled", officerChatEnabled);
        return doc;
    }

    public static GuildMemberSettings fromDocument(Document doc) {
        GuildMemberSettings settings = new GuildMemberSettings();
        settings.setChatEnabled(doc.getBoolean("chatEnabled", true));
        settings.setOfficerChatEnabled(doc.getBoolean("officerChatEnabled", true));
        return settings;
    }
}
