package utils;

public class MODES {
    public static final String SELECT = "Select";
    public static final String ASSOCIATION_LINE = "Association Line";
    public static final String GENERALIZATION_LINE = "Generalization Line";
    public static final String COMPOSITION_LINE = "Composition Line";
    public static final String CLASS = "Class";
    public static final String USE_CASE = "Use Case";

    public static String getModeButtonName(String mode) {
        if (mode.equals(SELECT)) {
            return str2HTML(SELECT);
        } else if (mode.equals(ASSOCIATION_LINE)) {
            return str2HTML(ASSOCIATION_LINE);
        } else if (mode.equals(GENERALIZATION_LINE)) {
            return str2HTML(GENERALIZATION_LINE);
        } else if (mode.equals(COMPOSITION_LINE)) {
            return str2HTML(COMPOSITION_LINE);
        } else if (mode.equals(CLASS)) {
            return str2HTML(CLASS);
        } else if (mode.equals(USE_CASE)) {
            return str2HTML(USE_CASE);
        } else {
            return "";
        }
    }

    private static String str2HTML(String str) {
        if (str.contains(" ")) {
            String[] words = str.split(" ");
            StringBuilder htmlString = new StringBuilder("<html>");

            for (int i = 0; i < words.length; i++) {
                htmlString.append(words[i]);
                if (i < words.length - 1) {
                    htmlString.append("<br>");
                }
            }
            
            htmlString.append("</html>");
            
            return htmlString.toString();
        } else {
            return "<html>" + str + "</html>";
        }
    }

    public static String getModeImagePath(String mode) {
        if (mode.equals(SELECT)) {
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

    private MODES() {
    }
}
