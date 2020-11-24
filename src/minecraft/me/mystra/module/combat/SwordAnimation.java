package me.mystra.module.combat;

import java.util.ArrayList;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class SwordAnimation extends Module {
	public SwordAnimation() {
		super("SwordAnimation", 0, Category.MISC);

		ArrayList<String> options = new ArrayList<>();
		options.add("EXHIBITION");
		options.add("SLIDE");
		options.add("HIGH");
        options.add("OLD");
        Mystra.instance.settingsManager.rSetting(new Setting("Animation Mode", this, "EXHIBITION", options));
        
        Mystra.instance.settingsManager.rSetting(new Setting("Swing Speed", this, 6.0D, 2.0D, 12.0D, false));
        Mystra.instance.settingsManager.rSetting(new Setting("X", this, 0.0D, -1.0D, 1.0D, false));
        Mystra.instance.settingsManager.rSetting(new Setting("Y", this, 0.15D, -1.0D, 1.0D, false));
        Mystra.instance.settingsManager.rSetting(new Setting("Z", this, 0.0D, -1.0D, 1.0D, false));
	}
	
	public void onUpdate(EventUpdate event) {
		String mode = Mystra.instance.settingsManager.getSettingByName("Animation Mode").getValString();
		
		if(mode.equalsIgnoreCase("EXHIBITION")) {
			this.setDisplayName("SwordAnimation �7| EXHIBITION");
		}
		
		if(mode.equalsIgnoreCase("SLIDE")) {
			this.setDisplayName("SwordAnimation �7| SLIDE");
		}
		
		if(mode.equalsIgnoreCase("HIGH")) {
			this.setDisplayName("SwordAnimation �7| HIGH");
		}
		
		if(mode.equalsIgnoreCase("OLD")) {
			this.setDisplayName("SwordAnimation �7| OLD");
		}
	}
}
