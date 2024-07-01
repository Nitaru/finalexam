package finalexam.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaperFactory {
    private List<Person> staff = new ArrayList<>();

    public void addPerson(Person p) {
        staff.add(p);
    }

    public boolean deletePerson(Person p) {
        return staff.remove(p);
    }

    public List<Person> getStaff() {
        return staff;
    }

    public void saveStaffToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(staff);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the staff list: " + e.getMessage());
        }
    }

    public void loadStaffFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            staff = (List<Person>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while loading the staff list: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "PaperFactory{" +
                "staff=" + staff +
                '}';
    }
}
