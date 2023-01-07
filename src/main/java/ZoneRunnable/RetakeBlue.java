package ZoneRunnable;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import system.zone.Main;

public class RetakeBlue extends BukkitRunnable {
    public int retakeblue;
    public int bluecap;

    private Main main;

    public RetakeBlue(Main main){
        this.main = main;
    }


    @Override
    public void run() {
        if (retakeblue >= 75) {
            retakeblue = 75;
            Bukkit.broadcastMessage("caped");
            main.captureBlue = new CaptureBlue();
            main.captureBlue.captureblue = bluecap;
            main.captureBlue.runTaskTimer(main, 20L, 20L);
            cancel();
        } else {
            retakeblue += 25;
            String s = String.valueOf(retakeblue);
            Bukkit.broadcastMessage(s);
        }
    }
}
