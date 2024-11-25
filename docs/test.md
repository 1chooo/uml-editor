```java
// src/Utils/StatusCode.java

package Utils;

public class StatusCode {
    // public variables
    public static int OK = 200;
    public static int EXIT = 0;
    public static int ERROR = 500;
    public static int NOT_FOUND = 404;
    public static int BAD_REQUEST = 400;

    // constructor
    public int getOK() {
        return OK;
    }

    // public methods
    public int getEXIT() {
        return EXIT;
    }

    public int getERROR() {
        return ERROR;
    }

    public int getNOT_FOUND() {
        return NOT_FOUND;
    }

    public int getBAD_REQUEST() {
        return BAD_REQUEST;
    }
}
```
