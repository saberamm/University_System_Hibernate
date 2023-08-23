package entity.enumeration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ui.UserMenu.scanner;

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
    public static Semester selectSemester() {
        Semester selectedSemester = null;

        System.out.println("Available Semesters:");
        int index = 1;
        for (Semester semester : Semester.values()) {
            System.out.println(index + ". " + semester.name().replace("_", " "));
            index++;
        }

        while (selectedSemester == null) {
            System.out.print("Enter the number of the desired semester: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= Semester.values().length) {
                selectedSemester = Semester.values()[choice - 1];
            } else {
                System.out.println("Invalid choice. Please choose a valid semester.");
            }
        }
        return selectedSemester;
    }
}
