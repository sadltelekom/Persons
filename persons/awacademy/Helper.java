package persons.awacademy;

public class Helper {

    public static boolean isValidName(String name){ // Class Method
        // can not use instance or object Variables.
        boolean isValid = false;
        if (name.length() >= 3) {
            for(int i = 0; i < name.length();i++) {
                if(name.charAt(i) >= 65 && name.charAt(i) <= 90 ||
                        name.charAt(i) >= 97 && name.charAt(i) <= 122 ||
                        name.charAt(i) == 32) {
                    isValid = true;
                }
                else {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    public static boolean isValidGender(String gender){
        boolean isValid = false;
        if(gender.toUpperCase().equals("M") || gender.toUpperCase().equals("F")) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean isValidAge(int age) {
        boolean isValid = false;
            if(age > 18 && age < 120){
                isValid=true;
            }
        return isValid;
    }

    public static String sanitizeName(String name) {
        String sanitizedName = "";
        String[] namePartArray = name.trim().replaceAll("\\s+" ," ").split(" ");

        for(String namePart: namePartArray) {
            sanitizedName = sanitizedName + namePart.substring(0, 1).toUpperCase() + namePart.substring(1).toLowerCase() + " ";
        }

        return sanitizedName.substring(0,sanitizedName.length()-1);
    }

    public static String leftTrim(String lTrim ) {
        return lTrim.replaceAll("^\\s+" ,"");
    }

    public static boolean isValidEmail(String email) {
        // must have an @ sign.
        // Must end in a valid domain name
        // Must have a valid mail username:
        // see https://www.rfc-editor.org/rfc/rfc6530 it is best practice to allow everything for that

        if(email.contains("@")) {
            String[] emailPartsArray = email.split("@");
            if (emailPartsArray.length != 2 || emailPartsArray[0].equals("") || emailPartsArray[1].equals("")) {
                return false;
            }
            else if (isValidDomain(emailPartsArray[1])){
                if(isValidEmailUsername(emailPartsArray[0])) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return false;
    }

    public static boolean isValidDomain(String domainName) {
        // A domain name consists of minimum four and maximum 65 characters.
        // need a dot TLD
        // All letters from a to z, all numbers from 0 to 9 and a hyphen (-) are possible.


        if(domainName.length() < 4 || domainName.length() > 65) {
            return false;
        }
        if(!domainName.contains(".")) {
            return false;
        }
        for(int i = 0; i < domainName.length();i++) {
            if(domainName.charAt(i) >= 48 && domainName.charAt(i) <= 57 ||
               domainName.charAt(i) >= 65 && domainName.charAt(i) <= 90 ||
               domainName.charAt(i) >= 97 && domainName.charAt(i) <= 122 ||
               domainName.charAt(i) == 45 ||
               domainName.charAt(i) == '.' ) {

            }
            else {
                return false;
            }
        }


        return true;
    }

    public static boolean isValidEmailUsername(String emailUsername) {
        // evreything allowed see:
        // https://www.rfc-editor.org/rfc/rfc6530
        for (char character: emailUsername.toCharArray()) {
            if(character == ' ') {
                return false;
            }
        }
        return true;
    }
}
