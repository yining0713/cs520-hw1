import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InputValidation {

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean InputValidationAmount(double amount){
        String amountError = "Please enter a number between 0 and 1000.";
        if (amount > 1000 || amount < 0) {
            infoBox(amountError, "Error: Invalid Input");
            return false;
        } 
        return true;
    };

    public static boolean InputValidationCategory(String category){
        ArrayList<String> categories = new ArrayList<>();
        categories.add("food");
        categories.add("travel");
        categories.add("bills");
        categories.add("entertainment");
        categories.add("other");
        String categoryError = String.format("Please enter one of the following categories: %s, %s, %s, %s, and %s.", 
        categories.get(0), categories.get(1), categories.get(2), categories.get(3), categories.get(4));
        if (!categories.contains(category)){
            infoBox(categoryError, "Error: Invalid Input");
            return false;
        }
        return true;
    }
}