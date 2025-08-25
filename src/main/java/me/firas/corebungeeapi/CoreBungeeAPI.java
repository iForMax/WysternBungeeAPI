package me.firas.corebungeeapi;

import lombok.Getter;
import lombok.Setter;
import me.firas.corebungeeapi.guild.GuildService;
import me.firas.corebungeeapi.interfaces.Serverable;
import net.md_5.bungee.api.plugin.Plugin;
@Setter
public final class CoreBungeeAPI extends Plugin {

    @Getter
    private static CoreBungeeAPI instance;

    @Getter
    private Serverable serverable;

    @Getter
    private GuildService guildService;
    @Override
    public void onEnable() {
        instance = this;
        System.out.println("Core Bungee API successfully enabled!");
    }

}
