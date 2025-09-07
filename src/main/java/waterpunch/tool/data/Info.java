package waterpunch.tool.data;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Info {

    private String name = "DEFAULT";
    private UUID owner;
    private UUID id;

    public Info() {
        createID();
    }

    public Info(String name) {
        createID();
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return Bukkit.getPlayer(getOwnerUUID());
    }

    public UUID getOwnerUUID() {
        return owner;
    }

    public void setID(UUID id) {
        this.id = id;
    }

    private void createID() {
        this.id = UUID.randomUUID();
    }

    public UUID getID() {
        return id;
    }
}
