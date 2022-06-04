package com.kenzie.app;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Main {

    public static void main(String[] args) {
        // Step 1 - Print out a welcome message and instructions
        // Step 2 - In a loop, collect each attendee name and store it in a list
        // Step 3 - when they enter a blank name, then stop looping
        // Step 4 - Then iterate over the attendee list to create the output string (using StringBuilder!)
        //
        // Note that there are three distinct formats for the output string depending on the number of attendees
        // More than 2 attendees:
        // You have invited: Leslie Knope, April Ludgate, and Ron Swanson
        //
        // Exactly 2 attendees:
        // You have invited: Leslie Knope and Ron Swanson
        // 
        // Only 1 attendee:
        // You have invited: Leslie Knope
        // 
        // Your output should exactly match the way these are formatted with spaces, commas, and the "and"

        // Your Code Here
        System.out.println("Welcome! Who would you like to invite to the party?");
        System.out.println("Enter an attendee name and press Enter.  \n" +
                "Leave the name blank and press enter when you are done.");

        String outputList = "";
        ArrayList<String> listOfNames = new ArrayList<>();

        outputList= formatAttendeeList(listOfNames);

        System.out.println("You have invited: " + outputList);
    }
        public static String formatAttendeeList(ArrayList<String> listOfNames) {
            Scanner scanner = new Scanner(System.in);
            boolean exitFlag = false;
            String userInput;
            while (!exitFlag){
                userInput = scanner.nextLine();
                if(userInput.equals("")){
                    exitFlag = true;
                }
                else {
                    listOfNames.add(userInput);
                }
            }
            StringBuilder outputString = new StringBuilder(String.join(", ",listOfNames));
            //add "and" depending on how many attendees
            int startIndex = outputString.lastIndexOf(",");
            int endIndex = startIndex + 1;
            if(listOfNames.size() == 2){
                outputString.replace(startIndex,endIndex," and");
            }
            else if(listOfNames.size()>2){
                outputString.insert(outputString.lastIndexOf(",")+1," and");
            }

            String finalString = outputString.toString();
            return finalString;
        }
}
