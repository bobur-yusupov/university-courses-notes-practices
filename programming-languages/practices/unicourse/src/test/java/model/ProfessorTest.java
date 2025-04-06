package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ProfessorTest {
    private Professor professor;
    @BeforeEach
    public void createProfessor() {
        this.professor = new Professor(1, "John", "Doe", "Mechanical Engineering");
    }

    @Test
    public void testGetId() {
        assertEquals(1, this.professor.getIdInt());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", this.professor.getFirstNameString());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", this.professor.getLastNameString());
    }

    @Test
    public void testGetDepartment() {
        assertEquals("Mechanical Engineering", this.professor.getDepartment());
    }

    @Test
    public void testSetFirstName() {
        this.professor.setFirstNameString("Jane");

        assertEquals("Jane", this.professor.getFirstNameString());
    }

    @Test
    public void testSetLastName() {
        this.professor.setLastNameString("Smith");

        assertEquals("Smith", this.professor.getLastNameString());
    }

    @Test
    public void testSetDepartment() {
        this.professor.setDepartment("Electrical Engineering");

        assertEquals("Electrical Engineering", this.professor.getDepartment());
    }
}
