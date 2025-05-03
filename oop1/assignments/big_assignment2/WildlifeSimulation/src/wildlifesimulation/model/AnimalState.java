package wildlifesimulation.model;

/*
 * Represents the state of an animal in the wildlife simulation.
 * Each state can influence the animal's behavior and interactions.
 */

public enum AnimalState {
    CALM,
    ALERTED,
    DEFENSIVE,
    CURIOUS,
    AGGRESSIVE,
    FLEEING,
    ATTACKING,
    STABILIZED,
    CRITICAL,
}
