package me.mystra.management.command.commands;

import me.mystra.Mystra;
import me.mystra.management.command.Command;
import net.minecraft.client.Minecraft;

public class Ping extends Command {
	
	public Ping(String[] names, String description) {
		super(names, description);
	}

	@Override
	public String getAlias() {
		return "ping";
	}

	@Override
	public String getDescription() {
		return "Shows your ping.";
	}

	@Override
	public String getSyntax() {
		return ".ping";
	}

	@Override
	public String executeCommand(String line, String[] args) {
		if(args[0].equalsIgnoreCase("")) {
			Mystra.addChatMessage("Your ping is �c" + Minecraft.getMinecraft().getCurrentServerData().pingToServer + "ms�f.");
		}
		return line;
	}
}
