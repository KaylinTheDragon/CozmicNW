package me.kaylin.cozmic.discord;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public final class SpigotEvents implements Listener {
    JDA jda;
    WebhookClient client;
    Events object = new Events();
    @EventHandler
    private void onChat(AsyncPlayerChatEvent event) { sendMessage(event.getPlayer(), event.getMessage()); }
    @EventHandler
    private void onJoin(PlayerJoinEvent event) {sendMessage(event.getPlayer(), event.getPlayer().getDisplayName() + " joined.");}
    @EventHandler
    private void onQuit(PlayerJoinEvent event) {sendMessage(event.getPlayer(), event.getPlayer().getDisplayName() + " left.");}

    public void Webhookclient(Player player, String content) {
        WebhookClientBuilder builder = new WebhookClientBuilder(object.webhook); // or id, token
        builder.setThreadFactory((job) -> {
            Thread thread = new Thread(job);
            thread.setName("Webhook-Thread");
            thread.setDaemon(true);
            return thread;
        });
        builder.setWait(true);
        client = builder.build();

    }
    private void sendMessage(Player player, String content) {
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername(player.getDisplayName().toString()); // use this username
        builder.setAvatarUrl("https://crafatar.com/avatars/" + player.getUniqueId().toString() + "?overlay=1"); // use this avatar
        builder.setContent(content);
        client.send(builder.build());
    }

}