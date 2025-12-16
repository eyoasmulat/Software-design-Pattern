package trafficlight;

public class Main {

    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();

        trafficLight.change(); // Red → Green
        trafficLight.change(); // Green → Yellow
        trafficLight.change(); // Yellow → Red
        trafficLight.change(); // Red → Green
    }
}