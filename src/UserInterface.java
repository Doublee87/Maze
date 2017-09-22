import java.util.Scanner;

public class UserInterface {
	private Scanner usi = new Scanner(System.in);
	

	public String getString (String prompt) {
			System.out.print(prompt);
			String str = usi.nextLine();
			return str;
	}
	
	public int validInt (String prompt,int loVal, int hiVal) {
		int enteredValue = 0;
		do{
			String str = getString(prompt);
			enteredValue = Integer.parseInt(str);
			if (enteredValue <= loVal || enteredValue >= hiVal){
				System.out.println("Enter A Value Between" + loVal+ " and "+ hiVal);
			}
		}while (enteredValue <= loVal || enteredValue >= hiVal);
		
		return enteredValue;
	}
	

	public boolean agrees (String question) {

		while (true){
		System.out.println(question);
		String userInput = usi.nextLine();
		char ch = userInput.charAt(0);
		if (ch == 'y' || ch == 'Y'){
			return true;
		}
		else if (ch == 'n' || ch == 'N'){
			return false;
		}else{
			System.out.print("Enter y or n.");
			return true;
		}
		}
	}
}
