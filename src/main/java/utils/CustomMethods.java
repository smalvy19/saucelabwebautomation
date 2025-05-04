package utils;
import com.github.javafaker.Faker;

public class CustomMethods {

        private static final Faker faker = new Faker();

        public static String getRandomFirstName() {
            return faker.name().firstName();
        }

        public static String getRandomLastName() {
            return faker.name().lastName();
        }

        public static String getRandomZipCode() {
            return faker.address().zipCode().substring(0, 5); // US-style 5-digit zip
        }
}
