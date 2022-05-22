public class Seller {

    private String name;

    final static int CAR_PRODUCTION_TIME = 2000;

    public Seller(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void produceCar(CarDealership dealership) {
        try {
            Thread.sleep(CAR_PRODUCTION_TIME);
            dealership.addCar();
            System.out.println(Thread.currentThread().getName() + " выпустил 1 авто");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}