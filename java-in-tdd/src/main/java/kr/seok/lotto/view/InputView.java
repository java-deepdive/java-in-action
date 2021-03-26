package kr.seok.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class InputView {
    public static final String GUIDE_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String GUIDE_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String GUIDE_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String GUIDE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";

    public static final String SPACIAL_CHARACTER_SPACE = "\\s";
    public static final String SPLIT_DELIMITER = ",";
    public static final String WHITE_SPACE = "";


    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int requestMoney() { // 구매
        System.out.println(GUIDE_PURCHASE_MONEY);
        return scanner.nextInt();
    }

    public int requestManual() {
        System.out.println(GUIDE_MANUAL_LOTTO_COUNT);
        int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public Set<Integer> requestLastWeekWinningNumbers() {
        System.out.println(GUIDE_LAST_WEEK_WINNING_NUMBER);
        return apply(scanner.nextLine());
    }

    public List<Set<Integer>> makeManualLottoNumbers(final int manualCount) {
        System.out.println(GUIDE_MANUAL_NUMBERS);
        return IntStream.range(0, manualCount)
                .mapToObj(i -> scanner.nextLine())
                .map(this::apply)
                .collect(toList());
    }

    private Set<Integer> apply(String s) {
        String[] split = s.split(",");
        return Arrays.stream(split)
                .map(Integer::new)
                .collect(toSet());
    }
}
