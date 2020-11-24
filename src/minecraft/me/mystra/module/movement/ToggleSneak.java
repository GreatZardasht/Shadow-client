package me.mystra.module.movement;

import me.mystra.module.Category;
import me.mystra.module.Module;

public class ToggleSneak extends Module {
	public ToggleSneak() {
		super("ToggleSneak", 0, Category.MOVEMENT);
	}

    @Override
    public void onEnable(){
    	mc.gameSettings.keyBindSneak.pressed = true;
    	}
    @Override
    public void onDisable(){
    	mc.gameSettings.keyBindSneak.pressed = false;
    }
}
