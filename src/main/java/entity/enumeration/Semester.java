package entity.enumeration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Semester {
    term_1_1400,
    term_2_1400,
    term_1_1401,
    term_2_1401,
    term_1_1402,
    term_2_1402,
    term_1_1403,
    term_2_1403;

    public static Semester getPreviousTerm(Semester currentTerm) {
        String termName = currentTerm.name();
        Matcher matcher = Pattern.compile("term_(\\d+)_(\\d+)").matcher(termName);

        if (matcher.matches()) {
            try {
                int termNumber = Integer.parseInt(matcher.group(1));
                int year = Integer.parseInt(matcher.group(2));

                termNumber--;
                if (termNumber < 1) {
                    termNumber = 2;
                    year--;
                }

                String previousTermName = "term_" + termNumber + "_" + year;
                return Semester.valueOf(previousTermName);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid term format", e);
            }
        } else {
            throw new IllegalArgumentException("Invalid term format");
        }
    }
}
