import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.of("test");
        System.out.println(stringOptional.get());
//        Optional<Object> empty = Optional.empty();
//        System.out.println(empty.get());
        Optional<String> test = Optional.ofNullable("test");
        System.out.println(test.get());
        Optional<Object> optional = Optional.ofNullable(null);
        System.out.println(optional.get());
    }
}
