package me.kaylin.cozmic.utils;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.Color;

public class DiscordMessages {
    public static JDA jda;
    static WebhookClient client;
    public static void discordEmbeddedMessage(String author, String content, String footer, String iconurl, String url, Color color, String discordChannel) {
        TextChannel chatChannel2;
        chatChannel2 = jda.getTextChannelById(discordChannel);
        if (chatChannel2 == null) return;
        EmbedBuilder builder = new EmbedBuilder()
                .setAuthor(author, url, iconurl)
                .setDescription(content)
                .setFooter(footer);
        chatChannel2.sendMessageEmbeds(builder.build()).queue();
    }
    public static void discordNonEmbeddedMessage(String content, String discordChannel) {
        TextChannel chatChannel2;
        chatChannel2 = jda.getTextChannelById(discordChannel);
        if (chatChannel2 == null) return;
        chatChannel2.sendMessage(content).queue();

    }
    public static void discordWebhook(String username, String content, String avatarurl, String webhookurl) {
        WebhookClientBuilder builder = new WebhookClientBuilder(webhookurl); // or id, token
        builder.setThreadFactory((job) -> {
            Thread thread = new Thread(job);
            thread.setName("Webhook-Thread");
            thread.setDaemon(true);
            return thread;
        });
        builder.setWait(true);
        client = builder.build();
        WebhookMessageBuilder builder2 = new WebhookMessageBuilder();
        builder2.setUsername(username);
        builder2.setAvatarUrl(avatarurl); // use this avatar
        builder2.setContent(content);
        client.send(builder2.build());
    }
}
