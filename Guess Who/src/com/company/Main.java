package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public Main(){

    }
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
        public void run () {
//Game Starts. Set gameOn to true. Display welcome message.
            Boolean gameOn = true;
            System.out.println("Welcome to Guess Who, here are list of profiles.");
            //<editor-fold desc="Create Feature Name List and Feature Option List">
            List<String> featureNameList = new ArrayList<>();
            featureNameList.add("hair style");
            featureNameList.add("hair color");
            featureNameList.add("eye color");
            featureNameList.add("gender");

            List<String> hairStyleOptions = new ArrayList<>();
            hairStyleOptions.add("curly");
            hairStyleOptions.add("straight");

            List<String> hairColorOptions = new ArrayList<>();
            hairColorOptions.add("blond");
            hairColorOptions.add("brown");
            hairColorOptions.add("red");

            List<String> eyeColorOptions = new ArrayList<>();
            eyeColorOptions.add("blue");
            eyeColorOptions.add("brown");

            List<String> genderOptions = new ArrayList<>();
            genderOptions.add("female");
            genderOptions.add("male");
            //</editor-fold>

//Create Profile List and Profile Map
            List<Profile> profileList = new ArrayList<>();
            createProfileList(profileList);
            Map<String,Profile> profileMap = new HashMap<>();
            for (Profile searchProfile:profileList){
                profileMap.put(searchProfile.getName().toLowerCase(),searchProfile);
            }

//Generate Target Profile
            Random targetProfile = new Random();
            Profile randomProfile = profileList.get(targetProfile.nextInt(profileList.size()));
            //System.out.println("Your target file is: "+randomProfile.printProfile());
            Scanner userInput = new Scanner(System.in);

//If it last profiles guessed is wrong, game over.
            if (countAvailable(profileList)==0){
                System.out.println("You Lost! Game Over!");
            }
//If there are still multiple profiles left, start guessing process.
            while (countAvailable(profileList) > 0 & gameOn) {
                printProfiles(profileList);
                System.out.println("Do you have a guess? Y/N");
                String guessOrNot = userInput.nextLine().toUpperCase();
//Player has a guess. Compare to the target profile.
                if (guessOrNot.equals("Y")) {
                    System.out.println("Who is your guess?");
                    //printProfiles(profileList);
                    String guessProfile = userInput.nextLine().toLowerCase();
                    if (!profileMap.containsKey(guessProfile)){
                        System.out.println("This profile does not exist. Please select from displayed profiles.");
                    } else {
//Guess is correct, game over.
                        if (guessProfile.equals(randomProfile.getName().toLowerCase())) {
                            System.out.println("Congratulations! You Won The Game!");
                            gameOn = false;
                        } else {
//Guess is wrong. Start feature selection process.
                            for (Profile availableAdjust : profileList) {
                                availableAdjust = profileMap.get(guessProfile);
                                availableAdjust.setIsAvailable("NO");
                            }
                            if (countAvailable(profileList)==1){
                                System.out.println("You Lost! Game Over!");
                                gameOn=false;
                                break;
                            } else {
                                printProfiles(profileList);
                                System.out.println("So Close! Maybe try to sort by some features? Please select features from feature list. ");
                                displayFeatureName(featureNameList);
                                String guessFeature = userInput.nextLine();
//Select from feature names.
                                switch (guessFeature) {
//Select feature 1: Hair Style.
                                    case "1":
                                        Map<String, String> hairStyleMap = new HashMap<>();
                                        hairStyleMap.put("1", "curly");
                                        hairStyleMap.put("2", "straight");

                                        System.out.println("Please select hair style feature: ");
                                        displayHairStyleFeature(hairStyleOptions);
                                        System.out.println("Please choose feature options: ");
                                        String guessHairStyleOption = userInput.nextLine().toLowerCase();

                                        if (randomProfile.getHairStyle().equals(hairStyleMap.get(guessHairStyleOption))) {
                                            for (Profile availableAdjust : profileList) {
                                                if (!availableAdjust.getHairStyle().equals(hairStyleMap.get(guessHairStyleOption))) {
                                                    availableAdjust.setIsAvailable("NO");
                                                }
                                            } System.out.println(" You selected a correct feature! Nice job! Keep the good work!'\n");
                                        } else {
                                            for (Profile availableAdjust : profileList) {
                                                if (availableAdjust.getHairStyle().equals(hairStyleMap.get(guessHairStyleOption))) {
                                                    availableAdjust.setIsAvailable("NO");
                                                }
                                            } System.out.println("You selected wrong feature.");
                                        }
                                        break;
//Select feature 2: Hair Color.
                                    case "2":
                                        Map<String, String> hairColorMap = new HashMap<>();
                                        hairColorMap.put("1", "blond");
                                        hairColorMap.put("2", "brown");
                                        hairColorMap.put("3", "red");

                                        System.out.println("Please select hair color feature: ");
                                        displayHairColorFeature(hairColorOptions);
                                        System.out.println("Please choose feature options: ");
                                        String guessHairColorOption = userInput.nextLine().toLowerCase();

                                        if (randomProfile.getHairColor().equals(hairColorMap.get(guessHairColorOption))) {

                                            for (Profile availableAdjust : profileList) {
                                                if (!availableAdjust.getHairColor().equals(hairColorMap.get(guessHairColorOption))) {
                                                    availableAdjust.setIsAvailable("NO");
                                                }
                                            }System.out.println(" You selected a correct feature! Nice job! Keep the good work!'\n");

                                        } else {

                                            for (Profile availableAdjust : profileList) {
                                                if (availableAdjust.getHairColor().equals(hairColorMap.get(guessHairColorOption))) {
                                                    availableAdjust.setIsAvailable("NO");
                                                }
                                            }System.out.println("You selected wrong feature. \n");
                                        }
                                        break;
//Select feature 3: Eye Color.
                                    case "3":
                                        Map<String, String> eyeColorMap = new HashMap<>();
                                        eyeColorMap.put("1", "blue");
                                        eyeColorMap.put("2", "brown");

                                        System.out.println("Please select eye color feature: ");
                                        displayEyeColorFeature(eyeColorOptions);
                                        System.out.println("Please choose feature options: ");
                                        String guessEyeColorOption = userInput.nextLine().toLowerCase();
                                        if (randomProfile.getEyeColor().equals(eyeColorMap.get(guessEyeColorOption))) {

                                            for (Profile availableAdjust : profileList) {
                                                if (!availableAdjust.getEyeColor().equals(eyeColorMap.get(guessEyeColorOption))) {
                                                    availableAdjust.setIsAvailable("NO");
                                                }
                                            }System.out.println(" You selected a correct feature! Nice job! Keep the good work!'\n");
                                        } else {

                                            for (Profile availableAdjust : profileList) {
                                                if (availableAdjust.getEyeColor().equals(eyeColorMap.get(guessEyeColorOption))) {
                                                    availableAdjust.setIsAvailable("NO");
                                                }
                                            }System.out.println("You selected wrong feature. \n");
                                        }
                                        break;
//Select feature 4: Gender.
                                    case "4":
                                        Map<String, String> genderMap = new HashMap<>();
                                        genderMap.put("1", "female");
                                        genderMap.put("2", "male");

                                        System.out.println("Please select gender feature: ");
                                        displayGenderFeature(genderOptions);
                                        System.out.println("Please choose feature options: ");
                                        String guessGenderOption = userInput.nextLine().toLowerCase();
                                        if (randomProfile.getGender().equals(genderMap.get(guessGenderOption))) {

                                            for (Profile availableAdjust : profileList) {
                                                if (!availableAdjust.getGender().equals(genderMap.get(guessGenderOption))) {
                                                    availableAdjust.setIsAvailable("NO");
                                                }
                                            }System.out.println(" You selected a correct feature! Nice job! Keep the good work!'\n");
                                        } else {

                                            for (Profile availableAdjust : profileList) {
                                                if (availableAdjust.getGender().equals(genderMap.get(guessGenderOption))) {
                                                    availableAdjust.setIsAvailable("NO");
                                                }
                                            }System.out.println("You selected wrong feature. \n");
                                        }
                                        break;
                                    default:
                                        System.out.println("Selection is invalid. Please select from provided selections.");
                                        break;
                                }
                            }
                        }
                    }
//Player does not have a guess. Start feature selection process.
                } else if (guessOrNot.equals("N")){
                    System.out.println("Select by features might help. Please select features from feature list. ");
                    displayFeatureName(featureNameList);
                    String guessFeature = userInput.nextLine();
                    switch (guessFeature) {
//Select feature 1: Hair Style.
                        case "1":
                            Map<String,String> hairStyleMap = new HashMap<>();
                            hairStyleMap.put("1","curly");
                            hairStyleMap.put("2","straight");

                            System.out.println("Please select hair style feature: ");
                            displayHairStyleFeature(hairStyleOptions);
                            System.out.println("Please choose feature options: ");
                            String guessHairStyleOption = userInput.nextLine().toLowerCase();

                            if (randomProfile.getHairStyle().equals(hairStyleMap.get(guessHairStyleOption))) {

                                for (Profile availableAdjust : profileList) {
                                    if (!availableAdjust.getHairStyle().equals(hairStyleMap.get(guessHairStyleOption))) {
                                        availableAdjust.setIsAvailable("NO");
                                    }
                                }System.out.println(" You selected a correct feature! Nice job! Keep the good work!'\n");
                            } else {

                                for (Profile availableAdjust : profileList) {
                                    if (availableAdjust.getHairStyle().equals(hairStyleMap.get(guessHairStyleOption))) {
                                        availableAdjust.setIsAvailable("NO");
                                    }
                                }System.out.println("You selected wrong feature. \n");
                            }
                            break;
//Select feature 2: Hair Color.
                        case "2":
                            Map<String,String> hairColorMap = new HashMap<>();
                            hairColorMap.put("1","blond");
                            hairColorMap.put("2","brown");
                            hairColorMap.put("3","red");

                            System.out.println("Please select hair color feature: ");
                            displayHairColorFeature(hairColorOptions);
                            System.out.println("Please choose feature options: ");
                            String guessHairColorOption = userInput.nextLine().toLowerCase();

                            if (randomProfile.getHairColor().equals(hairColorMap.get(guessHairColorOption))) {

                                for (Profile availableAdjust : profileList) {
                                    if (!availableAdjust.getHairColor().equals(hairColorMap.get(guessHairColorOption))) {
                                        availableAdjust.setIsAvailable("NO");
                                    }
                                }System.out.println(" You selected a correct feature! Nice job! Keep the good work!'\n");
                            } else {

                                for (Profile availableAdjust : profileList) {
                                    if (availableAdjust.getHairColor().equals(hairColorMap.get(guessHairColorOption))) {
                                        availableAdjust.setIsAvailable("NO");
                                    }
                                }System.out.println("You selected wrong feature. \n");
                            }
                            break;
//Select feature 3: Eye Color.
                        case "3":
                            Map<String,String> eyeColorMap = new HashMap<>();
                            eyeColorMap.put("1","blue");
                            eyeColorMap.put("2","brown");

                            System.out.println("Please select eye color feature: ");
                            displayEyeColorFeature(eyeColorOptions);
                            System.out.println("Please choose feature options: ");
                            String guessEyeColorOption = userInput.nextLine().toLowerCase();
                            if (randomProfile.getEyeColor().equals(eyeColorMap.get(guessEyeColorOption))) {

                                for (Profile availableAdjust : profileList) {
                                    if (!availableAdjust.getEyeColor().equals(eyeColorMap.get(guessEyeColorOption))) {
                                        availableAdjust.setIsAvailable("NO");
                                    }
                                }System.out.println(" You selected a correct feature! Nice job! Keep the good work!'\n");
                            } else {

                                for (Profile availableAdjust : profileList) {
                                    if (availableAdjust.getEyeColor().equals(eyeColorMap.get(guessEyeColorOption))) {
                                        availableAdjust.setIsAvailable("NO");
                                    }
                                }System.out.println("You selected wrong feature. \n");
                            }
                            break;
//Select feature 4: Gender.
                        case "4":
                            Map<String,String> genderMap = new HashMap<>();
                            genderMap.put("1","female");
                            genderMap.put("2","male");

                            System.out.println("Please select gender feature: ");
                            displayGenderFeature(genderOptions);
                            System.out.println("Please choose feature options: ");
                            String guessGenderOption = userInput.nextLine().toLowerCase();
                            if (randomProfile.getGender().equals(genderMap.get(guessGenderOption))) {

                                for (Profile availableAdjust : profileList) {
                                    if (!availableAdjust.getGender().equals(genderMap.get(guessGenderOption))) {
                                        availableAdjust.setIsAvailable("NO");
                                    }
                                }System.out.println(" You selected a correct feature! Nice job! Keep the good work!'\n");
                            } else {

                                for (Profile availableAdjust : profileList) {
                                    if (availableAdjust.getGender().equals(genderMap.get(guessGenderOption))) {
                                        availableAdjust.setIsAvailable("NO");
                                    }
                                }System.out.println("You selected wrong feature. \n");
                            }
                            break;
                        default:
                            System.out.println("Selection is invalid. Please select from provided selections.");
                            break;
                    }
                } else {
//If input for selection is invalid, bring back to guess selection.
                    System.out.println("Selection is invalid. Please select from provided options.");
                }
            }
        }

    public void printProfiles(List<Profile>profileList){
        System.out.println("******************************** Available Profiles ******************************************");
        String hairStyleColumn = "           Hair Style: ";
        String hairColorColumn = "          Hair Color: ";
        String eyeColorColumn = "       Eye Color: ";
        String genderColumn = "        Gender: ";
        for (Profile updateProfile : profileList){
            if (updateProfile.getIsAvailable().equals("YES")) {
                System.out.println("Name: "+updateProfile.getName()+hairStyleColumn.substring(updateProfile.getName().length())
                        +updateProfile.getHairStyle()+hairColorColumn.substring(updateProfile.getHairStyle().length())
                        +updateProfile.getHairColor()+eyeColorColumn.substring(updateProfile.getHairColor().length())
                        +updateProfile.getEyeColor() +genderColumn.substring(updateProfile.getEyeColor().length())
                        +updateProfile.getGender());
            }
        }
    }

    public int countAvailable(List<Profile> profileList){
        int availableCount = 0;
        for (Profile availableAppears : profileList){
            if (availableAppears.getIsAvailable().equals("YES")){
                availableCount++;
            }
        }
        return availableCount;
    }

    public void displayFeatureName(List<String>featureNameList){
        System.out.println();
        System.out.println("Features");
        System.out.println("1. "+featureNameList.get(0));
        System.out.println("2. "+featureNameList.get(1));
        System.out.println("3. "+featureNameList.get(2));
        System.out.println("4. "+featureNameList.get(3));
    }

    public void displayHairStyleFeature(List<String>hairStyleOptions){
        System.out.println();
        System.out.println("Hair Style: ");
        System.out.println("1) "+hairStyleOptions.get(0));
        System.out.println("2) "+hairStyleOptions.get(1));
    }

    public void displayHairColorFeature(List<String>hairColorOptions){
        System.out.println();
        System.out.println("Hair Color: ");
        System.out.println("1) "+hairColorOptions.get(0));
        System.out.println("2) "+hairColorOptions.get(1));
        System.out.println("3) "+hairColorOptions.get(2));
    }

    public void displayEyeColorFeature(List<String>eyeColorOptions){
        System.out.println();
        System.out.println("Eye Color: ");
        System.out.println("1) "+eyeColorOptions.get(0));
        System.out.println("2) "+eyeColorOptions.get(1));
    }

    public void displayGenderFeature(List<String>genderOptions){
        System.out.println();
        System.out.println("Gender: ");
        System.out.println("1) "+genderOptions.get(0));
        System.out.println("2) "+genderOptions.get(1));
    }

    public void createProfileList(List<Profile> profileList){
        File inputFile = new File("Guess Who/src/profileInformation.txt");
        try (Scanner textFile = new Scanner(inputFile)){
            while (textFile.hasNextLine()){
                String line = textFile.nextLine();
                String [] lineParts = line.split("\\|");
                Profile profile = new Profile();
                profile.setIsAvailable(lineParts[0]);
                profile.setName(lineParts[1]);
                profile.setHairStyle(lineParts[2]);
                profile.setHairColor(lineParts[3]);
                profile.setEyeColor(lineParts[4]);
                profile.setGender(lineParts[5]);
                profileList.add(profile);
            }
        } catch (FileNotFoundException e){
            System.out.println("This file could not be found.");
        }
    }
}
