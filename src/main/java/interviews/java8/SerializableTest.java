package interviews.java8;

import org.example.java.Employee;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) {
        Employee employee= new Employee("MNSD",12);
        try ( FileOutputStream fileOutputStream = new FileOutputStream("mnsd.txt");){
            ObjectOutputStream ois= new ObjectOutputStream(fileOutputStream);
            ois.writeObject(employee);
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }


        try(FileInputStream fileInputStream= new FileInputStream("mnsd.txt")){
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            Employee employee1= (Employee) ois.readObject();
            System.out.println(employee1.toString());
        }catch (FileNotFoundException fileNotFoundException){

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
