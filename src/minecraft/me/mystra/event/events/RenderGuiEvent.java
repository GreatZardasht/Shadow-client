package me.mystra.event.events;

import me.mystra.event.Event;
import net.minecraft.client.gui.ScaledResolution;

public final class RenderGuiEvent extends Event {
	
	   private final ScaledResolution scaledResolution;
	   private final float partialTicks;

	   public RenderGuiEvent(ScaledResolution scaledResolution, float partialTicks) {
	      this.scaledResolution = scaledResolution;
	      this.partialTicks = partialTicks;
	   }

	   public ScaledResolution getScaledResolution() {
	      return this.scaledResolution;
	   }

	   public float getPartialTicks() {
	      return this.partialTicks;
	   }
	}
