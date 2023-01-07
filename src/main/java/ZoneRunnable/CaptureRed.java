package ZoneRunnable;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class CaptureRed extends BukkitRunnable {

    public int capturered;

    @Override
    public void run() {
        if (capturered >= 99) {
            Bukkit.broadcastMessage("Les rouge on win");
            cancel();
        }

        else {
            capturered++;
            String s = String.valueOf(capturered);
            Bukkit.broadcastMessage(s);
        }
    }
}