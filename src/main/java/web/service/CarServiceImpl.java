package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> list;

    {
        Car car1 = new Car("Audi", 454, "A6");
        Car car2 = new Car("Kia", 675, "RIO");
        Car car3 = new Car("Lada", 3463, "Kalina");
        Car car4 = new Car("Mercedes", 887, "e100");
        Car car5 = new Car("BMW", 6895, "M5");

        list = new ArrayList<>();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car5);
    }

    @Override
    public List<Car> getCars(int numbers) {
        return list.stream().limit(numbers).toList();
    }
}
