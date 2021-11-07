package step3.domain.car;

import static java.lang.String.format;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    static final String NAME_LENGTH_ERROR_MESSAGE = format("이름은 %s자 이상 %s자 이하여야 합니다.", MIN_NAME_LENGTH, MAX_NAME_LENGTH);

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

}
