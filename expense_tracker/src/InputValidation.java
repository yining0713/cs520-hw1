import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * The class provides methods that validate the input values
 * and a method that generates the dialog window and displays the error messages to users.
 */
public class InputValidation {

    /*
     * Define the error messages for each type of input errors.
     * Will be shown in the message dialog window.
     */
    public static String amountNotInRangeError = "Please enter a number between 0 and 1000.";
    public static String amountNotDigitError = "Please input a valid number for the amount.";
    private static List<String> categories = List.of("food", "travel", "bills", "entertainment", "other");
    public static String categoryError = String.format("Please enter one of the following categories: %s, %s, %s, %s, and %s.", 
        categories.get(0), categories.get(1), categories.get(2), categories.get(3), categories.get(4));

    /**
     * Displays an info box with a title and a specific error message
     * @param infoMessage   the error message specific to a type of error
     */
    public static void generateErrorDialog(String infoMessage)
    {
        String errorTitle = "Error: Invalid input";
        JOptionPane.showMessageDialog(null, infoMessage, errorTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Evaluates the amount. Needs to be between 0 and 1000 (exclusive)
     * @param amount the amount that the user entered. 
     *                  ExpenseTrackerApp checks if the string is digits so we can assume it's a valid number
     * @return true if the amount is bigger than 0 and smaller than 1000, false otherwise.
     */
    public static boolean isInRangeAmount(double amount){
        return (amount < 1000 && amount > 0);
    };

    /**
     * Evaluates the category. Has to be one of food, travel, bills, entertainment, and other. 
     * Case sensitive, needs to be in lowercase
     * 
     * @param category  the user input for category.
     * @return  true if the category is within the five words above, false otherwise.
     */
    public static boolean isValidCategory(String category){
        return categories.contains(category);
    }
}