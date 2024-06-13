package Utils;

public enum Helper {
    NAME_LENGTH_WARNING("Please enter a name with less than 10 characters."),
    SELECT_OBJECT_WARNING("You must select exactly a object !"),
    GET_GROUP_WARNING("You must select two or more objects !"),
    GET_UNGROUP_WARNING("You must select exactly a group object !"),
    ABOUT_UML_MESSAGE("Hi There ! This is a simple UML Editor by Hugo. 🙉");

    private final String value;

    private Helper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
