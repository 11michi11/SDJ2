package temperature.domain.mediator;

import java.util.Observer;

import temperature.domain.model.Temperature;

public interface TemperatureModel {
	public void addTemperature(int temperature);

	public Temperature getLastInsertedTemperature();
	public void addObserver(Observer o);
}