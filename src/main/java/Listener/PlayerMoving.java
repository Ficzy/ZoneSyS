package Listener;

import org.bukkit.event.Listener;
import system.zone.Main;
import ZoneRunnable.RetakeBlue;
import ZoneRunnable.RetakeRed;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class PlayerMoving implements Listener {

    private Main main;
    public PlayerMoving(Main main) {
        this.main = main;
    }


    private int retakeblue = 0;
    private int retakered = 0;
    private int captureblue = 0;
    private int capturered = 0;

    private RetakeBlue blueRetakeRunnable;
    private RetakeRed redRetakeRunnable;

    public ArrayList<Player> alreadyInZoneBlue = new ArrayList<>();
    public ArrayList<Player> alreadyInZoneRed = new ArrayList<>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (main.cuboid.isIn(p)) {
            if (main.teams.isBlue(p)) {
                if(!alreadyInZoneBlue.contains(p)){
                    alreadyInZoneBlue.add(p);
                }
                if (blueRetakeRunnable == null) {
                    //Substract value for Red RETAKE
                    retakered = 0;
                    //RUNNABLE
                    blueRetakeRunnable = new RetakeBlue(main);
                    //Value CAP
                    blueRetakeRunnable.bluecap = captureblue;
                    //Start Runnable
                    blueRetakeRunnable.retakeblue = retakeblue;
                    blueRetakeRunnable.runTaskTimer(main, 20L, 20L);
                }
                else {
                    return;
                }
            }
            if(main.teams.isRed(p)){
                if(!alreadyInZoneRed.contains(p)){
                    alreadyInZoneRed.add(p);
                }

                if(redRetakeRunnable == null){
                    //RUNNABLE
                    redRetakeRunnable = new RetakeRed(main);
                    //Value CAP
                    redRetakeRunnable.redcap = capturered;
                    //Start Runnable
                    redRetakeRunnable.retakered = retakered;
                    redRetakeRunnable.runTaskTimer(main, 20L, 20L);
                }
            }
            // CONTEST

            if (!alreadyInZoneRed.isEmpty() && !alreadyInZoneBlue.isEmpty()) {
                if (blueRetakeRunnable != null) {
                    blueRetakeRunnable.cancel();
                }
                if (main.captureBlue != null) {
                    main.captureBlue.cancel();
                }
                if (redRetakeRunnable != null) {
                    redRetakeRunnable.cancel();
                }
                if (main.captureRed != null) {
                    main.captureRed.cancel();
                }
                else {
                    return;
                }
            }
        }
        //IS NOT IN THE ZONE
        if(!main.cuboid.isIn(p)){
            if(main.teams.isBlue(p)){

                if (alreadyInZoneBlue.contains(p)) {
                    alreadyInZoneBlue.remove(p);
                }
                if(alreadyInZoneBlue.isEmpty()){
                    if (blueRetakeRunnable != null) {
                        blueRetakeRunnable.cancel();
                        retakeblue = blueRetakeRunnable.retakeblue;
                    }
                    if (main.captureBlue != null) {
                        main.captureBlue.cancel();
                        captureblue = main.captureBlue.captureblue;
                    }
                }else if (alreadyInZoneBlue.isEmpty() && !alreadyInZoneRed.isEmpty() && redRetakeRunnable == null){
                    //RUNNABLE
                    redRetakeRunnable = new RetakeRed(main);
                    //Value CAP
                    redRetakeRunnable.redcap = capturered;
                    //Start Runnable
                    redRetakeRunnable.retakered = retakered;
                    redRetakeRunnable.runTaskTimer(main,20L, 20L);
                }
            }
            if(main.teams.isRed(p)){
                if(alreadyInZoneRed.contains(p)){
                    alreadyInZoneRed.remove(p);
                }
                if(alreadyInZoneRed.isEmpty()){
                    if(redRetakeRunnable != null){
                        redRetakeRunnable.cancel();
                        retakered = redRetakeRunnable.retakered;
                    }
                    if(main.captureRed != null){
                        main.captureRed.cancel();
                        capturered = main.captureRed.capturered;
                    }else if(alreadyInZoneRed.isEmpty() && !alreadyInZoneBlue.isEmpty() && blueRetakeRunnable == null){
                        //Substract value for Red RETAKE
                        retakered = 0;
                        //RUNNABLE
                        blueRetakeRunnable = new RetakeBlue(main);
                        //Value CAP
                        blueRetakeRunnable.bluecap = captureblue;
                        //Start Runnable
                        blueRetakeRunnable.retakeblue = retakeblue;
                        blueRetakeRunnable.runTaskTimer(main, 20L, 20L);
                    }
                }
            }
        }
    }
}
