package me.firas.corebungeeapi.guild;

import org.bson.Document;

public final class GuildTag implements DocumentSerializable{
    private final String value;
    private final String color;


    public GuildTag(String value, String color) {
        if (value == null ) {
            throw new IllegalArgumentException("Guild tag value is null!");
        }
        this.value = value;
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
