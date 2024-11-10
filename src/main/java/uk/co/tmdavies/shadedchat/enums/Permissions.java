package uk.co.tmdavies.shadedchat.enums;

public enum Permissions {

    MAIN_COMMAND("shadedchat.admin");

    private final String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    @Override
    public String toString() {
        return getPermission();
    }

}
