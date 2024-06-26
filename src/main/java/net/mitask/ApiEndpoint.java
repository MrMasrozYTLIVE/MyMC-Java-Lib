package net.mitask;

public enum ApiEndpoint {
    HELLO("hello"),
    TIME("time"),
    STATS("stats"),
    LOG("log"),
    START("start"),
    STOP("stop"),
    RESTART("restart"),
    MY_LINK("my-link"),
    MY_SFTP("my-sftp"),
    MY_HASH("my-hash"),
    MY_HASH_SFTP("my-hash-sftp"),
    LIST_PLAYERS("list-players"),
    WEBSITE("website"),
    MAP("map"),
    BAN("ban"),
    UNBAN("unban"),
    SAY("say"),
    TELL("tell"),
    CONSOLE("console"),
    GIVE("give"),
    INSTALL("install"),
    UNINSTALL("uninstall"),
    SEARCH("search"),
    MOD_LIST("mod-list");

    private final String endpoint;

    ApiEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
