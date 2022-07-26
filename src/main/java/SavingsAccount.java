public class SavingsAccount {

  private long total = 0;

  public synchronized boolean withdraw(long amount) {
      if ((total - amount) > 0) {
        total -= amount;
        System.out.println("After withdrawing " + amount + " dollars, the account now has " + total);

        return true;
      }
      else {
        System.out.println("Impossible you're BROKE. Like DEAD BROKE");
        return false;
      }
  }

  public synchronized void deposit(long amount) {
    total += amount;
    System.out.println("After depositing another " + amount + " dollars, the account now has " + total);
  }

  public synchronized long getTotal() {
      return total;
  }
}