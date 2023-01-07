package system.zone;

import Listener.PlayerMoving;
import Util.Cuboid;
import Util.Teams;
import ZoneRunnable.CaptureBlue;
import ZoneRunnable.CaptureRed;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main instance;

    public CaptureBlue captureBlue;

    public CaptureRed captureRed;

    public Cuboid cuboid;

    public Teams teams = new Teams(instance);
    @Override
    public void onEnable() {
        this.instance = this;
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerMoving(instance), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
