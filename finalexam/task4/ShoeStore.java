package finalexam.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoeStore implements LegalEntity {
    private String address;
    private String vatNumber;
    private List<Style> styles;

    public ShoeStore(String address, String vatNumber) {
        this.address = address;
        this.vatNumber = vatNumber;
        this.styles = new ArrayList<>();
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    public void addStyle(Style style) {
        styles.add(style);
    }

    public boolean deleteStyle(Style style) {
        return styles.remove(style);
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void saveStylesToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(styles);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the styles list: " + e.getMessage());
        }
    }

    public void loadStylesFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            styles = (List<Style>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while loading the styles list: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ShoeStore{" +
                "address='" + address + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", styles=" + styles +
                '}';
    }
}
