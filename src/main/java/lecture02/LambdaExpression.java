package lecture02;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LambdaExpression {

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " : " + age;
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new LinkedList<>();
        persons.add(new Person("Chris", 29));
        persons.add(new Person("Valentina", 2));
        persons.add(new Person("Emilia", 17));
        persons.add(new Person("Charo", 59));
        persons.add(new Person("Mafe", 34));
        persons.add(new Person("John", 64));
        persons.add(new Person("Joseph", 67));

        Collections.sort(persons, (x, y) -> x.age - y.age);
        System.out.println(persons);

        Collections.sort(persons, (x, y) -> x.name.compareTo(y.name));
        System.out.println(persons);
    }

}
