package waterpunch.tool;

import java.util.UUID;

import waterpunch.tool.data.Info;

public class IUIOpener extends Info {

    public IUIOpener(UUID playerUUID) {
        setOwner(playerUUID);
    }
}
