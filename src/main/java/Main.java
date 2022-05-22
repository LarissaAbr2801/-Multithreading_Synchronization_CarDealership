public class Main {

    final static int BUYERS_QUANTITY = 10;

    public static void main(String[] args) throws InterruptedException {
        CarDealership dealership = new CarDealership();
        Seller seller = new Seller("Производитель Toyota");

        for (int i = 0; i < BUYERS_QUANTITY; i++) {
            new Thread(null, dealership::sellCar, "" + (i + 1) + "").start();
            new Thread(null, () -> seller.produceCar(dealership), seller.getName()).start();
        }

    }
}