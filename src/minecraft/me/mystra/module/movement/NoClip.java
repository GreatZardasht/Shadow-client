package me.mystra.module.movement;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.client.Minecraft;

public class NoClip extends Module {
	public NoClip() {
		super("NoClip", 0, Category.MOVEMENT);

		Mystra.instance.settingsManager.rSetting(new Setting("ClipSpeed", this, 1, 0, 5, false));
	}

	@EventTarget
	private void onUpdate(EventUpdate e) {
			Minecraft.getMinecraft().thePlayer.noClip = true;
			Minecraft.getMinecraft().thePlayer.fallDistance = 0.0F;
			Minecraft.getMinecraft().thePlayer.onGround = false;

			Minecraft.getMinecraft().thePlayer.capabilities.isFlying = false;
			Minecraft.getMinecraft().thePlayer.motionX = 0.0F;
			Minecraft.getMinecraft().thePlayer.motionY = 0.0F;
			Minecraft.getMinecraft().thePlayer.motionZ = 0.0F;

			float speed = (float) Mystra.instance.settingsManager.getSettingByName("ClipSpeed").getValDouble();

			Minecraft.getMinecraft().thePlayer.jumpMovementFactor = speed;
			if(Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()) {
				Minecraft.getMinecraft().thePlayer.motionY += speed;
			if(Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed()) {
				Minecraft.getMinecraft().thePlayer.motionY -= speed;
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
