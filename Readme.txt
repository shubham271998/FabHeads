1.To run this file go to Pom.xml file right click and run as a "maven test".
2.This is maven project so You can save the project in system and import in eclipse and save there all the 
dependencies it will automatically download all the dependencies and you will be able to run the project.
3.This automation can run in chrome and firefox because I have download only 2 web drivers but we can run with all 
the browsers with the help of webdrivers(we only have to download the webDrivers).
4.I have implemented the Screenshot functionality so that It can capture at run time.
5.I have implemented the external report as ExtentReport with name of date and time init
check the file (AssignmentTue_Oct_26_22_52_50_IST_2021) It will generate as many time as you want.
6.It involves Testng so that The code will be reusable.

1.DateUtils.java - This function is used in Extent Report so that we can generate the file with date and time 
name everytime.
2.ExtentReportManager.java - This function is implemented to generate the extent report.
3.ScreenShotFunctionality.java - to take the screenshot at run time.
4.WebDriverFactory.java - It will initiate the web Drivers.

5.LoginFunctionalityTest.java - This is the main testing file It uses all the files and implemented the testng and 
extentReport.

6.pom.xml - By saving this file all the dependencies will automatically download and project will able to run.
6.Testng.xml - We can change and add the web browser and screenshot or any data driven file from this file.


STEPS:
Save the folder -> save the pom.xml file -> Right click on pom.xml file and run as maven test.  