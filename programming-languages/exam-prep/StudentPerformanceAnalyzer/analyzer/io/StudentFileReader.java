package analyzer.io;

import java.io.*;
import java.nio.file.Path;
import java.lang.AutoCloseable;

import analyzer.student.StudentCollection;
import analyzer.student.Student;

public class StudentFileReader implements AutoCloseable {
    private final BufferedReader reader;
    private final String delimiter;

    public StudentFileReader(Path path) throws IOException {
        this(path, ",");
    }

    public StudentFileReader(File file) throws IOException {
        this(file.toPath(), ",");
    }

    public StudentFileReader(Path path, String delimiter) throws IOException {
        this.reader = new BufferedReader(new FileReader(path.toFile()));
        this.delimiter = delimiter;
    }

    public StudentFileReader(File file, String delimiter) throws IOException {
        this(file.toPath(), delimiter);
    }

    public StudentCollection readStudents() {
        StudentCollection students = new StudentCollection();
        String line;
        int lineNum = 0;

        try {
            while ((line = reader.readLine()) != null) {
                lineNum++;
                String[] parts = line.split(",");

                try {
                    if (parts.length < 3) {
                        throw new IllegalArgumentException("Not enough data in a line.");
                    }

                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double grade = Double.parseDouble(parts[2].trim());

                    students.add(new Student(id, name, grade));
                } catch (IllegalArgumentException e) {
                    System.err.println(e);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        return students;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}