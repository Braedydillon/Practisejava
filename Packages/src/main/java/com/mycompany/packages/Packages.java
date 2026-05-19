/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.packages;

import java.util.Scanner;

/**
 *
 * @author braed
 */
public class Packages {

    public static void main(String[] args) {
  
        Scanner input = new Scanner(System.in);
        PackageMethods processor = new PackageMethods(); // Calling across classes
        boolean running = true;

        System.out.println("Welcome to the LogiTrack Manager");

        while (running) {
            System.out.println("\nSelect an option:\n1) Ship Packages\n2) Show Status\n3) Quit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            input.nextLine(); // Clear scanner buffer

            switch (choice) {
                case 1:
                    System.out.print("How many packages do you want to enter? ");
                    int numPackages = input.nextInt();
                    input.nextLine(); // Clear buffer

                    for (int i = 0; i < numPackages; i++) {
                        System.out.println("\nEntering Package #" + (i + 1));
                        
                        System.out.print("Enter Content Name (e.g., Tools): ");
                        String name = input.nextLine();
                        
                        System.out.print("Enter Destination Code (e.g., ZA123): ");
                        String dest = input.nextLine();

                        System.out.print("Enter Item Description: ");
                        String desc = input.nextLine();

                        // 1. Logic Check via the external processor class
                        if (processor.isDescriptionValid(desc)) {
                            
                            // 2. Simple Dispatch or Scrap prompt
                            System.out.println("Press 1 to DISPATCH or 2 to SCRAP this shipment:");
                            int shipChoice = input.nextInt();
                            input.nextLine(); // Clear buffer

                            if (shipChoice == 1) {
                                // If they pick 1, generate tracking code and show summary
                                String trackingID = processor.createTrackingID(name, dest);
                                System.out.println("Package successfully captured!");
                                System.out.println(processor.getPackageSummary(trackingID, name, desc));
                            } else {
                                System.out.println("Shipment canceled and scrapped.");
                            }
                        } else {
                            // Error handling message if validation fails
                            System.out.println("Please enter a package description of less than 50 characters.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Feature coming soon...");
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        input.close();
    }
}