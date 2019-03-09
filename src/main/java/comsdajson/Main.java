package comsdajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Jan", "Kowalski",2 );
        Person person1 = new Person("Jan", "Kowalski",2 );
        Person person2 = new Person("A", "B", 5);
        Person person3 = new Person("C","D", 7);

        List<Person> lista = new ArrayList<>();


        ObjectMapper mapper = new ObjectMapper();
        try {
            String personStr = mapper.writeValueAsString(person);
            System.out.println(personStr);
            // do pliku person.json zapisać wynikowego stringa
            Files.write(Paths.get("person.json"), personStr.getBytes());

            File personFile = new File("person.json");

            Person person4 = mapper.readValue(new File("person.json"), Person.class);


        } catch (IOException e) {
            e.printStackTrace();
        }

        lista.add(person);
        lista.add(person1);
        lista.add(person2);
        lista.add(person3);

        try {
            String personList = mapper.writeValueAsString(lista);
            System.out.println(personList);
            Files.write(Paths.get("personList.json"), personList.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Student> studentList = new ArrayList<>();

        Student student = new Student("X","Y", new Address("Bydgoszcz","Gdańska"));
        Student student2 = new Student("Z","Q", new Address("Gdańsk","Grunwaldzka"));
        Student student3 = new Student("P","M", new Address("Warszawa","Grójecka"));

        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);


        try {
            String studentList1 = mapper.writeValueAsString(studentList);
            System.out.println(studentList1);
            Files.write(Paths.get("studnetList.json"), studentList1.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}