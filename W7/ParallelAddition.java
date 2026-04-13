import java.util.Scanner;

class TotalAccumulator {
    private long totalSum = 0;

    public synchronized void addPartialSum(long partial) {
        totalSum += partial;
    }

    public long getTotalSum() {
        return totalSum;
    }
}

class SumTask implements Runnable {
    private int threadId;
    private long startNumber;
    private long endNumber;
    private TotalAccumulator accumulator;

    public SumTask(int threadId, long startNumber, long endNumber, TotalAccumulator accumulator) {
        this.threadId = threadId;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.accumulator = accumulator;
    }

    @Override
    public void run() {
        long partialSum = 0;
        
        for (long i = startNumber; i <= endNumber; i++) {
            partialSum += i;
        }
        
        System.out.println("Thread " + threadId + ": Menjumlahkan " + startNumber + 
                           " - " + endNumber + " | Hasil Parsial = " + partialSum);
        
        accumulator.addPartialSum(partialSum);
    }
}

public class ParallelAddition {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Thread: ");
        int numThreads = scanner.nextInt();
        
        System.out.print("Masukkan Angka Akhir: ");
        long finalNumber = scanner.nextLong();
        
        TotalAccumulator accumulator = new TotalAccumulator();
        Thread[] threads = new Thread[numThreads];

        long chunkSize = finalNumber / numThreads;
        long currentStart = 1;

        for (int i = 0; i < numThreads; i++) {
            long currentEnd = currentStart + chunkSize - 1;
            
            if (i == numThreads - 1) {
                currentEnd = finalNumber;
            }

            SumTask task = new SumTask(i + 1, currentStart, currentEnd, accumulator);
            threads[i] = new Thread(task);
            
            threads[i].start();

            currentStart = currentEnd + 1;
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        System.out.println("Hasil Akhir Keseluruhan: " + accumulator.getTotalSum());
        
        scanner.close();
    }
}