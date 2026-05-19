/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.packages;

/**
 *
 * @author braed
 */
public class PackageMethods {


    // Manipulates string data inputs to return a formatted tracking string code
    public String createTrackingID(String contentName, String destinationCode) {
        if (contentName == null || destinationCode.length() < 2) {
            return "INVALID";
        }
        
        // Takes the first 2 characters of the destination and changes them to uppercase
        String prefix = destinationCode.substring(0, 2).toUpperCase();
        
        // Combines prefix with the length of the content string name
        return prefix + ":" + contentName.length();
    }

    // Handles the character limit validation rule check
    public boolean isDescriptionValid(String description) {
        // Returns true only if description is under the length limit
        return description != null && description.length() <= 50; 
    }

    // Returns a compiled, formatted summary data row
    public String getPackageSummary(String id, String name, String desc) {
        return "Tracking ID: " + id + " | Contents: " + name + " | Details: " + desc;
    }
}