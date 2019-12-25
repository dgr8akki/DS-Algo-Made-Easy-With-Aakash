class Solution_1226_DiningPhilosphy {

  Semaphore[] sems;

  public Solution_1226_DiningPhilosphy() {
    this.sems = new Semaphore[5];
    for (int i = 0; i < 5; i++) {
      sems[i] = new Semaphore(1);
    }
  }

  // call the run() method of any runnable to execute its code
  public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
      Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
    Semaphore left = sems[philosopher];
    Semaphore right = (philosopher == 0) ? sems[4] : sems[philosopher - 1];

    if (philosopher % 2 == 0) {
      left.acquire();
      pickLeftFork.run();
      right.acquire();
      pickRightFork.run();
    } else {
      right.acquire();
      pickRightFork.run();
      left.acquire();
      pickLeftFork.run();
    }

    eat.run();

    if (philosopher % 2 == 0) {
      putRightFork.run();
      right.release();
      putLeftFork.run();
      left.release();
    } else {
      putLeftFork.run();
      left.release();
      putRightFork.run();
      right.release();
    }
  }
}
