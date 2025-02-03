package chatmy.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSessionManager {
    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    private static final int CONNECT_TIMEOUT = 5 * 1000;
    private static final int READ_TIMEOUT = 3 * 1000;

    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;

    public ClientSessionManager() throws IOException {
        this.socket = connectServer();
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
    }

    private Socket connectServer() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(SERVER_HOST, SERVER_PORT), CONNECT_TIMEOUT);
        socket.setSoTimeout(READ_TIMEOUT);

        return socket;
    }
}
