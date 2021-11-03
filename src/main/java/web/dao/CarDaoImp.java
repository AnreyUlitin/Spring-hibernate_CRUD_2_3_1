package web.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import web.model.Car;

@Component
public class CarDaoImp implements CarDao {

    private final List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("Reno", "Logan", 200000));
        carList.add(new Car("Fiat", "Panda", 125000));
        carList.add(new Car("Volga", "Siber", 500000));
        carList.add(new Car("Lada", "Samara", 435000));
        carList.add(new Car("UAZ", "Patriot", 980000));
    }

    public List<Car> getNumberOfCars(Integer number) {
        if (number == null || number >= 5) {
            return carList;
        }
        return carList.stream().limit(number).collect(Collectors.toList());
    }
}
