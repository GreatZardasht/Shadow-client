package me.mystra.module.misc;


import java.util.Random;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventReceivePacket;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.network.play.server.S02PacketChat;

public class KillSults extends Module {

	public KillSults() {
		super("KillSults", 0, Category.MISC);
	}

	private String[] messages;
	
	
	public void onUpdate() {
		messages = new String[] {
				"%s should add me on discord (Crystal#8652) and get Mystra :^)",
				"%s doesn't like mystra :(",
				"%s you should go buy mystra at mystraclient dot store",
				"%s mystra is def the best client so far"
		};
	}

	@Override
	public void onEnable() {
		super.onEnable();
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}

	@EventTarget
	public void onReceivePacket(EventReceivePacket event) {
			if (mc.thePlayer == null) return;
			if (event.getPacket() instanceof S02PacketChat) {
				final S02PacketChat packet = ((S02PacketChat) event.getPacket());
				final String text = packet.getChatComponent().getUnformattedText();
				
				if (text.contains("by ".concat(mc.thePlayer.getName())) || text.contains("von ".concat(mc.thePlayer.getName()))) {
					String[] pre = new String[]{"buy mystra client at mystra client dot store", "so bad lmao better buy mystra at mystraclient dot store", "mystra client dot store for cheap client :D", "buy mystra client now at mystraclient.store"};
					Random rand = new Random();
					int i = rand.nextInt(pre.length - 1);
					String message = pre[i].concat(" ");
					mc.thePlayer.sendChatMessage(message);
			}
		}
	}

}