package me.tokyojack.bukkit.warpeffect.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.tokyojack.bukkit.warpeffect.Core;
import me.tokyojack.bukkit.warpeffect.utils.Helix;

public class WarpCommandEvent implements Listener{

	@EventHandler
	public void warpCommand(PlayerCommandPreprocessEvent event) {
		if (!event.getMessage().contains("/warp "))
			return;
		
		Player player = event.getPlayer();

		// Generates it instantly as OP players have no teleporting delay
		if (player.isOp()) {
			Helix.generate(player);
			return;
		}

		player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 9 * 20, 4));
		Core.getPlugin().getWarpEffect().startPlayer(player, 5);
	}
}
