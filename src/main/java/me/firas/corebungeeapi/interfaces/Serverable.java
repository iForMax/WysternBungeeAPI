package me.firas.corebungeeapi.interfaces;


import net.md_5.bungee.api.connection.ProxiedPlayer;

public interface Serverable {
    void sendPlayerToServer(ProxiedPlayer player, String serverName);

}
