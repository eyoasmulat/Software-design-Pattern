package State;

public class GreenLightState implements LightState {

    @Override
    public void changeLight(TrafficLight trafficLight) {
        System.out.println("GREEN Light - Go");
        trafficLight.setState(new YellowLightState());
    }
}