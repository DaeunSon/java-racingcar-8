package racingcar.domain.validator;

public class AttemptValidator {
    private final static int MIN_ATTEMPTS = 1;

    public AttemptValidator(){}

    public static int validateAttempts(int attempts){
        if(attempts < MIN_ATTEMPTS){
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
        return attempts;
    }
}
