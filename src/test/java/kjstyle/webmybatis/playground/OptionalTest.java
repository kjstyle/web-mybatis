package kjstyle.webmybatis.playground;

import org.junit.jupiter.api.Test;

import java.util.*;

public class OptionalTest {

    @Test
    void OptionalOrElseNullTest() {
        List<String> nullList = null;
        String firstItemOptional = Optional.ofNullable(nullList).orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull) // https://stackoverflow.com/questions/32466799/why-does-findfirst-throw-a-nullpointerexception-if-the-first-element-it-finds
                .findFirst()
                .get()
                ;

    }
}
