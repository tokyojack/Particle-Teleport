package me.tokyojack.bukkit.warpeffect;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.tokyojack.bukkit.warpeffect.listeners.PlayerMove;
import me.tokyojack.bukkit.warpeffect.listeners.WarpCommandEvent;
import me.tokyojack.bukkit.warpeffect.listeners.WarpLeave;
import me.tokyojack.bukkit.warpeffect.utils.Helix;
import me.tokyojack.bukkit.warpeffect.utils.KountdownPlayer;

public class Core extends JavaPlugin {

	private static Core plugin;

	public static Core getPlugin() {
		return plugin;
	}

	private KountdownPlayer warpEffect = new KountdownPlayer(Core.getPlugin()) {

		@Override
		public void start(Player player) {
		}

		@Override
		public void tick(Player player, int countdown) {
			Helix.generate(player);
		}

		@Override
		public void stop(Player player) {

		}

		@Override
		public void finish(Player player) {

		}

	};
	
	public KountdownPlayer getWarpEffect(){
		return this.warpEffect;
	}

	public void onEnable() {
		plugin = this;
		
		PluginManager pluginManager = getServer().getPluginManager();
		pluginManager.registerEvents(new PlayerMove(), this);
		pluginManager.registerEvents(new WarpCommandEvent(), this);
		pluginManager.registerEvents(new WarpLeave(), this);
	}

}