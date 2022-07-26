import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // your code here
        SavingsAccount savingsAccount = new SavingsAccount();
        Random random = new Random();

        savingsAccount.deposit(75);

        Thread thr1 = new Thread(() -> {
            int randomNum = random.nextInt(2);
            if (randomNum==0) {
                IntStream.range(1, 11).forEach(i -> savingsAccount.deposit(5));
            }
            else {
                IntStream.range(1, 11).forEach(i -> savingsAccount.withdraw(5));
            }
        });
        Thread thr2 = new Thread(() -> {
            int randomNum = random.nextInt(2);
            if (randomNum==0) {
                IntStream.range(1, 11).forEach(i -> savingsAccount.deposit(2));
            }
            else {
                IntStream.range(1, 11).forEach(i -> savingsAccount.withdraw(2));
            }

        });
        Thread thr3 = new Thread(() -> {
            int randomNum = random.nextInt(2);
            if (randomNum==0) {
                IntStream.range(1, 6).forEach(i -> savingsAccount.deposit(15));
            }
            else {
                IntStream.range(1, 6).forEach(i -> savingsAccount.withdraw(15));
            }
        });


        thr1.start();
        thr2.start();
        thr3.start();

        thr1.join();
        thr2.join();
        thr3.join();

        System.out.println("Final Total: " + savingsAccount.getTotal());
    }
}
