package network.tcp.autoclosable;

public class ResourceCloseMainV1 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = new ResourceV1("resource1");
        ResourceV1 resource2 = new ResourceV1("resource2");

        resource1.call();
        resource2.callException();

        System.out.println("자원 정리");
        resource2.closeException();
        resource1.close();
    }
}
