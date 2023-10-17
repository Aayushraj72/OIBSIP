package OIBSIP;

import java.util.Random;
import java.util.Scanner;

public class Task2_Number_Guessing_Game {

   public static void main(String[] args) {
      try (Scanner sc = new Scanner(System.in)) {
         System.out.println("\n\n\n\n");
         System.out.println(
               "------------------------------------------------------------------------------------------------------------------");
         System.out.println(" \t\t\t\t\t\tNUMBER GUESSING GAME");
         System.out.println(
               "------------------------------------------------------------------------------------------------------------------");
         System.out.println("\t\t\t\t\t\n");
         
         // Rules for playing the game
         System.out.println("\t\t\t\t\t\t  ! INSTRUCTIONS ! \n\t\t\t\t\t\t___________________");
         System.out.println("\t\t\t\t\t");
         System.out.println(
               "Step 1. This Game generates a random number beetween 1 - 100 and you will have to guess it correctly.");
         System.out.println("Step 2. There will be in total 10 rounds.");
         System.out.println(
               "Step 3. For each Correct guess, your score will be increased by 10 points and you will enter in next level.");
         System.out.println(
               "Step 4. If you score 30 points in this 10 rounds you will be declared the winner, Otherwise you will lose.");
         System.out.println("Step 5. To still continue playing the game press 'y' or 'Y'.");
         System.out.println("Step 6. To exit out of the game press 'n' or 'N'.\n\n");
         System.out.println("Let's begin the game : \n\n");

         // Variable declaration
         int guess_Number; // it will contain user input.
         int round;
         char ch;
         int points = 0;
         Random random = new Random();

         // it will generate a random number

         int random_Number = random.nextInt(100) + 1;
         System.out.println("Generated Number : "+random_Number+"\n");

         // logics
         for (round = 1; round <= 10; round++) {
            System.out.println();
            System.out.println("Round " + round);
            System.out.println("Your Score :" + points);
            System.out.print("Enter your guess : ");
            guess_Number = sc.nextInt();

            // Condition
            if (guess_Number == random_Number) {
               points = points + 10;
               System.out.println("You Gussed right");
               System.out.println("Your score " + points);
               // it will generate again a new random number after guessing correct number.
               random_Number = random.nextInt(100) + 1;
               System.out.println();
              System.out.println("Generated number :"+random_Number+"\n");
               


            } else {
               if (guess_Number < random_Number && guess_Number > 0) {
                  System.out.println("You guesed lower than generated number."+"\n");

               } 
               
               else if (guess_Number > random_Number && guess_Number <= 100 ) {
                  System.out.println("You guessed Higher than generated number."+"\n");

               } 
               else if (guess_Number > 100) {
                  System.out.println("Please guess a number between 1 to 100."+"\n");
                  
               }
               else{
                  System.out.println("Please enter a valid Number");
               }
            
            
            }
            if (round == 10) {
               if (points >= 30) {
                  System.out.println("HURREY, YOU WON THE GAME");
                  System.out.println("Score = " + points);
                  System.out.println(
                        "Congratulatios !\nYou Scored :" + points + "\n\nThanks for playing Game.\nEnding Game....");
                        System.out.println();
                  break;
               } else {
                  System.out.println("Your score is less than 30 points.\n\nYou Lose The Game.\nTry Again....."+"\n");
                  break;
               }
            }
            System.out.print("Press 'y' OR 'Y' to continue otherwise  press 'n' or 'N' to exit : ");
            ch = sc.next().charAt(0);
            System.out.println();
            if (ch == 'y' || ch == 'Y')
               continue;
            else {
               System.out.println("Thanks for Playing.\nEnding Game....."+"\n");
               break;

            }
         }
      }

   }
}
