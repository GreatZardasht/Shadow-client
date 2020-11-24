package me.mystra.module.misc;

import java.util.ArrayList;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;

public class Configs extends Module
{
    public Configs() {
        super("Configs", 0, Category.MISC);
    }
    
    @Override
    public void setup() {
        final ArrayList<String> options = new ArrayList<String>();
        options.add("Watchdog");
        Mystra.instance.settingsManager.rSetting(new Setting("Config", this, "Watchdog", options));
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate event) {
    	
        final String mode = Mystra.instance.settingsManager.getSettingByName("Config").getValString();
        
        if (mode.equalsIgnoreCase("Watchdog")) {
            for (final Module m : Mystra.instance.moduleManager.getModules()) {
                if (m.isToggled()) {
                    m.toggle();
                }
            }
            
            //AURA
            this.setting("Range").setValDouble(3.5);
            this.setting("Delay").setValDouble(12);
            this.setting("CircleESP Range").setValDouble(1.4);
            this.setting("AutoBlock").setValBoolean(true);
            this.setting("Animals").setValBoolean(false);
            this.setting("Monsters").setValBoolean(false);
            this.setting("Teams").setValBoolean(true);
            this.setting("TargetHUD").setValBoolean(true);
            
            //AUTOARMOR
            Mystra.instance.moduleManager.getModuleByName("AutoArmor").toggle();;
            this.setting("Armor Speed").setValDouble(5);
            
            //ANTIBOT
            this.setting("AntiBot Mode").setValString("Watchdog");
            Mystra.instance.moduleManager.getModuleByName("AntiBot").toggle();

            //SCAFFOLD
            this.setting("Tower").setValBoolean(false);
            this.setting("Silent").setValBoolean(false);
            
            //LONGJUMP
            this.setting("LongJump Mode").setValString("Hypixel");
            
            //DISABLER
            this.setting("Disabler Mode").setValString("Watchdog");
            
            //SPEED
            this.setting("Speed Mode").setValString("HypixelBHop");
            this.setting("Speed LagBack").setValBoolean(true);
            
            //VELOCITY
            Mystra.instance.moduleManager.getModuleByName("Velocity").toggle();
            this.setting("Velocity Mode").setValString("HypixelNew");
            
            //TARGETSTRAFE
            this.setting("CircleESP").setValBoolean(false);
            
            //INV MANAGER
            Mystra.instance.moduleManager.getModuleByName("InvManager").toggle();
            this.setting("Sword Slot").setValDouble(1);
            this.setting("InvManager Delay").setValDouble(100);
            
            //FLY
            this.setting("Fly Mode").setValString("Hypixel");
            this.setting("Timer Boost").setValBoolean(true);
            this.setting("Timer Speed").setValDouble(2.4);
            
            //INV MANAGER
            Mystra.instance.moduleManager.getModuleByName("Disabler").toggle();
            this.setting("Sword Slot").setValDouble(1);
            
            //CHESTSTEALER
            Mystra.instance.moduleManager.getModuleByName("ChestStealer").toggle();
            this.setting("CS Delay").setValDouble(100);
            
            //AMBIANCE
            Mystra.instance.moduleManager.getModuleByName("Ambiance").toggle();
            this.setting("Time").setValDouble(15000);
            
            //NOSCOREBOARD
            Mystra.instance.moduleManager.getModuleByName("NoScoreboard").toggle();
            this.setting("Position").setValDouble(200);
            
            //INVMOVE
            Mystra.instance.moduleManager.getModuleByName("InvMove").toggle();
            this.setting("Sneak").setValBoolean(false);
            
            //HUD
            Mystra.instance.moduleManager.getModuleByName("HUD").toggle();
            
            //MODULES WITHOUT VALUE
            Mystra.instance.moduleManager.getModuleByName("Fullbright").toggle();
            Mystra.instance.moduleManager.getModuleByName("NoSlowdown").toggle();
            Mystra.instance.moduleManager.getModuleByName("Sprint").toggle();
            Mystra.instance.moduleManager.getModuleByName("ESP2D").toggle();
            Mystra.instance.moduleManager.getModuleByName("SwordAnimation").toggle();
            Mystra.instance.moduleManager.getModuleByName("AutoRespawn").toggle();
            Mystra.instance.moduleManager.getModuleByName("Cosmetics").toggle();
            Mystra.instance.moduleManager.getModuleByName("FastPlace").toggle();
            Mystra.instance.moduleManager.getModuleByName("NameProtect").toggle();
            Mystra.instance.moduleManager.getModuleByName("NoWeb").toggle();
            Mystra.instance.moduleManager.getModuleByName("AutoSword").toggle();
            Mystra.instance.moduleManager.getModuleByName("AutoSoup").toggle();
            Mystra.instance.moduleManager.getModuleByName("ChestESP").toggle();
            Mystra.instance.moduleManager.getModuleByName("AimAssist").toggle();
            Mystra.instance.moduleManager.getModuleByName("Skeletons").toggle();
            Mystra.instance.moduleManager.getModuleByName("Reach").toggle();
            Mystra.instance.moduleManager.getModuleByName("AutoPlay").toggle();
            Mystra.instance.moduleManager.getModuleByName("AutoTool").toggle();
            Mystra.instance.moduleManager.getModuleByName("WallHack").toggle();
            Mystra.instance.moduleManager.getModuleByName("KillSults").toggle();
            Mystra.instance.moduleManager.getModuleByName("Detector").toggle();
            Mystra.instance.moduleManager.getModuleByName("Trajectories").toggle();
            Mystra.instance.moduleManager.getModuleByName("ItemPhysics").toggle();
            Mystra.instance.moduleManager.getModuleByName("NoHurtCam").toggle();
        }
    }
}