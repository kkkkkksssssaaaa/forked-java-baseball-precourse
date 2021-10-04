package baseball.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractPlayer {

    Integer startIdx = 1;
    Integer endIdx = 9;
    Integer maxSize = 3;

    public abstract List<Integer> getNumbers();
    public abstract Integer getSize();

}
