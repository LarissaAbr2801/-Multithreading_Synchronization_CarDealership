import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarDealership {

    private final Lock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    private final List<Car> cars = new ArrayList<>();
    private final static int BUYING_CAR_TIME = 3000;

    public void sellCar() {
        try {
            System.out.println("Покупатель " + Thread.currentThread().getName() + " зашел в автосалон");
            lock.lock();
            while (cars.size() == 0) {
                System.out.println("Машин нет");
                condition.await();
            }
            Thread.sleep(BUYING_CAR_TIME);
            System.out.println("Покупатель " + Thread.currentThread().getName() +
                    " уехал на новеньком авто");
            cars.remove(0);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void addCar() {
        try {
            lock.lock();
            cars.add(new Car());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

}