### Issue Tracker Analysis

    This problem involves reading issues stored in a CSV file and performing search and analysis on the data.

#### Input Files:

**CAUTION : Do not modify the data present in the input files**

The input files are located in the 'src/data' folder of this project. Given below are the details 
of the two csv files 

 - **issues.csv :** 

File contains issue details in the below order

	IssueId
	Issue Summary
	created Date                (in format dd/mm/yyyy)
	Expected Resolution Date    (in format dd/mm/yyyy)
	Priority                    (can have values HIGH, MEDIUM, LOW)
	Status                      (can have values OPEN, CLOSED)
	Issue Assigned to           (Employee ID, This employee id should be present in employees file ) 

    Sample Data:

    IS001,issue summary1,10/04/2019,17/04/2019,HIGH,CLOSED,101

- **employees.csv :** 

File contains the employee details in the below order

	Employee Id
	Employee Name
	Location of Employee

    Sample Data:

    101,Sunil,Bangalore

#### Project contents and structure

This project contains the boilerplate code for the solution.  The detailed instructions 
to arrive at the solution are present in the respective source files. Participant needs 
to read the instruction given in the boilerplate code and complete the solution

The project is divided in to two layers. Repository layer and Service Layer
 - Repository layer : package 'com.learn.IssueTracker.repository'.
    - classes/interfaces in this package will be used to read the files  and 
      store them in a Collection
    - Utility class to parse the String data in to Issue and Employee object

 - Service Layer : package 'com.learn.IssueTracker.service'
   - classes/interfaces in this package will be used to analyze the data and provide information

Other packages:
- com.learn.IssueTracker.model : contains model classes
- com.learn.IssueTracker.exceptions : contains Custom exceptions
- com.learn.issueTracker.test : Contains Test classes for testing minimum functionality required in the solution. 
      (The evaluation tests which will run after the project submission, will test the complete requirements, as per the detailed instructions )


**Note : The Solution provided by the participant should use all the java 8 features like Streams, Lambda expressions, Collectors, Optional, NIO etc.**