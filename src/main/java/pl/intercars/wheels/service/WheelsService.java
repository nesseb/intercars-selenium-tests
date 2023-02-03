package pl.intercars.wheels.service;

import pl.intercars.wheels.page.WheelsHome;
import pl.intercars.wheels.page.WheelsList;
import pl.intercars.wheels.value.CarModel;
import pl.intercars.wheels.value.Wheel;

public class WheelsService {

    private final WheelsHome wheelsHome;
    private final WheelsList wheelsList;

    public WheelsService() {
        this.wheelsHome = new WheelsHome();
        this.wheelsList = new WheelsList();
    }

    public void selectWheelsByModel(CarModel carModel) {
        wheelsHome.chooseBrand(carModel.getCarBrand())
                .chooseModelCar(carModel.getCarModel())
                .chooseEngineModel(carModel.getCarEngine())
                .submit();
    }

    public Wheel getTire() {
        return new Wheel(wheelsList.getWheelsName(), wheelsList.getWheelsPrice());
    }

    public void addTiresToBasket(int howMany) {
        wheelsList.addWheelToBasket(howMany).confirmChoose();
    }
}
