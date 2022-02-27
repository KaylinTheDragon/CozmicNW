package me.kaylin.cozmic.discord;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public final class DiscordEvents extends ListenerAdapter {
    Events object = new Events();
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        //Forgot to do theses.. This will check if it is recieving the event from the right channel
        if (!event.getChannel().equals(object.chatChannel)) return;

        Member member = event.getMember();
        //Checking if its a actual user sending the message
        if (member == null || member.getUser().isBot()) return;

        String message = event.getMessage().getContentDisplay();
        // And finally sending the message
        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "Discord" + ChatColor.GRAY + "] " + ChatColor.WHITE + member.getEffectiveName() + ":" + ChatColor.RESET + " " + message);
    }
}