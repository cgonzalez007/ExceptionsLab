package lab3;

/**
 * This class provides various services relating to name manipulation.
 * No output should be performed here.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int MAX_FULL_NAME_LENGTH = 60;
    private static final int MIN_FULL_NAME_LENGTH = 5;
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     * @throws YourCustomExceptionName if fullName is null or empty or has
     * fewer than two parts
     */
    public String extractLastName(String fullName) throws 
            InvalidFullNameInputException {

        String lastName = null;
        String[] firstAndLastName = fullName.split(" ");
        if(fullName.length() >MAX_FULL_NAME_LENGTH ||fullName.length()
                < MIN_FULL_NAME_LENGTH||firstAndLastName.length < 2){              
            throw new InvalidFullNameInputException();
        }
        lastName = firstAndLastName[firstAndLastName.length-1];
        
        return lastName;
    }
    
}
