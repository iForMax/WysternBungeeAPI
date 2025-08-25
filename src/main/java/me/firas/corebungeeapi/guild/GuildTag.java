package me.firas.corebungeeapi.guild;

import org.bson.Document;

public final class GuildTag implements DocumentSerializable{
    private final String value;
    private final String color;

    private static final String PATTERN = "^[A-Za-z0-9]{3}$";

    public GuildTag(String value, String color) {
        if (value == null || !value.matches(PATTERN)) {
            throw new IllegalArgumentException("Guild tag must be exactly 3 alphanumeric characters");
        }
        this.value = value.toUpperCase();
        this.color = translate(color == null ? "&f" : color);
    }
    private String translate(String message){
        return message.replaceAll("&","§");
    }

    public String value(){ return value; }
    public String color(){ return color; }
    @Override public String toString(){ return color + value; }
    @Override public boolean equals(Object o){ return o instanceof GuildTag && ((GuildTag)o).value.equals(value);}    
    @Override public int hashCode(){ return value.hashCode(); }


    @Override
    public Document toDocument() {
        return new Document("tag", value).append("color", color);
    }
}
