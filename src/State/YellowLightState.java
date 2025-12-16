package State;

public class YellowLightState implements LightState {

    @Override
    public void changeLight(TrafficLight trafficLight) {
        System.out.println("YELLOW Light - Ready to Stop");
        trafficLight.setState(new RedLightState());
    }
}