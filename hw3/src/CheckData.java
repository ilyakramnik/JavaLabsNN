import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * class for data checking
 */
public class CheckData {
    /**
     * returns gender of a human
     * @return gender
     */
    public String getGender(String patronymic) {
        String gender;
        if (patronymic.endsWith("ич")) {
            return "M";
        } else {
            return "Ж";
        }
    }

    /**
     * returns age of a human
     * @param birthDateString date of birth
     * @return age
     */
    public int getAge(String birthDateString){
        LocalDate birthDate = LocalDate.parse(birthDateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate currentDate = LocalDate.now();
        Period agePeriod = Period.between(birthDate, currentDate);
        return agePeriod.getYears();
    }

    /**
     * returns age suffix of a human
     * @param birthDateString date of birth
     * @return age suffix
     */
    public String getAgeSuffix(String birthDateString, int age){
        String ageSuffix;
        if (age % 10 >= 2 && age % 10 <= 4) {
            ageSuffix = "года";
        } else if (age % 10 == 1 && age != 11) {
            ageSuffix = "год";
        } else {
            ageSuffix = "лет";
        }
        return ageSuffix;
    }

    /**
     * checks initials of a human
     * @return are initials correct or not
     */
    public boolean isRightInitials(String lastName, String firstName, String patronymic){
        for (int i=0; i<lastName.length(); ++i){
            if (Character.isDigit(lastName.charAt(i))){
                return false;
            }
        }
        for (int i=0; i<firstName.length(); ++i){
            if (Character.isDigit(firstName.charAt(i))){
                return false;
            }
        }
        for (int i=0; i<patronymic.length(); ++i){
            if (Character.isDigit(patronymic.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
