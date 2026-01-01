package State;

public class TrafficLight {

    private LightState currentState;

    public TrafficLight() {
        currentState = new RedLightState(); // initial state
    }

    public void setState(LightState state) {
        this.currentState = state;
    }

    public void change() {
        currentState.changeLight(this);
    }
}