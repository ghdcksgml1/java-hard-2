package network.tcp.autoclosable;

public class ResourceV2 implements AutoCloseable {
    private String name;

    public ResourceV2(String name) {
        this.name = name;
    }

    public void call() {
        System.out.println("[call] name = " + name);
    }

    public void callException() throws CallException {
        System.out.println("[callException] name = " + name);
        throw new CallException(name + " exception");
    }

    @Override
    public void close() throws CloseException {
        System.out.println("[close] name = " + name);
        throw new CloseException(name + " ex");
    }

    public void closeException() throws CloseException {
        System.out.println("[closeException] name = " + name);
        throw new CloseException(name + " ex");
    }
}
