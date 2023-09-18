# hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

## How to build and test (from Terminal):
1. Make sure that you have Apache Ant installed.

2. Run ```ant``` in the root directory, which contains the build.xml build file.

3. Compiled java classes will be in the bin directory.

4. Run ```ant test``` to run all unit tests.

## How to run (from Terminal):
After building the project (i.e., running ant), run: ```java -cp bin ExpenseTrackerApp```

## How to clean up (from Terminal):
Run ```ant clean``` to clean the project (i.e., delete all generated files).

## Code Modification

Create a file named ```InputValidation.java```  to validate the ```amount``` and ```category``` field of this app. Some hints are as follows:
1. The ```amount``` should be greater than 0 and less than 1000. 
2. It should be a valid number. 
3. The ```category``` should be a valid string input from the following list: "food", "travel", "bills", "entertainment", "other" .

## Manual Review
Here are some examples of satisfying ```non-functional`` requirements:
1. Understandability
• External documentation (such as a README file) improves program understanding. This app’s
README file helps users and developers by providing the build instructions.


Here are some examples of violating ```non-functional``` requirements:
1.  Modularity
• The app does not apply the MVC architecture pattern.
• The app should declare the following packages and their classes: model, view, controller. 