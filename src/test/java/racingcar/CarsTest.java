package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("라운드 진행 후에 정보를 잘 출력하는지 확인")
    @Test
    void doRound() {
        List<Car> carList = new ArrayList<Car>() {{
            add(new Car("car1", 0));
            add(new Car("car2", 2));
            add(new Car("car3", 3));
        }};
        Cars cars = new Cars(carList, new TrueFalseRepeatChecker());

        cars.doRound();

        assertThat(outputStreamCaptor.toString()).isEqualTo(
            "car1 : -\n" + "car2 : --\n" + "car3 : ----\n" + "\n"
        );
    }

    @DisplayName("승자가 1명 일때 정보를 잘 출력하는지 확인")
    @Test
    void printSingleWinners() {
        List<Car> carList = new ArrayList<Car>() {{
            add(new Car("car1", 3));
            add(new Car("car2", 4));
            add(new Car("car3", 5));
        }};
        Cars cars = new Cars(carList, new TrueFalseRepeatChecker());

        cars.printWinners();

        assertThat(outputStreamCaptor.toString()).isEqualTo(
            "최종 우승자: car3\n"
        );
    }

    @DisplayName("승자가 여러명 일때 정보를 잘 출력하는지 확인")
    @Test
    void printMultipleWinners() {
        List<Car> carList = new ArrayList<Car>() {{
            add(new Car("car1", 3));
            add(new Car("car2", 5));
            add(new Car("car3", 5));
        }};
        Cars cars = new Cars(carList, new TrueFalseRepeatChecker());

        cars.printWinners();

        assertThat(outputStreamCaptor.toString()).isEqualTo(
            "최종 우승자: car2, car3\n"
        );
    }
}