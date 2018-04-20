package me.tokyojack.bukkit.warpeffect.utils;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class Helix {

	// Asked one of my friends to do the trigonometry for this awhile back for me 
	public static void generate(Player player){
		double radius = 5;

		for (double y = 5; y >= 0; y -= 0.007) {
			radius = y / 3;
			double x = radius * Math.cos(3 * y);
			double z = radius * Math.sin(3 * y);

			double y2 = 5 - y;

			PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.FLAME,
					true, (float) player.getLocation().getX() + (float) x,
					(float) player.getLocation().getY() + (float) y2,
					(float) player.getLocation().getZ() + (float) z, 0, 0, 0, 0, 1);

			for (Player online : Bukkit.getOnlinePlayers()) {
				((CraftPlayer) online).getHandle().playerConnection.sendPacket(packet);
			}
		}

		for (double y = 5; y >= 0; y -= 0.007) {
			radius = y / 3;
			double x = -(radius * Math.cos(3 * y));
			double z = -(radius * Math.sin(3 * y));

			double y2 = 5 - y;


			PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
					EnumParticle.WATER_WAKE, true, (float) player.getLocation().getX() + (float) x,
					(float) player.getLocation().getY() + (float) y2,
					(float) player.getLocation().getZ() + (float) z, 0, 0, 0, 0, 1);
			for (Player online : Bukkit.getOnlinePlayers()) {
				((CraftPlayer) online).getHandle().playerConnection.sendPacket(packet);
			}
		}
	}
	
}
