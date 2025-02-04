package chat.server;

import java.io.IOException;
import java.util.List;

public class CommandManagerV1 implements CommandManager {
    private final SessionManager sessionManager;

    public CommandManagerV1(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        }

        if (totalMessage.startsWith("/join|")) {
            String username = totalMessage.substring("/join|".length());
            session.setUsername(username);
            sessionManager.sendAll(session, username + "님이 입장하셨습니다.");
        }

        if (totalMessage.startsWith("/message|")) {
            String message = "[" + session.getUsername() + "] " + totalMessage.substring("/message|".length());
            sessionManager.sendAll(session, message);
        }

        if (totalMessage.startsWith("/change|")) {
            String usernameToChange = totalMessage.substring("/change|".length());
            sessionManager.sendAll(session, session.getUsername() + "님이 " + usernameToChange + "로 이름을 변경했습니다.");
            session.setUsername(usernameToChange);
        }

        if (totalMessage.equals("/users")) {
            List<String> usernames = sessionManager.getAllUsername();

            StringBuilder sb = new StringBuilder("전체 접속자: ");
            sb.append(usernames.size()).append("\n");

            usernames.forEach(username -> sb.append(" - ").append(username).append("\n"));
            session.send(sb.toString());
        }

    }
}
