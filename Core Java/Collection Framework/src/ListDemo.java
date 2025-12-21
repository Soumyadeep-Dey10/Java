import java.util.ArrayList;
import java.util.List;

class Car{
    String name;
    public Car(String name){
        this.name = name;
    }
}
public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("Alice");
        list.add("Bob");
        list.add("Rup");

        for(Object user: list){
            System.out.println(user);
        }

        System.out.println("Element using index:"+ list.get(2));

        Car car1 = new Car("Audi");
        Car car2 = new Car("BMW");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        System.out.println(" == All Cars == ");
        for (Car car: carList){
            System.out.println(car.name);
        }

    }
}
