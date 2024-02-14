package aston_hw.second;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        // 1
        transactions.stream()
                    .filter(t -> t.getYear() == 2011)
                    .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                    .forEach(t -> System.out.println(t.toString()));

        // 2
        transactions.stream()
                    .map(t -> t.getTrader().getCity())
                    .distinct()
                    .forEach(t -> System.out.println(t.toString()));

        // 3
        transactions.stream()
                    .filter(t -> t.getTrader().getCity() == "Cambridge")
                    .sorted((t1, t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName()))
                    .forEach(t -> System.out.println(t.toString()));

        // 4
        System.out.println(transactions.stream()
                    .map(t -> t.getTrader().getName())
                    .sorted()
                    .collect(Collectors.joining(", ")));

        // 5
        System.out.println(transactions.stream()
                    .anyMatch(t -> t.getTrader().getCity() == "Milan"));

        // 6
        System.out.println(transactions.stream()
                    .filter(t -> t.getTrader().getCity() == "Cambridge")
                    .mapToInt(t -> t.getValue())
                    .sum());

        // 7
        System.out.println(transactions.stream()
                    .mapToInt(t -> t.getValue())
                    .max()
                    .getAsInt());

        // 8
        System.out.println(transactions.stream()
                    .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                    .get());
    }
}
