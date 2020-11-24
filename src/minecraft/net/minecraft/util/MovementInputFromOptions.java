package net.minecraft.util;

import org.lwjgl.input.Keyboard;

import me.mystra.Mystra;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class MovementInputFromOptions
extends MovementInput
{
private final GameSettings gameSettings;

public MovementInputFromOptions(GameSettings gameSettingsIn) { this.gameSettings = gameSettingsIn; }



public void updatePlayerMoveState() {
  if (Mystra.instance.moduleManager.getModuleByName("InvMove").isToggled() && !((Minecraft.getMinecraft()).currentScreen instanceof net.minecraft.client.gui.GuiChat)) { // Shadow InvMove
    
    this.moveStrafe = 0.0F;
    this.moveForward = 0.0F;
    
    if (Keyboard.isKeyDown(this.gameSettings.keyBindForward.getKeyCode())) {
      this.moveForward++;
    }
    if (Keyboard.isKeyDown(this.gameSettings.keyBindBack.getKeyCode())) {
      this.moveForward--;
    }
    if (Keyboard.isKeyDown(this.gameSettings.keyBindLeft.getKeyCode())) {
      this.moveStrafe++;
    }
    if (Keyboard.isKeyDown(this.gameSettings.keyBindRight.getKeyCode())) {
      this.moveStrafe--;
    }
    if (Mystra.instance.settingsManager.getSettingByName("Jump").getValBoolean()) {
  	  this.jump = Keyboard.isKeyDown(this.gameSettings.keyBindJump.getKeyCode());
    } else {
  	  this.jump = this.gameSettings.keyBindJump.isKeyDown();
    }
    if (Mystra.instance.settingsManager.getSettingByName("Sneak").getValBoolean()) {
  	  this.sneak = Keyboard.isKeyDown(this.gameSettings.keyBindSneak.getKeyCode());
    } else {
  	  this.sneak = this.gameSettings.keyBindSneak.isKeyDown();
    }
    if (this.sneak) {
      this.moveStrafe = (float)(this.moveStrafe * 0.3D);
      this.moveForward = (float)(this.moveForward * 0.3D);
    } 
  } else {
    this.moveStrafe = (float)(this.moveStrafe * 0.0D);
    this.moveForward = (float)(this.moveForward * 0.0D);
    
    if (this.gameSettings.keyBindForward.isKeyDown())
    {
      this.moveForward++;
    }
    
    if (this.gameSettings.keyBindBack.isKeyDown())
    {
      this.moveForward--;
    }
    
    if (this.gameSettings.keyBindLeft.isKeyDown())
    {
      this.moveStrafe++;
    }
    
    if (this.gameSettings.keyBindRight.isKeyDown())
    {
      this.moveStrafe--;
    }
    
    this.jump = this.gameSettings.keyBindJump.isKeyDown();
    this.sneak = this.gameSettings.keyBindSneak.isKeyDown();
    
    if (this.sneak) {
      
      this.moveStrafe = (float)(this.moveStrafe * 0.3D);
      this.moveForward = (float)(this.moveForward * 0.3D);
    } 
  } 
}
}