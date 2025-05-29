package me.firas.corebungeeapi;

import lombok.Getter;
import me.firas.corebungeeapi.interfaces.Serverable;
import net.md_5.bungee.api.plugin.Plugin;

public final class CoreBungeeAPI extends Plugin {

    @Getter
    private static CoreBungeeAPI instance;

    @Getter
    private Serverable serverable;
    @Override
    public void onEnable() {
        instance = this;
        System.out.println("Core Bungee API successfully enabled!");
    }

    @Override
    public void onDisable() {

    }
}
