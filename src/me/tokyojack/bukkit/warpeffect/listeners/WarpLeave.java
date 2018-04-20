package me.tokyojack.bukkit.warpeffect.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.tokyojack.bukkit.warpeffect.Core;
import me.tokyojack.bukkit.warpeffect.utils.KountdownPlayer;

public class WarpLeave implements Listener {

	@EventHandler
	public void warpQuit(PlayerQuitEvent event) {
		stopPlayerWarp(event.getPlayer());
	}
	
	@EventHandler
	public void warpKick(PlayerKickEvent event) {
		stopPlayerWarp(event.getPlayer());
	}
	
	private void stopPlayerWarp(Player player){
		KountdownPlayer warpEffect = Core.getPlugin().getWarpEffect();

		if (!warpEffect.containsPlayer(player))
			return;

		warpEffect.stopPlayer(player);
	}
	
}
