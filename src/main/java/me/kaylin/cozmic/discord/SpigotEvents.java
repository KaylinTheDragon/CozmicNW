package me.kaylin.cozmic.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public final class SpigotEvents implements Listener {
    Events object = new Events();
    @EventHandler
    private void onChat(AsyncPlayerChatEvent event) { sendMessage(event.getPlayer(), event.getMessage(), false, Color.GRAY); }
    @EventHandler
    private void onJoin(PlayerJoinEvent event) {sendMessage(event.getPlayer(), event.getPlayer().getDisplayName() + " joined.", true, Color.GREEN);}
    @EventHandler
    private void onQuit(PlayerJoinEvent event) {sendMessage(event.getPlayer(), event.getPlayer().getDisplayName() + " left.", true, Color.RED);}

    private void sendMessage(Player player, String content, boolean contentInAuthLine, Color color) {
        //Checking if chat channel is empty before running
        if (object.chatChannel == null) return;

        EmbedBuilder builder = new EmbedBuilder()
                .setAuthor(
                        contentInAuthLine ? content : player.getDisplayName(), null, "https://crafatar.com/avatars/" + player.getUniqueId().toString() + "?overlay=1");
        if (!contentInAuthLine) {
            builder.setDescription(content);
        }
        object.chatChannel.sendMessageEmbeds(builder.build()).queue();
        //I forgot whats going on here
    }

}