package ZoneRunnable;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import system.zone.Main;


public class RetakeRed extends BukkitRunnable {

    public int retakered;

    public int redcap;
    private Main main;

    public RetakeRed(Main main){
        this.main = main;
    }


    @Override
    public void run() {
        if (retakered >= 75) {
            Bukkit.broadcastMessage("caped");
            retakered = 75;
            main.captureRed = new CaptureRed();
            main.captureRed.capturered = redcap;
            main.captureRed.runTaskTimer(main,20L,20L);
            cancel();
        } else {
            retakered += 25;
            String s = String.valueOf(retakered);
            Bukkit.broadcastMessage(s);
        }
    }
}