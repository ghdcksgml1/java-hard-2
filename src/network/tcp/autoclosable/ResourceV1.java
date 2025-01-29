package network.tcp.autoclosable;

import java.io.Closeable;

public class ResourceV1 {
    private String name;

    public ResourceV1(String name) {
        this.name = name;
    }

    public void call() {
        System.out.println("[call] name = " + name);
    }

    public void callException() throws CallException {
        System.out.println("[callException] name = " + name);
        throw new CallException(name + " exception");
    }

    public void close() {
        System.out.println("[close] name = " + name);
    }

    public void closeException() throws CloseException {
        System.out.println("[closeException] name = " + name);
        throw new CloseException(name + " ex");
    }
}
