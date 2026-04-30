package ed.masanz.ut9.blackjackfx.model;

public class UserSession {
    private static UserSession instance;

    private String nickname;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
