package me.firas.corebungeeapi.guild;

import org.bson.Document;

import java.util.Objects;
import java.util.UUID;

public final class PlayerId implements DocumentSerializable {
    private final UUID value;
    private final String name;
    public PlayerId(UUID value, String name) { this.value = Objects.requireNonNull(value);
        this.name = name;
    }
    public static PlayerId of(UUID value,String name){ return new PlayerId(value,name );}
    public UUID value(){ return value; }
    public String name(){
        return name;
    }
    @Override public boolean equals(Object o){ return o instanceof PlayerId && ((PlayerId)o).value.equals(value);}    
    @Override public int hashCode(){ return value.hashCode(); }
    @Override public String toString(){ return value.toString(); }

    @Override
    public Document toDocument() {
        return new Document("uuid", value.toString()).append("name",name);
    }
}
