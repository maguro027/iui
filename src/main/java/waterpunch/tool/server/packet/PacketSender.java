package waterpunch.tool.server.packet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.google.gson.Gson;

import waterpunch.tool.Core;
import waterpunch.tool.InventoryUserInterface;
import waterpunch.tool.server.packet.client.IUIUPLoadRequest;

/**
 * @author maguro027
 * @version 0.1 このクラスは、IUIサーバーにデータを送信するためのクラスです。
 * 既存のクラスは概要できなものなので、まるっきり中身を変えても大丈夫です。
 */
public class PacketSender {

    public byte[] packetConverter(IUIPacket packet) {
        String json = new Gson().toJson(packet);
        return json.getBytes();
    }

    public void sendIUI(InventoryUserInterface iui) throws IOException {
        sendPacket(packetConverter(new IUIUPLoadRequest(iui)));
    }

    public String sendPacket(byte[] bytes) throws IOException {
        return send(bytes);
    }

    public String sendPacket(IUIPacket packet) throws IOException {
        return send(packetConverter(packet));
    }

    private String send(byte[] bytes) throws IOException {
        try (Socket socket = new Socket(Core.getHost(), Core.getPort()); OutputStream out = socket.getOutputStream(); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.write(bytes);
            out.flush();

            // サーバーからの応答を受信
            return in.readLine();
        }
    }
}
