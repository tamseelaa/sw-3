public class TemperatureConverter {
    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
    static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }
    static boolean isExtremeTemperature(double temperature) {
        return temperature < -40.0 || temperature > 50.0;
    }
}