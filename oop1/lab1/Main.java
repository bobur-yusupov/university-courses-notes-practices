import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private String neptun;
    private List<String> courses = new ArrayList<>();


    public Student(String name, String neptun) {
        this.name = name;
        this.neptun = neptun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeptun() {
        return neptun;
    }

    public void setNeptun(String neptun) {
        this.neptun = neptun;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void enroll(String course) {
        this.courses.add(course);
    }

    public boolean drop(String course) {
        return this.courses.remove(course);
    }
}

class Wizard {
    private String name;
    private String specialization;
    private List<String> spells = new ArrayList<>();

    public Wizard(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String newSpecialization) {
        this.specialization = newSpecialization;
    }

    public void addSpell(String spell) {
        this.spells.add(spell);
    }

    public boolean castSpell(String spell) {
        return this.spells.remove(spell);
    }

    public List<String> getSpells() {
        return this.spells;
    }

}

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Test", "YTAJDI");

        System.out.println(st1.getName());
        System.out.println(st1.getNeptun());

        st1.enroll("math");
        st1.enroll("oop");

        System.out.println(st1.getCourses());

        st1.drop("oop");

        System.out.println(st1.getCourses());



        // Wizard
        Wizard w1 = new Wizard("waseem potter", "Dark");

        System.out.println(w1.getName());
        System.out.println(w1.getSpecialization());
        System.out.println(w1.getSpells());

        w1.addSpell("Expecto Patrona");
        w1.addSpell("Lumios reparo");
        w1.addSpell("Avada kadabra");
        
        System.out.println(w1.getSpells());
    }    
}
