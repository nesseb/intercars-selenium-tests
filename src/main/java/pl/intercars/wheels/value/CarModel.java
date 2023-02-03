package pl.intercars.wheels.value;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CarModel {
    String carBrand;
    String carModel;
    String carEngine;
}
