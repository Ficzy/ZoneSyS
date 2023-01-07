package ZoneRunnable;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class CaptureBlue extends BukkitRunnable {


    public int captureblue;


    @Override
    public void run() {
        if (captureblue >= 99) {
            Bukkit.broadcastMessage("Les bleu on win");
            cancel();
        }

        else {
            captureblue++;
            String s = String.valueOf(captureblue);
            Bukkit.broadcastMessage(s);
        }
    }
}
