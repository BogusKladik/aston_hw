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
        System.out.println("Все отсортированнее по сумме транзакции за 2011 год:");
        transactions.stream()
                    .filter(t -> t.getYear() == 2011)
                    .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                    .forEach(System.out::println);
        System.out.println();

        // 2
        System.out.println("Список неповторяющихся городов, в которых работают трейдеры:");
        transactions.stream()
                    .map(t -> t.getTrader().getCity())
                    .distinct()
                    .forEach(System.out::println);
        System.out.println();

        // 3
        System.out.println("Все трейдеры из Кембриджа, отсортированные по именам:");
        transactions.stream()
                    .filter(t -> t.getTrader().getCity() == "Cambridge")
                    .sorted((t1, t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName()))
                    .forEach(System.out::println);
        System.out.println();

        // 4
        System.out.println("Строка со всеми именами трейдеров, отсортированные в алфавитном\r\n" + //
                        "порядке:");
        System.out.println(transactions.stream()
                    .map(t -> t.getTrader().getName())
                    .sorted()
                    .collect(Collectors.joining(", ")));
        System.out.println();

        // 5
        System.out.print("Существует ли хоть один трейдер из Милана: ");
        System.out.println(transactions.stream()
                    .anyMatch(t -> t.getTrader().getCity() == "Milan"));
        System.out.println();

        // 6
        System.out.println("Суммы всех транзакций трейдеров из Кембриджа:");
        transactions.stream()
                    .filter(t -> t.getTrader().getCity() == "Cambridge")
                    .map(t -> t.getValue())
                    .forEach(System.out::println);
        System.out.println();

        // 7
        System.out.print("Максимальная сумма среди всех транзакций: ");
        System.out.println(transactions.stream()
                    .mapToInt(t -> t.getValue())
                    .max()
                    .getAsInt());
        System.out.println();

        // 8
        System.out.print("Транзакцию с минимальной суммой: ");
        System.out.println(transactions.stream()
                    .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                    .get());
    }
}
