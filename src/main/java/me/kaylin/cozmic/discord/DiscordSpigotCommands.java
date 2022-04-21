package me.kaylin.cozmic.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.util.concurrent.TimeUnit;

public class DiscordSpigotCommands extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        Member member = event.getMessage().getMember();
        String[] args = event.getMessage().getContentRaw().split("\\s+");


        if (args[0].equalsIgnoreCase("~c")) {
            if (!member.hasPermission(event.getGuildChannel(), Permission.MESSAGE_MANAGE)) { //checking if players has permission to actually run the command
                EmbedBuilder failperm = new EmbedBuilder();
                failperm.setTitle("🔴 Invalid permission");
                failperm.setDescription("Staff use only");
                failperm.setFooter("~c");

                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessageEmbeds(failperm.build()).queue((m -> m.delete().queueAfter(3, TimeUnit.SECONDS)));
                event.getMessage().delete().queueAfter(3, TimeUnit.SECONDS);
                failperm.clear();
                return;
            }

            if (args.length < 2) {
                // error
                EmbedBuilder fail = new EmbedBuilder();
                fail.setTitle("🔴 Missing second argument");
                fail.setDescription("Usage: `~c [command]`");
                fail.setFooter("~c");

                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessageEmbeds(fail.build()).queue((m -> m.delete().queueAfter(3, TimeUnit.SECONDS)));
                event.getMessage().delete().queueAfter(3, TimeUnit.SECONDS);
                fail.clear();

            } else {

                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                String command = args[1];
                Bukkit.dispatchCommand(console, command);

                EmbedBuilder Success = new EmbedBuilder();
                Success.setTitle("✅ Sent " + command);
                Success.setFooter("~c");

                event.getChannel().sendMessageEmbeds(Success.build()).queue((m -> m.delete().queueAfter(3, TimeUnit.SECONDS)));
                event.getMessage().delete().queueAfter(3, TimeUnit.SECONDS);
                Success.clear();


            }

        }
    }
}