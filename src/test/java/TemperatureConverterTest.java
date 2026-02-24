import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {

    private static final double DELTA = 1e-9;

    // --- fahrenheitToCelsius ---

    @Test
    void fahrenheitToCelsius_freezingPoint() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32.0), DELTA);
    }

    @Test
    void fahrenheitToCelsius_boilingPoint() {
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212.0), DELTA);
    }

    @Test
    void fahrenheitToCelsius_negativeFortySameInBothScales() {
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40.0), DELTA);
    }

    // --- celsiusToFahrenheit ---

    @Test
    void celsiusToFahrenheit_freezingPoint() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0.0), DELTA);
    }

    @Test
    void celsiusToFahrenheit_boilingPoint() {
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100.0), DELTA);
    }

    @Test
    void celsiusToFahrenheit_negativeFortySameInBothScales() {
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40.0), DELTA);
    }

    // --- Round-trip consistency ---

    @Test
    void roundTrip_fahrenheitToCelsiusToFahrenheit() {
        double original = 77.0;
        double result = TemperatureConverter.celsiusToFahrenheit(
                TemperatureConverter.fahrenheitToCelsius(original));
        assertEquals(original, result, DELTA);
    }

    @Test
    void roundTrip_celsiusToFahrenheitToCelsius() {
        double original = 25.0;
        double result = TemperatureConverter.fahrenheitToCelsius(
                TemperatureConverter.celsiusToFahrenheit(original));
        assertEquals(original, result, DELTA);
    }

    // --- isExtremeTemperature ---

    @Test
    void isExtremeTemperature_belowLowerBound() {
        assertTrue(TemperatureConverter.isExtremeTemperature(-40.1));
    }

    @Test
    void isExtremeTemperature_atLowerBound() {
        assertFalse(TemperatureConverter.isExtremeTemperature(-40.0));
    }

    @Test
    void isExtremeTemperature_normalRange() {
        assertFalse(TemperatureConverter.isExtremeTemperature(20.0));
    }

    @Test
    void isExtremeTemperature_atUpperBound() {
        assertFalse(TemperatureConverter.isExtremeTemperature(50.0));
    }

    @Test
    void isExtremeTemperature_aboveUpperBound() {
        assertTrue(TemperatureConverter.isExtremeTemperature(50.1));
    }
}
