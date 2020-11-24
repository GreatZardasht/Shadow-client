package me.mystra.module.movement;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.event.EventTarget;
import me.mystra.event.events.EventReceivePacket;
import me.mystra.module.Category;
import me.mystra.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;

public class Velocity extends Module{
	
    public Velocity() {
        super("Velocity", Keyboard.KEY_K, Category.MOVEMENT);
        
        ArrayList<String> options = new ArrayList<>();
        options.add("AAC");
        options.add("Hypixel");
        options.add("HypixelNew");
        
        Mystra.instance.settingsManager.rSetting(new Setting("Velocity Mode", this, "Hypixel", options));
    }
    
    @EventTarget
    public void onUpdate(EventReceivePacket event) {
    	String mode = Mystra.instance.settingsManager.getSettingByName("Velocity Mode").getValString();
    	
    	if(mode.equalsIgnoreCase("AAC")) {
    		if(mc.thePlayer.hurtTime > 0 & mc.thePlayer.hurtTime <= 7) {
    			mc.thePlayer.motionX *= 0.5;
    		    mc.thePlayer.motionZ *= 0.5;
    		}
    		
    		if(mc.thePlayer.hurtTime > 0 & mc.thePlayer.hurtTime < 6) {
    		    mc.thePlayer.motionX = 0.0;
    		    mc.thePlayer.motionZ = 0.0;
    		}
    	}
    	
    	if(mode.equalsIgnoreCase("HypixelNew")) {
    		Packet packet = event.getPacket();
    		if (packet instanceof S12PacketEntityVelocity || packet instanceof S27PacketExplosion) {
    			event.setCancelled(true);
        	}
    	}
    }
    
    public final void onReceivePacket(EventReceivePacket event) {
    	String mode = Mystra.instance.settingsManager.getSettingByName("Velocity Mode").getValString();
    	if(mode.equalsIgnoreCase("HypixelNew")) {
    		Packet packet = event.getPacket();
    		if (packet instanceof S12PacketEntityVelocity || packet instanceof S27PacketExplosion) {
    			event.setCancelled(true);
        	}
    	}
    }
    
    public void onEnable() {
        super.onEnable();
    }

    public void onDisable() {
        super.onDisable();
    }
}