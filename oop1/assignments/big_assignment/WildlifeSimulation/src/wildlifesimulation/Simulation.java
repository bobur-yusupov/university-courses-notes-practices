package wildlifesimulation;

import wildlifesimulation.model.Animal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Simulation {
    public static void main(String[] args) {
        // Read animal, ranger, habitat and vehicle data from separate files

        try {
            File animalFile = new File("./animals.txt");
            BufferedReader animalReader = new BufferedReader(new FileReader(animalFile.getAbsolutePath()));
            System.out.println(animalReader.lines());
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
    
}
