## Computar Science Dossiar

# Todo

* Output
	* Choose a file/directory
	* Print Patients Dialog
	* Pick which patients to print
		* Search 
		* Filter
		* Priority Queue
* Patient List
	* Search
		* Dynamically repopulating the list based on a search
		* Search options, such as which field, full search, filter based on certain categories, etc.
	* Filter
	* Priority Queue
		* Possibly automatic based on BMI
		* Alternatively set the priority of a patient
* Help Area
	* Just some basics of what you can do with the app and such.
* GUI
	* Need to make it pretty with pictures and stuff
* Get rid of the menu component of the new patient dialog, it serves no purpose
	
# Organization
 
I guess you could call this app MVH, whereas the M is model the V is view and the H is helper. There aren't
really controllers in the sense that the apps controllers are embedded within the views. I guess this is more so
a testament to the nature of SWING than the structure of the app though. 

* Models
	* Person
		* All of the basic stuff a person does
	* Patient
		* Extends person, probably need a serialize function or something
* Views
	* PatientView
		* Main view of the application, has all the patients listed as well as the ability to add more and manipulate things in a bunch of ways.
	* PatientDialog
		* For creating new patients
	* SearchDialog
		* For searching for patients
	* SavePatientDialog
		* For saving patients to a file
	* SearchDialog
		* For searching for patients
	* SearchResultsDialog
		* For showing a table of search results if there are multiple occurances
		 
* Controllers
	* Database
		* File IO
		* Basically the Database
	* Diagnosis
		* Anything related to calculations for the patient such as BMI and MAP
	* Output
		* Pick where to save stuff
		* Make new folders/files
		* Print directly
		* Upload presaved patient files
	* Index
		* Create an index of patients instead of realing on the arraylist for searching and sorting
		
# Due Dates:

		| Requirment | Decription | Pass | Fail | Test Case # |
		| ---------- | ---------- | ---- | ---- | ----------- |
		| Split Fn	 | split dat  | yes  | no   | case 5	  |
		