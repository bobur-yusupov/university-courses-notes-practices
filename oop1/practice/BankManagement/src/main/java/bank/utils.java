package bank;

class UniqueID {
    private static int id = 0;

    public static int getID() {
        return id++;
    }
}

public class utils {
    public static String generateID() {
        return String.valueOf(1000 + UniqueID.getID());
    }

    public static boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }
}
