public class Main {

    final static int BUYERS_QUANTITY = 10;
    final static int CLIENT_ENTERING_SHOP_TIME = 3000;

    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();
        Seller seller = new Seller("Производитель Toyota");

        try {
            for (int i = 0; i < BUYERS_QUANTITY; i++) {
                Thread.sleep(CLIENT_ENTERING_SHOP_TIME);
                new Thread(null, dealership::sellCar, "" + (i + 1) + "").start();
                new Thread(null, () -> seller.produceCar(dealership), seller.getName()).start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}