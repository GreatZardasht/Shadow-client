package me.mystra.clickgui.clickgui.elements.menu;

import java.awt.Color;

import me.mystra.Mystra;
import me.mystra.clickgui.clickgui.elements.Element;
import me.mystra.clickgui.clickgui.elements.ModuleButton;
import me.mystra.clickgui.clickgui.util.FontUtil;
import me.mystra.clickgui.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class ElementComboBox extends Element {
	/*
	 * Konstrukor
	 */
	public ElementComboBox(ModuleButton iparent, Setting iset) {
		parent = iparent;
		set = iset;
		super.setup();
	}

	/*
	 * Rendern des Elements
	 */
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		//Color temp = ColorUtil.getClickGUIColor();
		//int color = new Color(temp.getRed(), temp.getGreen(), temp.getBlue(), 150).getRGB();

		/*
		 * Die Box und Umrandung rendern
		 */
		Gui.drawRect(x, y, x + width, y + height, 0xff121212);

		FontUtil.drawTotalCenteredString(setstrg, x + width / 2, y + 15/2, 0xffffffff);
		//int clr1 = color;
		//int clr2 = temp.getRGB();

		Gui.drawRect(x, y + 14, x + width, y + 15, 0x77000000);
		if (comboextended) {
			Gui.drawRect(x, y + 15, x + width, y + height, 0xaa121212);
			double ay = y + 15;
			for (String sld : set.getOptions()) {
				String elementtitle = sld.substring(0, 1).toUpperCase() + sld.substring(1, sld.length());
				FontUtil.drawCenteredString(elementtitle, x + width / 2, ay + 2, 0xffffffff);

				/*
				 * Ist das Element ausgewhlt, wenn ja dann markiere
				 * das Element in der ComboBox
				 */
				String themecombobox = Mystra.instance.settingsManager.getSettingByName("Theme").getValString();
				if (sld.equalsIgnoreCase(set.getValString())) {
					if(themecombobox.equalsIgnoreCase("Mystra")) {
						//Gui.drawRect(x, ay, x + 1.5, ay + FontUtil.getFontHeight() + 2, rainbow(0));
						Gui.drawRect(x, ay, x + 1.5, ay + FontUtil.getFontHeight() + 2, 0xff810081);
					}
					if(themecombobox.equalsIgnoreCase("Cheese")) {
						Gui.drawRect(x, ay, x + 1.5, ay + FontUtil.getFontHeight() + 2, 0xFFFFFF00);
					}
				}
				/*
				 * Wie bei mouseClicked 'is hovered', wenn ja dann markiere
				 * das Element in der ComboBox
				 */
				if (mouseX >= x && mouseX <= x + width && mouseY >= ay && mouseY < ay + FontUtil.getFontHeight() + 2) {
					if(themecombobox.equalsIgnoreCase("Mystra")) {
						//Gui.drawRect(x + width - 1.2, ay, x + width, ay + FontUtil.getFontHeight() + 2, rainbow(0));
						Gui.drawRect(x + width - 1.2, ay, x + width, ay + FontUtil.getFontHeight() + 2, 0xff810081);
					}
					if(themecombobox.equalsIgnoreCase("Cheese")) {
						Gui.drawRect(x + width - 1.2, ay, x + width, ay + FontUtil.getFontHeight() + 2, 0xFFFFFF00);
					}
				}
				ay += FontUtil.getFontHeight() + 2;
			}
		}
	}

	/*
	 * 'true' oder 'false' bedeutet hat der Nutzer damit interagiert und
	 * sollen alle anderen Versuche der Interaktion abgebrochen werden?
	 */
	public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if (mouseButton == 0) {
			if (isButtonHovered(mouseX, mouseY)) {
				comboextended = !comboextended;
				return true;
			}

			/*
			 * Also wenn die Box ausgefahren ist, dann wird fr jede mgliche Options
			 * berprft, ob die Maus auf diese zeigt, wenn ja dann global jeder weitere
			 * call an mouseClicked gestoppt und die Values werden aktualisiert
			 */
			if (!comboextended)return false;
			double ay = y + 15;
			for (String slcd : set.getOptions()) {
				if (mouseX >= x && mouseX <= x + width && mouseY >= ay && mouseY <= ay + FontUtil.getFontHeight() + 2) {
					if(Mystra.instance.settingsManager.getSettingByName("Sound").getValBoolean())
					Minecraft.getMinecraft().thePlayer.playSound("tile.piston.in", 20.0F, 20.0F);

					if(clickgui != null && clickgui.setmgr != null)
					clickgui.setmgr.getSettingByName(set.getName()).setValString(slcd.toLowerCase());
					return true;
				}
				ay += FontUtil.getFontHeight() + 2;
			}
		}

		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	/*
	 * Einfacher HoverCheck, bentigt damit die Combobox geffnet und geschlossen werden kann
	 */
	public boolean isButtonHovered(int mouseX, int mouseY) {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + 15;
	}
	
	public static int rainbow(int delay) {
	      double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
	      rainbowState %= 360;
	      return Color.getHSBColor((float) (rainbowState / 360.0f), 0.8f, 0.7f).getRGB();
	}
}
