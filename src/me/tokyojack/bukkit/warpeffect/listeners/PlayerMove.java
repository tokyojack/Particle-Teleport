package me.tokyojack.bukkit.warpeffect.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.tokyojack.bukkit.warpeffect.Core;
import me.tokyojack.bukkit.warpeffect.utils.KountdownPlayer;

public class PlayerMove implements Listener {

	@EventHandler
	public void warpMove(PlayerMoveEvent event) {
		
		// If the player moved from their initial block (As when a player rotates, it calls the event)
		if (event.getTo().getBlockX() == event.getFrom().getBlockX()
		 && event.getTo().getBlockY() == event.getFrom().getBlockY()
  		 && event.getTo().getBlockZ() == event.getFrom().getBlockZ())
			return;

		Player player = event.getPlayer();
		KountdownPlayer warpEffect = Core.getPlugin().getWarpEffect();

		if (!warpEffect.containsPlayer(player))
			return;

		warpEffect.stopPlayer(player);
	}

}
