Algorithm
Step 1: Initialize TaskManager
•	Create a TaskManager object.
•	Initialize a Scanner object for user input.

Step 2. Display Menu
•	Print the menu options:
I.	Add Task
II.	Delete Task
III.	Mark Task as Done
IV.	List Tasks
V.	Exit

Step 3. Read User Choice
•	Read the user's menu choice.
•	If the choice is invalid, print an error message and return to the menu.

Step 4. Perform Action Based on Choice
•	Add Task
•	Prompt the user to enter a task description.
•	Call addTask(description) on the TaskManager object.
•	Delete Task
•	Prompt the user to enter the task number to delete.
•	Call deleteTask(index) on the TaskManager object.
•	Mark Task as Done
•	Prompt the user to enter the task number to mark as done.
•	Call markTaskAsDone(index) on the TaskManager object.
•	List Tasks
•	Call listTasks() on the TaskManager object.
•	Exit
•	Close the Scanner object.
•	Exit the application.
