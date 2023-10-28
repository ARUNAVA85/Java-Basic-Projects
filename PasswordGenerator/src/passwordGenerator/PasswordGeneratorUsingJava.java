package passwordGenerator;

import java.util.Random;
import java.util.Scanner;

public class PasswordGeneratorUsingJava {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = " ";
		int len = 0;
		boolean flag = true;
		while(flag) {
			System.out.println("Enter the length of the password to be generated");
			len = sc.nextInt();
			if(len < 8) {
				System.out.println("Minimum length of the password should be atleast 8 char long");
			}
			else {
				s = String.valueOf(generatePassword(len));
				System.out.println("Your generated password is : " + s);
				flag = false;
			}
		}
		System.out.println("Checking password...");
//		System.out.println(s);
		checkPassword(s);
	}

private static char[] generatePassword(int length) {
    String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String specialCharacters = "!@#$";
    String numbers = "1234567890";
    String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
    Random random = new Random();
    char[] password = new char[length];

    password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
    password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
    password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
    password[3] = numbers.charAt(random.nextInt(numbers.length()));
 
    for(int i = 4; i< length ; i++) {
       password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
    }
    return password;
 }

public static void checkPassword(String password) {
	if(password.contains(" ")) {
		System.out.println("Invalid Password");
		return;
	}
	
	boolean has8Digits = password.length() >= 8;
	boolean hasUpperCase = false;
	boolean hasLowerCase = false;
	boolean hasSpecialChar = false;
	boolean hasDigits = false;
	
	for(int i = 0; i < password.length(); i++) {
		char ch = password.charAt(i);
		if(Character.isUpperCase(ch)) {
			hasUpperCase = true;
		}else if(Character.isLowerCase(ch)) {
			hasLowerCase = true;
		}
		else if(Character.isDigit(ch)) {
			hasDigits = true;
		}
		else {
			hasSpecialChar = true;
		}
	}
	boolean isStrongPassword = has8Digits && hasUpperCase && hasLowerCase && hasSpecialChar && hasDigits;
	if(isStrongPassword) {
		System.out.println(password + " -> is a strong password");
	}else {
		System.out.println(password + " -> is not a strong password");
	}
}
}