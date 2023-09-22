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

      boolean isValid = true;
      
      // Get transaction data from view
      double amount = 0; 

      // Check if the user entered a valid number for the amount
      try {
        amount = view.getAmountField(); 
      } catch (java.lang.NumberFormatException error) {
        InputValidation.infoBox("Please input a valid number for the amount."
        , "Error: Invalid input");
        isValid = false;
      }

      // Check if the user entered an amount between 0 and 1000 (inclusive)
      isValid = InputValidation.InputValidationAmount(amount);
      
      String category = view.getCategoryField();
      // Check if the user entered a valid category
      isValid = InputValidation.InputValidationCategory(category);

      // Add the transaction only if both the amount and category are valid input.
      if (isValid){
        // Create transaction object
        Transaction t = new Transaction(amount, category);

        // Call controller to add transaction
        view.addTransaction(t);
      }
    });

  }

}
