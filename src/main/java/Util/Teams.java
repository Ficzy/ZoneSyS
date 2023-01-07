package Util;

import org.bukkit.entity.Player;
import system.zone.Main;

import java.util.ArrayList;

public class Teams {
    private Main main;
    public ArrayList<Player> blueTeam = new ArrayList<>();
    public ArrayList<Player> redTeam = new ArrayList<>();

    public Teams(Main main){
        this.main = main;
    }


    public void addBlue(Player p){
        if(redTeam.contains(p)){
            redTeam.remove(p);
            blueTeam.add(p);
        } else if (blueTeam.contains(p)) {
            p.sendMessage("tu es deja bleu");
        }
        else {
            blueTeam.add(p);
        }

    }

    public void addRed(Player p){
        if(blueTeam.contains(p)){
            blueTeam.remove(p);
            redTeam.add(p);
        } else if (redTeam.contains(p)) {
            p.sendMessage("tu es deja rouge");
        }
        else {
            redTeam.add(p);
        }
    }


    public boolean isBlue(Player p){
        if(blueTeam.contains(p)){
            return true;
        }
        return false;
    }

    public boolean isRed(Player p){
        if(redTeam.contains(p)){
            return true;
        }
        return false;
    }
}
