package hatterfolyamat;

public class Hatterfolyamat implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("Én vagyok a hátérfolyamat");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
