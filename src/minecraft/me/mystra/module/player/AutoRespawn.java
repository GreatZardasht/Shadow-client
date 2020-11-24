package me.mystra.module.player;

import me.mystra.event.EventTarget;
import me.mystra.event.events.ClientTickEvent;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class AutoRespawn extends Module {
	public AutoRespawn() {
		super("AutoRespawn", 0, Category.PLAYER);
	}
	@EventTarget
	public void onTick(ClientTickEvent event) {
		if(mc.thePlayer == null) {
			return;
		}
        if (mc.thePlayer.isDead) {
        	mc.thePlayer.respawnPlayer();
        }
    }

	@Override
	public void onEnable() {
		super.onEnable();
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}
}