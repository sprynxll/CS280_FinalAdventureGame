/*
 * Application Title: Adventure Game
 * Author: Madison McDonald
 * CS 285, Data Structures
 * Date: April 23, 2023
 * Purpose: This program is a text-based adventure game that allows the user to play as
            a character and run through a series of choices leading them through the 
            adventure based on the choices they make along the way.
 */

package cs280_final_adventure_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CS280_Final_Adventure_Game {

    public static void main(String[] args) {
        System.out.println("Text-Based Adventure Game");
        System.out.println("that allows you to explore through a series of rooms.");
        System.out.println("");
        //HashMap for all of the rooms
        HashMap<String, String> rooms = new HashMap<String, String>();
        rooms.put("beginning", "You suddenly appear in a random room. There is a door to your right.");
        rooms.put("right", "You go into a room with a window and a bed. Must be a bedroom...");
        rooms.put("left", "You go into a room with a toaster and a stove. Must be a kitchen...");
        rooms.put("forwards", "You go into a room with a couch and a TV. Must be a living room...");

        //set the current room to be named "beginning"
        //this is the room the user will start off in when the program is run.
        String currentRoom = "beginning";
        Scanner scanner = new Scanner(System.in);

        //use a while loop to allow the user to traverse through the rooms.
        while (true) {
            //shows the user's current room.
            System.out.println(rooms.get(currentRoom));
            //asks the user what they want to do (which direction they want to go).
            //uses that unput to change the room the user is in.
            System.out.print("What do you want to do? ");
            System.out.println("Choose a direction (left, right, or forward)");
            String input = scanner.nextLine();

            //if the user enters "quit" the program ends.
            if (input.equals("quit")) {
                System.out.println("Great job exploring!");
                break;
            }

            //if the user chooses a direction, they then go that direction.
            //if the user enters left, the current room is left (the kitchen).
            if (input.equals("left")) {
                currentRoom = "left";
            //if the user enters right, the current room is right (the bedroom).
            } else if (input.equals("right")) {
                currentRoom = "right";
            //if the user enters forward, the current room is forward (the living room).
            } else if (input.equals("forward")) {
                currentRoom = "forward";
            }
            //if the user enters a room that does not exist...
            else {
                System.out.println("There is not a room in this direction. Try entering a different direction instead.");
                
            }
            
//ITEMS IN ROOMS SECTION
        //Hashmap that has the names of all the rooms and the items within each room.
        HashMap<String, ArrayList<String>> items = new HashMap<String, ArrayList<String>>();
        items.put("kitchen", new ArrayList<String>(Arrays.asList("napkin", "cup", "plate")));
        items.put("living room", new ArrayList<String>(Arrays.asList("TV", "remote", "phone")));
        items.put("bedroom", new ArrayList<String>(Arrays.asList("blanket", "hair brush", "pillow")));

        //prints out the items found within each room (does not include the direction for these rooms though).
        for (String room : items.keySet()) {
            //prints out the items in a list and calls out the room name
            System.out.println("The items in the " + room + " are ");
            //ArrayList of the room items in each room.
            ArrayList<String> roomItems = items.get(room);
            for (String item : roomItems) {
                //lists out each item in the room in a bulleted style list
                System.out.println("*" + item);
            }
        }
            //user enters in room name to get list of items in that room.
            System.out.print("Enter a room name to see items (living room, kitchen, bedroom). ");
            String room = scanner.nextLine();
            //if the user enters quit, the program ends still.
            if (room.equals("quit")) {
                break;
            //if user enters room that does not exist, prints out "That room does not exist."
            } else if (!items.containsKey(room)) {
                System.out.println("That room does not exist.");
            //otherwise prints out items in that room
            } else {
                ArrayList<String> roomItems = items.get(room);
                //if the room has no more items:
                if (roomItems.isEmpty()) {
                    System.out.println("There are no items in that room.");
                //otherwise prints out what the items in that specific room are in a comma sentence.
                } else {
                    System.out.println("The items in " + room + " are: " + String.join(", ", roomItems));
                }
            }
        } //END OF WHILE LOOP   
    } //END OF MAIN METHOD
} //END OF CLASS PROGRAM
