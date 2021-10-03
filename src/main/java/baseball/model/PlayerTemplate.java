package baseball.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class PlayerTemplate {

    Integer startIdx = 1;
    Integer endIdx = 9;
    Integer size = 3;

    public abstract List<Integer> getNumbers();

}
