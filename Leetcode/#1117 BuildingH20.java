import java.util.concurrent.*;

class H2O {

  Semaphore h, o;
  volatile boolean flag = false;

  public H2O() {
    h = new Semaphore(2);
    o = new Semaphore(0);
  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    h.acquire();
    releaseHydrogen.run();
    o.release();
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    o.acquire(2);
    releaseOxygen.run();
    h.release(2);
  }
}
