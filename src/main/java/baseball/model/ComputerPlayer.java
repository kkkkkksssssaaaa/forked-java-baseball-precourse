package baseball.model;

import nextstep.utils.Randoms;

import java.util.*;

public class ComputerPlayer extends Number {

    private final List<Integer> numbers = new ArrayList<>();

    public ComputerPlayer () {
        numbers.addAll(initializeNumbers());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private Set<Integer> initializeNumbers() {
        Set<Integer> createNumbers = new HashSet<Integer>();

        while(createNumbers.size() < super.size) {
            createNumbers.add(Randoms.pickNumberInRange(super.startIdx, super.endIdx));
        }

        return createNumbers;
    }

}
