public class Greeting {
    public static void main(String[] args) {
        System.console().printf("Enter name: ");
        String name = System.console().readLine();
        System.console().printf("Greeting %s!%s", name, System.lineSeparator());
    }
}