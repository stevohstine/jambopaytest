INSTALL METHOD 1: 

Install and configure android studio in your machine.
With git installed, pull the code to your local host.
Without git installed, download a zip file of the repository to your machine.
Extract the zip file and open with android studio.
After gradle has synced, Connect your phone and select it on android studio as the default device.
Run the project.
The app should install successfully


INSTALL METHOD 2:: 

If you are having trouble setting up the code in android studio, download and install the .apk file using the link below
https://github.com/stevohstine/jambopaytest/releases/download/untagged-38559dc101e5659f092d/JamboPay.apk


HOW TO USE THE APP:: 

Start the app after installation
Enter a number between 0 to 5
Click on submit with 5 seconds interval untill you see a toast message saying "Correct!! Numbers Match"
The numbers that match will be displayed in a recyclerview. 
You will be able to see more details about the numbers that match including the trial number.
Keep repeating the same procedure and see how many times you have to submit a number before it gets a match


LOGIC USED::  

After submitting a number, the app reads the number, generates a random number between 0 and 5, then compares if the two numbers match.
If the numbers match you get a toast message "Correct!! Numbers Match"
If the numbers dosent match, you get a message "Numbers doesn't match"
After the numbers match, the record is added to a List data structure and is displayed in the recyclerView.
Data saved include:
Matching numbers, Computation time in Milliseconds,Number of trials
NB: Data is not parmanently saved, it is retained during the app session.
I decided to use a range of between 0 to 5 to increase the chances of matching a number

TOOLS::  

Android studio
Programming Language used: Android Native Kotlin
