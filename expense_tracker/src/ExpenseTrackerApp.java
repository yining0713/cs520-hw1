import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {

      boolean isAmountDigit = true;
      
      // Get transaction data from view
      double amount = 0; 

      // Check if the user entered a valid number for the amount
      try {
        amount = view.getAmountField(); 
      } catch (java.lang.NumberFormatException error) {
        InputValidation.generateErrorDialog(InputValidation.amountNotDigitError);
        isAmountDigit = false;
      }

      boolean isAmountInRange = false;
      if (isAmountDigit){
        isAmountInRange = InputValidation.isInRangeAmount(amount);
        if (!isAmountInRange){
          InputValidation.generateErrorDialog(InputValidation.amountNotInRangeError);
        }
      }

      String category = view.getCategoryField();
      // Check if the user entered a valid category
      boolean isCategoryValid = InputValidation.isValidCategory(category);
      if (!isCategoryValid){
        InputValidation.generateErrorDialog(InputValidation.categoryError);
      }
      
      // Add the transaction only if both the amount and category are valid input.
      if (isAmountDigit && isCategoryValid && isAmountInRange){
        // Create transaction object
        Transaction t = new Transaction(amount, category);

        // Call controller to add transaction
        view.addTransaction(t);
      }
    });

  }

}
