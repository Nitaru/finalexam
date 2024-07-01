package finalexam.task2;

public class FactoryTester {
    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();
        Person person1 = new Person("John", "Doe", "123456789");
        Person person2 = new Person("Jane", "Smith", "987654321");

        // Add persons to factory
        factory.addPerson(person1);
        factory.addPerson(person2);

        // Display factory staff
        System.out.println("Factory staff: " + factory.getStaff());

        // Remove person from factory
        factory.deletePerson(person1);

        // Display factory staff after removal
        System.out.println("Factory staff after removal: " + factory.getStaff());
    }
}
