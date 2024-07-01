package finalexam.task3;

public class FactoryTester {
    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();
        Person person1 = new Person("John", "Doe", "123456789");
        Person person2 = new Person("Jane", "Smith", "987654321");

        // Add persons to factory
        factory.addPerson(person1);
        factory.addPerson(person2);

        // Save staff to file
        String filename = "staff.ser";
        factory.saveStaffToFile(filename);

        // Clear current staff list
        factory.getStaff().clear();

        // Load staff from file
        factory.loadStaffFromFile(filename);

        // Display factory staff after loading
        System.out.println("Factory staff after loading from file: " + factory.getStaff());
    }
}
