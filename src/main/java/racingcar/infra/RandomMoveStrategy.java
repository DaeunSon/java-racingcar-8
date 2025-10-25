package racingcar.infra;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.MoveStrategy;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean canMove() {
        return Randoms.pickNumberInRange(0,9) >=4;
    }
}
