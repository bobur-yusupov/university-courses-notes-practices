package petshop.pet;

import petshop.State;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Pet implements Runnable {
    protected final String name;
    protected final int age;
    protected State state;
    protected boolean needsFood, needsWater, isSelected;

    public Pet(String name, int age, State state) {
        this.name = name;
        this.age = age;
        this.state = state;
    }

    public abstract int getPrice();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public synchronized State getState() {
        return state;
    }

    public synchronized boolean isNeedsFood() {
        return needsFood;
    }

    public synchronized boolean isNeedsWater() {
        return needsWater;
    }

    public synchronized boolean isSelected() {
        return isSelected;
    }

    public synchronized boolean select() {
        if (isSelected) {
            return false;
        }
        isSelected = true;
        return true;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                updateCondition();
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5001));
            }
        } catch (InterruptedException e) {
            // simulation is over: restore the flag and let the thread end
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return name + " (" + age + " years old)";
    }

    private synchronized void updateCondition() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        State[] states = State.values();
        state = states[random.nextInt(states.length)];
        needsFood = random.nextBoolean();
        needsWater = random.nextBoolean();
    }
}
