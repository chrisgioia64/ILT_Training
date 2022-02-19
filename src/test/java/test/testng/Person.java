package test.testng;

public class Person {
	
	private String name;
	private int age;
	private String residence;
	
	public Person(String name, int age, String residence) {
		super();
		this.name = name;
		this.age = age;
		this.residence = residence;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getResidence() {
		return residence;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person other = (Person) obj;
			return other.name.equals(name) && other.age == age;
		}
		return false;
	}

}
