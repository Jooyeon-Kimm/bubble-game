package bubble.test.ex00;

import lombok.Data;

@Data
class Dog{
	private String name;
}

public class LombokTest {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setName("Pong");
		System.out.println(dog.getName());
	}

}
