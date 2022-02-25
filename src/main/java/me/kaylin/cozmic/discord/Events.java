package me.kaylin.cozmic.discord;

import me.kaylin.cozmic.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class Events implements Listener {
    public TextChannel chatChannel;
    public static JDA jda;

    private Main plugin;
    public void Main(Main plugin){ this.plugin = plugin; }

    public void Chat() {
        // Load channel that chat is in
        String chatChannelId = plugin.getConfig().getString("chat-channel-id");
        //If chat channelId isn't null it will load it
        if (chatChannelId != null) { chatChannel = jda.getTextChannelById(chatChannelId); }
    }
}
