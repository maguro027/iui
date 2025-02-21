package waterpunch.tool.server.packet.client;

import java.util.ArrayList;

import waterpunch.tool.IUITool;
import waterpunch.tool.InventoryUserInterface;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.item.ItemTool;

/**
 * @author maguro027
 * @version 0.1
 * このクラスは、サーバーに最初に接続するためのパケットです。
 * ポートやIUIのバージョン情報を送信します。
 */
public final class ServerFirstConnect extends ClientPacket {

     private final ArrayList<InventoryUserInterface> iuis;
     private final ArrayList<IUIItem> items;

     /**
      * @see サーバーとの初回通信用のパケットです。
      * @see ここの情報がサーバー上に保持されます。
      */
     public ServerFirstConnect() {
          super(ClientPacketType.IUIServerFastConnect);
          iuis = new ArrayList<>();
          items = new ArrayList<>();
     }

     public void addIUI(InventoryUserInterface iui) {
          if (IUITool.checkIUIList(getIUIs(), iui)) iuis.add(iui);
     }

     public void addIUIs(ArrayList<InventoryUserInterface> iuis) {
          for (InventoryUserInterface iui : getIUIs()) if (IUITool.checkIUIList(getIUIs(), iui)) this.iuis.add(iui);
     }

     public ArrayList<InventoryUserInterface> getIUIs() {
          return iuis;
     }

     public void addItems(ArrayList<IUIItem> items) {
          for (IUIItem iuiItem : items) addItem(iuiItem);
     }

     public void addItem(IUIItem item) {
          if (ItemTool.checkItemList(getItems(), item)) items.add(item);
     }

     public ArrayList<IUIItem> getItems() {
          return items;
     }
}
