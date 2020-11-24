package me.mystra.management.command.commands;

import me.mystra.Mystra;
import me.mystra.management.command.Command;

public class Settings extends Command {

	public Settings(String[] names, String description) {
		super(names, description);
	}

	@Override
	public String getAlias() {
		return "settings";
	}

	@Override
	public String getDescription() {
		return "Auto setting modules.";
	}

	@Override
	public String getSyntax() {
		return ".settings [Setting] | .settings list";
	}

	@Override
	public String executeCommand(String line, String[] args) {
		if(args[0].equalsIgnoreCase("")) {
			Mystra.addChatMessage(getSyntax());
			
		} else if(args[0].equalsIgnoreCase("list")) {
			Mystra.addChatMessage("Setting List: Hypixel, TheHive, Mooncraft, Redesky");
			
		} else if(args[0].equalsIgnoreCase("Mooncraft")) {
			
			//DISABLE ALL MODULES BEFORE ENABLE
			Mystra.instance.moduleManager.getModules();
			
			
			//COMBAT
			Mystra.instance.moduleManager.getModuleByName("AutoArmor").toggle();
			Mystra.instance.moduleManager.getModuleByName("AutoSword").toggle();
			Mystra.instance.moduleManager.getModuleByName("AimAssist").toggle();
			Mystra.instance.moduleManager.getModuleByName("AutoSoup").toggle();
			Mystra.instance.moduleManager.getModuleByName("AntiBot").toggle();
			Mystra.instance.moduleManager.getModuleByName("Reach").toggle();
			//RENDER
			Mystra.instance.moduleManager.getModuleByName("Fullbright").toggle();
			Mystra.instance.moduleManager.getModuleByName("AntiFire").toggle();
			Mystra.instance.moduleManager.getModuleByName("Tracers").toggle();
			Mystra.instance.moduleManager.getModuleByName("Chams").toggle();
			Mystra.instance.moduleManager.getModuleByName("ESP").toggle();
			//PLAYER
			Mystra.instance.moduleManager.getModuleByName("ChestStealer").toggle();
			Mystra.instance.moduleManager.getModuleByName("AutoRespawn").toggle();
			Mystra.instance.moduleManager.getModuleByName("FastPlace").toggle();
			//MOVEMENT
			Mystra.instance.moduleManager.getModuleByName("Velocity").toggle();
			Mystra.instance.moduleManager.getModuleByName("InvMove").toggle();
			Mystra.instance.moduleManager.getModuleByName("Sprint").toggle();
			//MISC
			Mystra.instance.moduleManager.getModuleByName("SwordAnimation").toggle();
			Mystra.instance.moduleManager.getModuleByName("Cosmetics").toggle();
			Mystra.instance.moduleManager.getModuleByName("HUD").toggle();
			
			//VALUES
		}
		return line;
	}

}
