package web.Service;

import web.dao.CarDao;
import web.dao.CarDaoImp;
import web.model.Car;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final CarDao carDao = new CarDaoImp();

    public List<Car> getNumberOfCars(Integer number) {
        return carDao.getNumberOfCars(number);
    }

}
