package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Welcome to Guess Who, here are list of profiles");

    Profile olivia = new Profile("YES","Olivia", "curly",
            "brown", "blue", "female");
    Profile emma = new Profile("YES", "Emma", "straight", "red",
            "brown", "female");
    Profile ava = new Profile("YES","Ava", "curly","blond",
                "brown","female");
    Profile charlotte = new Profile("YES","Charlotte","straight","blond",
                "blue","female");
    Profile sophie = new Profile("YES","Sophie","curly","brown",
                "blue","female");
    Profile james = new Profile("YES","James","straight","red",
            "brown","male");
    Profile ben = new Profile("YES","Ben","curly","red",
            "brown", "male");
    Profile will = new Profile("YES","Will","straight","blond",
            "blue","male");
    Profile david = new Profile("YES","David","curly","brown",
            "brown","male");
    Profile chris = new Profile("YES","Chis","straight","blond",
            "blue","male");
    List<Profile> profileList = new ArrayList<>();
        profileList.add(olivia);
        profileList.add(emma);
        profileList.add(ava);
        profileList.add(charlotte);
        profileList.add(sophie);
        profileList.add(james);
        profileList.add(ben);
        profileList.add(will);
        profileList.add(david);
        profileList.add(chris);

        for (Profile showProfile : profileList) {
            showProfile.printProfile();
        }

        //Create Features
        List<String> hairStyleOptions = new ArrayList<>();
        hairStyleOptions.add("curly");
        hairStyleOptions.add("straight");
        Feature hairStyle = new Feature("hair style", hairStyleOptions);

        List<String> hairColorOptions = new ArrayList<>();
        hairColorOptions.add("blond");
        hairColorOptions.add("brown");
        hairColorOptions.add("red");
        Feature hairColor = new Feature("hair color", hairColorOptions);

        List<String> eyeColorOptions = new ArrayList<>();
        eyeColorOptions.add("blue");
        eyeColorOptions.add("brown");
        Feature eyeColor = new Feature("eye color", eyeColorOptions);

        List<String> genderOptions = new ArrayList<>();
        genderOptions.add("female");
        genderOptions.add("male");
        Feature gender = new Feature("gender", genderOptions);

        //Set Target Profile
        Random targetProfile = new Random();
//        int randomProfile = profileList.get(targetProfile.nextInt(profileList.size()));


//        Scanner userInput = new Scanner(System.in);
//        System.out.println("Do you have a guess? Y/N");
//        String guessOrNot = userInput.nextLine();
//
//        if (guessOrNot.equalsIgnoreCase("Y")){
//            System.out.println("Who is your guess?");
//            String guessProfile = userInput.nextLine();
//            if (guessProfile.equalsIgnoreCase())
//        }
    }

}
