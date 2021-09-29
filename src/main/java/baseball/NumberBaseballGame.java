package baseball;

import java.util.*;

public class NumberBaseballGame {

    private String[] saveComputerNum;
    private int ballCount;
    private int strikeCount;


    public NumberBaseballGame() {
    }

    private void PlayerNumbersErrorCheck(Integer[] playerSplitNumber) {
        if (playerSplitNumber.length > 3) {
            throw new IllegalStateException("length over");
        }
    }

    private String[] SavePlayerNumber(String playerNum) {
        return playerNum.split("");
    }

    private String[] SaveComputerNumber(Random randomNumber) {
        saveComputerNum = new String[3];

        for (int i = 0; i < 3; i++) {
            saveComputerNum[i] = Integer.toString((randomNumber.nextInt(9) + 1));
            for (int j = 0; j < i; j++) {
                if (saveComputerNum[i].equals(saveComputerNum[j])) {
                    i--;
                }
            }
        }
        return saveComputerNum;
    }


    private Boolean StartGame(String[] playerNumber, String[] computerNumber) {
        Integer[] checkComputerAndPlayerNumbers = new Integer[3];
        ballCount = 0;
        strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (!Objects.equals(playerNumber[i], computerNumber[i])) {
                for (int j = 0; j < 3; j++) {
                    if (Objects.equals(playerNumber[i], computerNumber[j])) {
                        ballCount++;
                    }
                }
            } else {
                strikeCount++;
            }
        }
        if (ballCount > 0 || strikeCount < 3) {
            return false;
        }
        return true;
    }

    private Boolean InsertNumber(String playerNum, int initCount) {
        Random randomNumber = new Random();
        String[] savePlayerNum = new String[3];

        if (initCount == 0) {
            saveComputerNum = new String[3];
            saveComputerNum = SaveComputerNumber(randomNumber);
            initCount = 1;
        }
        savePlayerNum = SavePlayerNumber(playerNum);
        return StartGame(savePlayerNum, saveComputerNum);
    }

    private void InsertError(String playmaker2) {
        String[] findSameElement = playmaker2.split("");
        if (playmaker2.length() != 3) {
            throw new IllegalStateException("Insert Error!");
        }
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (findSameElement[i].equals(findSameElement[j])) {
                    throw new IllegalStateException("Same Number!");
                }
            }
        }
    }

    private void DisPlay() {
        Scanner scanner = new Scanner(System.in);
        boolean reInsert = false;
        String playmaker2;
        int initCount = 0;

        while (!reInsert) {
            System.out.print("Insert Number : ");
            playmaker2 = scanner.nextLine();
            InsertError(playmaker2);
            reInsert = InsertNumber(playmaker2, initCount);
            System.out.println(ballCount + " Ball " + strikeCount + "Strike");
            initCount++;
        }
        System.out.println("3 Strike");
        System.out.println("Game Set");
        System.out.println("Enter 1 to start a new game and 2 to end");
        playmaker2 = scanner.nextLine();
        if (Objects.equals(playmaker2, "1")) {
            DisPlay();
        }
    }
}
