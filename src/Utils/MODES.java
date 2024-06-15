package Utils;

public class MODES {
    public static String SELECT = "Select";
    public static String ASSOCIATION_LINE = "AssociationLine";
    public static String GENERALIZATION_LINE = "GeneralizationLine";
    public static String COMPOSITION_LINE = "CompositionLine";
    public static String CLASS = "Class";
    public static String USE_CASE = "Use Case";

    public static String getModeButtonName(String mode) {
        if (mode.equals(SELECT)) {
            return "Select";
        } else if (mode.equals(ASSOCIATION_LINE)) {
            return "<html>Association<br>Line</html>";
        } else if (mode.equals(GENERALIZATION_LINE)) {
            return "<html>Generalization<br>Line</html>";
        } else if (mode.equals(COMPOSITION_LINE)) {
            return "<html>Composition<br>Line</html>";
        } else if (mode.equals(CLASS)) {
            return "Class";
        } else if (mode.equals(USE_CASE)) {
            return "Use Case";
        } else {
            return "";
        }
    }
    public static String getModeImagePath(String mode) {
        if(mode.equals(SELECT)){
            return "imgs/select.png";
        } else if (mode.equals(ASSOCIATION_LINE)) {
            return "imgs/association-line.png";
        } else if (mode.equals(GENERALIZATION_LINE)) {
            return "imgs/generation-line.png";
        } else if (mode.equals(COMPOSITION_LINE)) {
            return "imgs/composition-line.png";
        } else if (mode.equals(CLASS)) {
            return "imgs/class.png";
        } else if (mode.equals(USE_CASE)) {
            return "imgs/use-case.png";
        } else {
            return "";
        }
    }
}
