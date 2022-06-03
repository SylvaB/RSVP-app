package com.kenzie.app;

import java.util.Arrays;
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

        //variables
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();
        boolean exitFlag = false;
        String userInput;

        System.out.println("Enter the names. Hit enter on blank line to end.");

        while (!exitFlag){
            userInput = scanner.nextLine();
            if(userInput.equals("")){
                exitFlag = true;
            }
            else {
                nameList.add(userInput);
            }
        }
        StringBuilder outputString = new StringBuilder(String.join(", ",nameList));

        //add "and" depending on how many attendees
        int startIndex = outputString.lastIndexOf(",");
        int endIndex = startIndex + 1;
        if(nameList.size() == 2){
            outputString.replace(startIndex,endIndex," and");
        }
        else if(nameList.size()>2){
            outputString.insert(outputString.lastIndexOf(",")+1," and");
        }



        System.out.println("You have invited: " + outputString);
    }
}
