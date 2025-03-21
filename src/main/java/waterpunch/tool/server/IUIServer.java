package waterpunch.tool.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import waterpunch.tool.InventoryUserInterface;
import waterpunch.tool.item.IUIItem;
import waterpunch.tool.item.ItemTool;
import waterpunch.tool.server.packet.client.ClientPacket;
import waterpunch.tool.server.packet.client.ClientPacket.ClientPacketType;
import waterpunch.tool.server.packet.client.IUIItemUPLoadRequest;
import waterpunch.tool.server.packet.client.ServerFirstConnect;
import waterpunch.tool.server.packet.server.errors.BadRequest;
import waterpunch.tool.tool.messeage.ColoredText;
import waterpunch.tool.tool.messeage.Messenger;
import waterpunch.tool.tool.messeage.errorreport.BADPacketErrorReport;

/**
 * @author maguro027
 * @version 0.1
 */
public class IUIServer {

	static final HashMap<String, UUID> connectionServers = new HashMap<>();
	static final HashMap<String, ArrayList<InventoryUserInterface>> iuis = new HashMap<>();
	static final HashMap<String, ArrayList<IUIItem>> items = new HashMap<>();

	/**
	 * サーバーデバック用です。
	 */
	public static void main(String[] args) throws IOException {
		int port = 12345; // 待ち受けるポート番号
		int maxBuffer = 20000; // バッファの最大値
		ClearMemory();
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("ポート" + port + "で接続待ち");

			while (true) {
				try (Socket clientSocket = serverSocket.accept()) {
					// System.out.println("クライアントからの接続を受け付けました");

					PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					// ここで受信したパケットの処理を行う
					byte[] buffer = new byte[maxBuffer];

					int bytesRead = clientSocket.getInputStream().read(buffer);
					String receivedData = new String(buffer, 0, bytesRead);
					try {
						Gson gson = new Gson();
						ClientPacket packet = gson.fromJson(receivedData, ClientPacket.class);

						System.out.println(receivedData);

						// パケットの解析、プラグインの名前などがデフォルトだとエラーを返します。
						if (packet.getPluginName().equals("DEFAULT")
								|| packet.getPluginName().isEmpty()) {
							BadRequest errorPacket =
									new BadRequest(BadRequest.BadPacketType.BADPluginName);
							BADPacketErrorReport errorReport = new BADPacketErrorReport(errorPacket,
									receivedData, clientSocket);
							out.println(errorReport.encodeLog());
							clientSocket.close();
						}
						if (!packetSwitcher(packet.getType(), receivedData, clientSocket, out))
							clientSocket.close();
					} catch (JsonSyntaxException e) {
						// TODO ログシステムの追加、ClientPacket以外が送信された場合にサーバーログに記録する
						// ErrorMessenger.UnknownPacketType.getMessage();0
						clientSocket.close();
					} catch (IOException | RuntimeException e) {
						// TODO ログシステムの追加、不明なエラーが発生した場合にサーバーログに記録する
						// ErrorMessenger.UnknownError.getMessage();
						clientSocket.close();
					}
					out.println("responseだよ");
					// 接続を閉じる
				}
			}
		}
	}

	public static void ClearMemory() {
		connectionServers.clear();
		iuis.clear();
		items.clear();
	}

	/**
	 * パケットの処理を行います。
	 * 
	 * @param type パケットのタイプ
	 * @param data パケットのデータ
	 * @param socket ソケット
	 * @param out 出力
	 * @return 処理が成功した場合はtrue、失敗した場合はfalseを返します。
	 */
	public static boolean packetSwitcher(ClientPacketType type, String data, Socket socket,
			PrintWriter out) {
		Gson gson = new Gson();

		try {
			switch (type) {
				case IUIDeleteRequest:
					break;
				case IUIGetRequest:
					break;
				case IUIItemUPLoadRequest:
					IUIItemUPLoadRequest iuiItemUPLoadRequest =
							gson.fromJson(data, IUIItemUPLoadRequest.class);
					if (!checkConnectionServers(iuiItemUPLoadRequest.getPluginName()))
						return false;
					if (!checkKey(iuiItemUPLoadRequest.getPluginName(),
							iuiItemUPLoadRequest.getSecretKEY()))
						return false;

					addIUIItem(iuiItemUPLoadRequest.getPluginName(),
							iuiItemUPLoadRequest.getItems());
					break;
				case IUIListGetRequest:
					break;
				case IUISERVERRESPONSE:
					break;
				case IUIServerFastConnect:
					ServerFirstConnect serverFirstConnect =
							gson.fromJson(data, ServerFirstConnect.class);
					System.out.println(new Messenger(
							"Get ServerFirstConnect... from " + serverFirstConnect.getPluginName())
									.encodeLog());

					// サーバーの名前が既に登録されている場合はエラーを返します。
					if (checkConnectionServers(serverFirstConnect.getPluginName())) {
						System.out.println(new Messenger(serverFirstConnect.getPluginName()
								+ " Registered " + ColoredText.setRED("Failure.")).encodeLog());
						BadRequest errorPacket =
								new BadRequest(BadRequest.BadPacketType.ExistingName);
						BADPacketErrorReport errorReport =
								new BADPacketErrorReport(errorPacket, data, socket);
						out.println(errorReport.encodeLog());
						System.out.println(errorReport.encodeLog());
						return false;
					}
					// UUIDの秘密鍵を生成し、メモリに格納します。
					UUID key = UUID.randomUUID();
					connectionServers.put(serverFirstConnect.getPluginName(), key);

					// ConnectionServersにサーバーの名前を追加します。
					System.out.println(new Messenger(serverFirstConnect.getPluginName()
							+ " Registered " + ColoredText.setGREEN("Success.")).encodeLog());

					// アイテムを登録します。
					addIUIItem(serverFirstConnect.getPluginName(), serverFirstConnect.getItems());

					out.println(true);
					return true;
				case IUIUPLoadRequest:
					break;
				case PING:
					break;
				default:
					break;
			}
			return false;
		} catch (JsonSyntaxException e) {
			// TODO ログシステムの追加、ClientPacket以外が送信された場合にサーバーログに記録する
			// ErrorMessenger.UnknownPacketType.getMessage();
			return false;
		}
	}

	/**
	 * サーバーに接続されているか確認します。
	 * 
	 * @param pluginName プラグインの名前
	 * @return 接続されている場合はtrue、接続されていない場合はfalseを返します。
	 */
	public static Boolean checkConnectionServers(String pluginName) {
		return connectionServers.containsKey(pluginName);
	}

	/**
	 * サーバーの秘密鍵が正しいか確認します。
	 * 
	 * @param pluginName プラグインの名前
	 * @param key サーバーの秘密鍵
	 * @return 秘密鍵が正しい場合はtrue、正しくない場合はfalseを返します。
	 */
	public static Boolean checkKey(String pluginName, UUID key) {
		if (!checkConnectionServers(pluginName))
			return false;
		return connectionServers.get(pluginName).equals(key);
	}

	/**
	 * アイテムを取得します。
	 * 
	 * @param pluginName
	 * @return
	 */
	public static ArrayList<IUIItem> getItems(String pluginName) {
		return items.get(pluginName);
	}

	/**
	 * アイテムを登録します。
	 * 
	 * @param pluginName プラグインの名前
	 * @param items アイテムのリスト
	 */
	public static void addIUIItem(String pluginName, ArrayList<IUIItem> items) {
		// リストが空の場合は処理を行いません。
		if (items.isEmpty())
			return;
		// forでリストを分解し、addIUIItemを呼び出します。
		for (IUIItem item : items)
			addIUIItem(pluginName, item);
	}

	/**
	 * アイテムを登録します。
	 * 
	 * @param pluginName プラグインの名前
	 * @param item アイテム
	 * @return 登録に成功した場合はtrue、失敗した場合はfalseを返します。
	 */
	public static boolean addIUIItem(String pluginName, IUIItem item) {
		// アイテムリストが存在しない場合は新規作成します。
		if (items.get(pluginName) == null)
			items.put(pluginName, new ArrayList<>());
		// リストに登録されているか確認します。
		if (ItemTool.checkItemList(items.get(pluginName), item)) {
			items.get(pluginName).add(item);
			System.out.println(new Messenger(
					"[" + pluginName + "] " + ColoredText.setGREEN("■ ") + " Add" + item.getName())
							.encodeLog());
			return true;
		} else {
			// 重複したアイテムは無視します。
			System.out.println(new Messenger("[" + pluginName + "] " + ColoredText.setYELLOW("■ ")
					+ " is Already registered " + item.getName()).encodeLog());
			return false;
		}
	}
}
