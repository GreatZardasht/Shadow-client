package me.mystra.clickgui.clickgui.util;

import java.awt.Color;

public class ColorUtil {
	/*public static Color getClickGUIColor(){
		return new Color((int) Mystra.instance.settingsManager.getSettingByName("GuiRed").getValDouble(), (int) Mystra.instance.settingsManager.getSettingByName("GuiGreen").getValDouble(), (int) Mystra.instance.settingsManager.getSettingByName("GuiBlue").getValDouble());
	}*/
	
	public static int rainbow(int delay) {
	      double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
	      rainbowState %= 360;
	      return Color.getHSBColor((float) (rainbowState / 360.0f), 0.8f, 0.7f).getRGB();
	}
}