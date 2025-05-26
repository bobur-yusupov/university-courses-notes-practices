package analyzer.student;

import java.util.*;

public class StudentCollection implements Collection<Student> {
    private final List<Student> students;

    public StudentCollection() {
        this.students = new ArrayList<>();
    }

    @Override
    public int size() {
        return students.size();
    }

    @Override
    public boolean isEmpty() {
        return students.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return students.contains(o);
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator();
    }

    private class StudentIterator implements Iterator<Student> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < students.size();
        }

        @Override
        public Student next() {
            if (!hasNext()) throw new NoSuchElementException();
            return students.get(index++);
        }

        @Override
        public void remove() {
            if (index == 0) throw new IllegalStateException();
            students.remove(--index);
        }
    }

    @Override
    public Object[] toArray() {
        return students.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return students.toArray(a);
    }

    @Override
    public boolean add(Student student) {
        return students.add(student);
    }

    @Override
    public boolean remove(Object o) {
        return students.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return students.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Student> c) {
        return students.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return students.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return students.retainAll(c);
    }

    @Override
    public void clear() {
        students.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Collection<?>)) return false;
        Collection<?> that = (Collection<?>) o;
        return this.size() == that.size() && this.containsAll(that);
    }

    @Override
    public int hashCode() {
        return students.hashCode();
    }
}
