package me.mystra.module.render;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class Ambiance extends Module {

	public Ambiance() {
		super("Ambiance", 0, Category.RENDER);
		
		Mystra.instance.settingsManager.rSetting(new Setting("Time", this, 16000.0D, 1.0D, 24000.0D, false));
	}

}