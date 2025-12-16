package trafficlight;

public class RedLightState implements LightState {

    @Override
    public void changeLight(TrafficLight trafficLight) {
        System.out.println("RED Light - Stop");
        trafficLight.setState(new GreenLightState());
    }
}