import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 11; i <= 20; i++) {
                sum += i;
            }
            return sum;
        });

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 21; i <= 30; i++) {
                sum += i;
            }
            return sum;
        });

        CompletableFuture<Integer> finalFuture = future1.thenCombine(future2, (sum1, sum2) -> sum1 + sum2)
                .thenCombine(future3, (sum12, sum3) -> sum12 + sum3);

        System.out.println("Sum of 1 to 30: " + finalFuture.join());
    }
}
