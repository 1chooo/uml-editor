package Utils;

public enum Config {
    APP_NAME("UML Editor"),
    MENU_APP_NAME("UML Editor"),
    MENU_FILE("File"),
    MENU_EDIT("Edit"),
    MENU_ITEM_ABOUT("About UML Editor"),
    MENU_ITEM_QUIT("Quit (Control + Q)"),
    MENU_ITEM_CHANGE_OBJ_NAME("Change Object Name"),
    MENU_ITEM_GROUP("Group"),
    MENU_ITEM_UNGROUP("UnGroup");

    private final String value;

    private Config(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
