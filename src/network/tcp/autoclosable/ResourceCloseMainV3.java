package network.tcp.autoclosable;

public class ResourceCloseMainV3 {
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
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;


        try {
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callException();
        } catch (CallException e) {
            System.out.println("e = " + e);
            throw e;
        } finally {
            System.out.println("자원 정리");
            if (resource2 != null) {
                try {
                    resource2.closeException();
                } catch (CloseException e) {
                    // close()에서 발생한 예외는 버린다. 필요하면 로깅 정도
                    System.out.println("e = " + e);
                }
            }
            if (resource1 != null) {
                try {
                    resource1.closeException();
                } catch (CloseException e) {
                    System.out.println("e = " + e);
                }
            }
        }
    }
}
