package me.mystra.module.combat;

import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.item.ItemAppleGold;

public class AutoGapple extends Module {

	public AutoGapple() {
		super("AutoGapple", 0, Category.COMBAT);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (mc.thePlayer.getHeldItem().getItem() instanceof ItemAppleGold) {
            if(mc.thePlayer.getHealth() <= 9) {
                mc.gameSettings.keyBindUseItem.pressed = true;
            }else{
                mc.gameSettings.keyBindUseItem.pressed = false;
            }
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
