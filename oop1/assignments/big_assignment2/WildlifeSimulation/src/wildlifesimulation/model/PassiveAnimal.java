/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wildlifesimulation.model;

/**
 *
 * @author User
 */
public class PassiveAnimal extends Temperament {
    @Override
    public AnimalState getAnimalState() {
        return AnimalState.ALERTED;
    }
}
