package me.kaylin.cozmic.discord;

import me.kaylin.cozmic.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.event.Listener;

public class Events implements Listener {
    public String webhook;
    public TextChannel chatChannel;
    public static JDA jda;

    private Main plugin;
    public void Main(Main plugin){ this.plugin = plugin; }

    public void Chat() {
        // Load channel that chat is in
        String chatChannelId = plugin.getConfig().getString("chat-channel-id");
        String webHookUrl = plugin.getConfig().getString("web-hook-url");
        //If chat channelId isn't null it will load it
        if (chatChannelId != null) { chatChannel = jda.getTextChannelById(chatChannelId); }
        if (webHookUrl != null) { webhook = webHookUrl; }
    }
}
