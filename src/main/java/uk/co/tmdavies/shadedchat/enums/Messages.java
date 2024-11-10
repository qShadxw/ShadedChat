package uk.co.tmdavies.shadedchat.enums;

import uk.co.tmdavies.shadedchat.utils.ShadowUtils;

public enum Messages {

    // Utils
    NO_PERMISSION("&cYou do not have permission to execute this command. [%s]"),
    USAGE("&cUsage: "),

    // Commands
    RELOADED("&aSuccessfully reloaded all configs."),
    MAIN_COMMAND_USAGE(USAGE.getMessage() + "/shadedchat <reload>");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ShadowUtils.Chat(this.message);
    }

    @Override
    public String toString() {
        return getMessage();
    }

}
