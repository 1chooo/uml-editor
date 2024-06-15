package Utils;

public class MODES {
    public static final String SELECT = "Select";
    public static final String ASSOCIATION_LINE = "AssociationLine";
    public static final String GENERALIZATION_LINE = "GeneralizationLine";
    public static final String COMPOSITION_LINE = "CompositionLine";
    public static final String CLASS = "Class";
    public static final String USE_CASE = "Use Case";

    public static String getModeButtonName(String mode) {
        switch (mode) {
            case SELECT:
                return "Select";
            case ASSOCIATION_LINE:
                return "<html>Association<br>Line</html>";
            case GENERALIZATION_LINE:
                return "<html>Generalization<br>Line</html>";
            case COMPOSITION_LINE:
                return "<html>Composition<br>Line</html>";
            case CLASS:
                return "Class";
            case USE_CASE:
                return "Use Case";
            default:
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
