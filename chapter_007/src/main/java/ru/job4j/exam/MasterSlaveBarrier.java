package ru.job4j.exam;

public class MasterSlaveBarrier {

    private volatile boolean isMaster = true;

    public synchronized void tryMaster() throws InterruptedException {
        while (true) {
            if (isMaster) {
                doneMaster();
                isMaster = false;
                notify();
            } else {
                notify();
                wait();
            }
        }
    }

    public synchronized void trySlave() throws InterruptedException {
        while (true) {
            if (!isMaster) {
                doneSlave();
                isMaster = true;
                notify();
            } else {
                notify();
                wait();
            }
        }
    }

    public void doneMaster() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("А");
    }

    public void doneSlave() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("B");
    }

    public static void main(String[] args) throws InterruptedException {
        MasterSlaveBarrier barrier = new MasterSlaveBarrier();
        Thread master = new Thread(
                () -> {
                    while (true) {
                        try {
                            barrier.tryMaster();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        Thread slave = new Thread(
                () -> {
                    while (true) {
                        try {
                            barrier.trySlave();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        master.start();
        slave.start();
        master.join();
        slave.join();
    }
}
