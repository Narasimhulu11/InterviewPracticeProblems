package interviews.java8;

import java.io.*;


public class Animal implements Serializable{
    private String Name;
     class Dog extends Animal implements Serializable {
        private String tailColor;
    }

     class BarkingDog extends Dog{
    }
    class Cat extends Animal{

    }

    public static void main(String[] args) throws FileNotFoundException {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("Mnsd.txt"));
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            ois.readObject();
        } catch (Exception exception){

        }
    }
}
