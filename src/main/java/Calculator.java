import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private String[] values;
    private int wrongInputCount;

    private Queue<String> numberQueue = new LinkedList<String>();
    private Queue<String> nonNumberQueue = new LinkedList<String>();

    private final String[] nonNumber = {"+", "-", "*", "/"};

    public Calculator() {
    }

    public Calculator(Queue<String> numberQueue, Queue<String> nonNumberQueue) {
        this.numberQueue = numberQueue;
        this.nonNumberQueue = nonNumberQueue;
    }

    private void ErrorCheck1(Queue<String> numberQueue, Queue<String> nonNumberQueue) {
        if ((nonNumberQueue.size() >= numberQueue.size()) || (nonNumberQueue.size() != (numberQueue.size() - 1))) {
            throw new IllegalStateException("Wrong Value.");
        }
    }

    private void ErrorCheck(String[] values) {
        if ((values.length < 3)) {
            throw new IllegalStateException("Wrong Value.");
        }
        for (String s : nonNumber) {
            if ((values[0].contains(s)) || (values[values.length - 1].contains(s))) {
                throw new IllegalStateException("Wrong Value.");
            }
        }
    }

    public void StringEmptyCheck(String value) {
        if (value.isEmpty()) {
            throw new IllegalStateException("Empty Value.");
        }
    }

    private Integer FindTypeAndCalculator(Queue<String> numberQueue,
                                          Queue<String> nonNumberQueue) {
        Integer currentNumber;
        Integer resultNumber;
        String operator;

        resultNumber = Integer.parseInt(numberQueue.remove());
        while (!(numberQueue.isEmpty())) {
            currentNumber = Integer.parseInt(numberQueue.remove());
            operator = nonNumberQueue.remove();
            switch (operator) {
                case "+":
                    resultNumber += currentNumber;
                    break;
                case "-":
                    resultNumber -= currentNumber;
                    break;
                case "*":
                    resultNumber *= currentNumber;
                    break;
                case "/":
                    resultNumber /= currentNumber;
                    break;
            }
        }
        return resultNumber;
    }

    public Integer InputData(final String value) {
        StringEmptyCheck(value);
        values = value.split(" ");
        ErrorCheck(values);
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                numberQueue.add(values[i]);
            } else {
                nonNumberQueue.add(values[i]);
            }
        }
        ErrorCheck1(numberQueue, nonNumberQueue);
        return FindTypeAndCalculator(numberQueue, nonNumberQueue);
    }
}
