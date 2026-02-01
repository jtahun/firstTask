package org.example.watergenapp;

import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class H2O {
  private final Semaphore hSemaphore = new Semaphore(2);
  private final Semaphore oSemaphore = new Semaphore(1);

  private final CyclicBarrier barrier = new CyclicBarrier(3, () -> {
    hSemaphore.release(2);
    oSemaphore.release(1);
    });

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    oSemaphore.acquire();
    releaseOxygen.run();
    awaitBarrier();
  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    hSemaphore.acquire();
    releaseHydrogen.run();
    awaitBarrier();
  }
}
