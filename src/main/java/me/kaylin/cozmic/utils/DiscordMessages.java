package me.kaylin.cozmic.utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.Color;

public class DiscordMessages {
    public static JDA jda;
    public void discordEmbeddedMessage(String author, String content, String footer, String iconurl, String url, Color color, String discordChannel) {
        TextChannel chatChannel2;
        chatChannel2 = jda.getTextChannelById(discordChannel);
        if (chatChannel2 == null) return;
        EmbedBuilder builder = new EmbedBuilder()
                .setAuthor(author, url, iconurl)
                .setDescription(content)
                .setFooter(footer);
        chatChannel2.sendMessageEmbeds(builder.build()).queue();
    }
    public void discordNonEmbeddedMessage(String content, String discordChannel) {
        TextChannel chatChannel2;
        chatChannel2 = jda.getTextChannelById(discordChannel);
        if (chatChannel2 == null) return;
        chatChannel2.sendMessage(content).queue();

    }
}
