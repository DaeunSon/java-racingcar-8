package racingcar.domain.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    public NameValidator() {
    }

    public static List<String> parseCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        //공백만 있는 이름 검증
        isBlankedName(carNames);
        //이름 길이 검증
        isValidLength(carNames);
        //중복값 검증
        isDuplicatedName(carNames);
        System.out.println(carNames);
        return carNames;
    }

    private static void isDuplicatedName(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);

        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private static void isBlankedName(List<String> carNames) {
        for (String name : carNames) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
        }
    }

    private static void isValidLength(List<String> carNames) {
        for (String name : carNames) {
            int length = name.length();
            if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
            }
        }
    }



}
