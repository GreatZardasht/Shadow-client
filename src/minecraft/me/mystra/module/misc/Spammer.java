package me.mystra.module.misc;

import java.util.Random;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import me.mystra.utils.TimeHelper;

public class Spammer extends Module {

	TimeHelper delay = new TimeHelper();
	
	public Spammer() {
		super("Spammer", 0, Category.MISC);
		
		Mystra.instance.settingsManager.rSetting(new Setting("Delay", this, 50, 0, 1000, false));
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		Random r = new Random();
	    if(this.delay.isDelayComplete((float) ((Mystra.instance.settingsManager.getSettingByName("Delay").getValDouble()) * 1000L))) {
	    	this.mc.thePlayer.sendChatMessage("Mystra B1 | Made by Crystal [" + r.nextInt(346262) + "]");
	    	this.delay.reset();
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