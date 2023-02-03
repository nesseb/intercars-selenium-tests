package pl.intercars.wheels.value;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Product {
    String productName;
    double price;
}
