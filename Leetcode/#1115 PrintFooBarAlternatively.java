class FooBar {
  private int n;

  volatile boolean callFoo;
  volatile boolean callBar;

  public FooBar(int n) {
    this.n = n;
    callFoo = true;
    callBar = false;
  }

  public synchronized void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      while (callBar)
        wait();
      printFoo.run();
      callFoo = false;
      callBar = true;
      notifyAll();
    }
  }

  public synchronized void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      while (callFoo)
        wait();
      printBar.run();
      callBar = false;
      callFoo = true;
      notifyAll();
    }
  }
}
