package me.mystra.module.combat;

import me.mystra.Mystra;
import me.mystra.clickgui.settings.Setting;
import me.mystra.event.EventTarget;
import me.mystra.event.events.EventUpdate;
import me.mystra.module.Category;
import me.mystra.module.Module;
import me.mystra.utils.TimeHelper;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class AutoArmor extends Module{
	TimeHelper timer = new TimeHelper();

	public AutoArmor() {
		super("AutoArmor", 0, Category.COMBAT);

		Mystra.instance.settingsManager.rSetting(new Setting("Armor Speed", this, 500, 0, 2000, true));
	}

	@EventTarget
	public void onUpdate(EventUpdate event) {
		if(this.isToggled()) {
		setDisplayName("AutoArmor �7" + Mystra.instance.settingsManager.getSettingByName("Armor Speed").getValDouble());
		if (!(mc.currentScreen instanceof GuiInventory) && mc.currentScreen != null)
            return;
          int[] bestArmorSlot = { -1, -1, -1, -1 };
          int[] bestArmorAmount = { -1, -1, -1, -1 };

          if (this.timer.isDelayComplete((float) (Mystra.instance.settingsManager.getSettingByName("Armor Speed").getValDouble()))) {
            for (int i = 0; i < 36; i++) {
              ItemStack itemstack = mc.thePlayer.inventory.getStackInSlot(i);
              if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                ItemArmor armor = (ItemArmor)itemstack.getItem();
                if (armor.damageReduceAmount > bestArmorAmount[armor.armorType]) {
                  bestArmorAmount[armor.armorType] = armor.damageReduceAmount;
                  bestArmorSlot[armor.armorType] = i;
                }
              }
            }

            for (int i = 0; i < 4; i++) {
              ItemArmor bestArmor, currentArmor; ItemStack itemstack = mc.thePlayer.inventory.armorItemInSlot(3 - i);

              if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                currentArmor = (ItemArmor)itemstack.getItem();
              } else {
                currentArmor = null;
              }

              try {
                bestArmor = (ItemArmor)mc.thePlayer.inventory.getStackInSlot(bestArmorSlot[i]).getItem();
              } catch (Exception e) {
                bestArmor = null;
              }

              if (bestArmor != null && (
                currentArmor == null || bestArmor.damageReduceAmount > currentArmor.damageReduceAmount)) {
                mc.playerController.windowClick(0, (bestArmorSlot[i] < 9) ? (36 + bestArmorSlot[i]) : bestArmorSlot[i],
                    0, 0, mc.thePlayer);
                mc.playerController.windowClick(0, 5 + i, 0,
                    0, mc.thePlayer);
                mc.playerController.windowClick(0, (bestArmorSlot[i] < 9) ? (36 + bestArmorSlot[i]) : bestArmorSlot[i],
                    0, 0, mc.thePlayer);
                this.timer.setLastMS();
                TimeHelper.reset();
                return;
              }
            }
          }
		}
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}

	@Override
	public void onEnable() {
		super.onEnable();
	}
}
