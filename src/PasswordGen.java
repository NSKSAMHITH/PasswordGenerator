import java.util.Random;
import java.util.Scanner;

public class PasswordGen {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random =  new Random();

        System.out.println("enter the desired password length you wish to have");

        while(true){
            int passLength = sc.nextInt();

            if (passLength < 5){
                System.out.println("the password length should be more than 5");
                continue;
            }

            //PasswordGenerate
            String password = generatePassword(passLength, random);
            System.out.println("the password is " + password);

            System.out.print("Do you want to generate another password? (yes/no): ");
            sc.nextLine(); // Consume newline
            String response = sc.nextLine().toLowerCase();

            if (!response.equals("yes")) {
                System.out.println("Thank you for using the Password Generator. Goodbye!");
                sc.close();
                break;
            }

    }}

    public static String generatePassword(int length, Random random){
        String upperCaseLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String lowerCaseLetters = "qwertyuiopasdfghjklzxcvbnm";
        String numbers = "1234567890";
        String specialCharacters = "!@#$%^&*()_+-<>?";

        String allChars = upperCaseLetters + lowerCaseLetters + numbers + specialCharacters;

        StringBuilder password = new StringBuilder(length);

        //to ensure char from each category
        password.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
        password.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        for (int i = 4 ; i < length ; i = i+1){
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        //shuffle the generated string
        return shuffleString(password.toString(), random);
    }

    public static String shuffleString(String input, Random random){
        char[] characters = input.toCharArray();
        for(int i = characters.length-1; i>0; i --){
            int j = random.nextInt(i+1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }

}
