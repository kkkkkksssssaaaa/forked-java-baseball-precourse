package baseball.model;

import nextstep.utils.Randoms;

import java.util.*;

public class ComputerPlayer extends PlayerTemplate {

    private final List<Integer> numbers = new ArrayList<>();

    public ComputerPlayer() {
        numbers.addAll(initializeNumbers());
    }

    @Override
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private Set<Integer> initializeNumbers() {
        Set<Integer> createNumbers = new HashSet<Integer>();

        while(createNumbers.size() < size) {
            createNumbers.add(Randoms.pickNumberInRange(startIdx, endIdx));
        }

        return createNumbers;
    }

}
