import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FindNumbers {

    private static final int BATCH_SIZE = 100;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 1000;

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        List<Integer> numbersWithNine = forkJoinPool.invoke(new FindNumbersTask(LOWER_BOUND, UPPER_BOUND));
        System.out.println("Numbers with digit 9: " + numbersWithNine);
    }

    private static class FindNumbersTask extends RecursiveTask<List<Integer>> {
        private final int lowerBound;
        private final int upperBound;

        public FindNumbersTask(int lowerBound, int upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        @Override
        protected List<Integer> compute() {
            if (upperBound - lowerBound <= BATCH_SIZE) {
                List<Integer> numbersWithNine = new ArrayList<>();
                for (int i = lowerBound; i <= upperBound; i++) {
                    if (String.valueOf(i).contains("9")) {
                        numbersWithNine.add(i);
                    }
                }
                return numbersWithNine;
            } else {
                int mid = lowerBound + (upperBound - lowerBound) / 2;
                FindNumbersTask leftTask = new FindNumbersTask(lowerBound, mid);
                FindNumbersTask rightTask = new FindNumbersTask(mid + 1, upperBound);
                leftTask.fork();
                rightTask.fork();
                List<Integer> leftResult = leftTask.join();
                List<Integer> rightResult = rightTask.join();
                leftResult.addAll(rightResult);
                return leftResult;
            }
        }
    }
}
