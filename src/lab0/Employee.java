package lab0;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private int daysVacation;

    public Employee() {
        // initialize a bunch of default values
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, 
            int daysVacation) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        setDaysVacation(daysVacation);
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }
    /** Validation rules:
    * -min cannot be less than 0
    * -max cannot be more than 120
     * @param daysVacation
    */
    public void setDaysVacation(int daysVacation) throws 
            IllegalArgumentException{
        if(daysVacation < 0 || daysVacation > 120 ){
            throw new IllegalArgumentException("Sorry, vacation days must"
                    + "be between 0 and 120 days inclusive");
        }
        this.daysVacation = daysVacation;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
         /**Pattern sets the rules for what exactly we are checking here.
         * Matcher makes sure that the the string being passed matches 
         * the pattern. (only contains a-z and 0-9, no special characters
         * besides a dash mark.)
        */
        Pattern p = Pattern.compile("[^a-z0-9-]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(firstName);
        boolean isValid = m.find();
        if(firstName.isEmpty()|| !isValid || firstName == null ||
                firstName.length()>50){
                throw new RuntimeException("Sorry, a firstName name must be"
                        + " provided.\nNo Special symbols allowed.\nLast name"
                        + " must be between 1 and 50 characters.");           
        }
        this.firstName = firstName;
    }

    public final  String getLastName() {
        return lastName;
    }
    /**
     *Validation Rules:
     * -No nulls values allowed
     * -No empty strings allowed
     * -No special symbols allowed
     * -No length must be between 1 and 50
     * @param lastName
     */
    public void setLastName(String lastName) throws RuntimeException {
        /**Pattern sets the rules for what exactly we are checking here.
         * Matcher makes sure that the the string being passed matches 
         * the pattern. (only contains a-z and 0-9, no special characters
         * besides a dash mark.)
        */
        Pattern p = Pattern.compile("[^a-z0-9-]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(lastName);
        boolean isValid = m.find();
        if(lastName.isEmpty()|| !isValid || lastName == null ||
                lastName.length()>50){
                throw new RuntimeException("Sorry, a last name must be provided."
                        + "\nNo Special symbols allowed.\nLast name must be"
                        + "between 1 and 50 characters.");           
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }
    /**
     * Must follow pattern : "###-##-####"
     * Should automatically add dashes
     * @param ssn
     * @throws RuntimeException 
     */
    public void setSsn(String ssn) throws RuntimeException {
        /**Pattern sets the rules for what exactly we are checking here.
         * Matcher makes sure that the the string being passed matches 
         * the pattern. (only contains 0-9, no a-z characters no special
         * characters besides a dash mark.)
        */
        Pattern pattern1 = Pattern.compile("^[0-9]{3}-[0-9]{2}-[0-9]{4}$");
        Pattern pattern2 = Pattern.compile("^[0-9]{9}$");
        Matcher matcher1 = pattern1.matcher(ssn);
        Matcher matcher2 = pattern2.matcher(ssn);
        boolean isValid = matcher1.find();
        boolean isValidWithoutHyphens = matcher2.find();
        if(ssn.isEmpty()|| !isValid || !isValidWithoutHyphens ||ssn == null ||
                ssn.length()>50){
                throw new RuntimeException("Sorry, a valid SSN must be "
                        + "provided.\nNo Special symbols allowed.\nSSN "
                        + "format: ###-##-#### or #########.");           
        } 
        if(isValidWithoutHyphens){
            ssn = new StringBuilder(ssn).insert(3, '-').insert(6, '-').
                    toString();
        }
        this.ssn = ssn;
    }
    //For testing purposes...
    public static void main(String[] args) {
//         Pattern p = Pattern.compile("^[0-9]{9}$");
//        Matcher m = p.matcher("339193415");
//        boolean isInvalid = m.find();
//        String x = "339193415";
//        x = new StringBuilder(x).insert(3, '-').insert(6, '-').toString();
//        System.out.println(x);
Pattern p = Pattern.compile("[a-z0-9-]*", Pattern.CASE_INSENSITIVE);
        
        Matcher ma = p.matcher("d-sdfa$sdga");
        boolean isValid = ma.find();
        System.out.println(isValid);
    }
}
