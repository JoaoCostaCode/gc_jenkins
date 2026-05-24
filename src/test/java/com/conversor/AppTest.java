package com.conversor;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    private final App app = new App();

    @Test
    public void testCelsiusParaFahrenheit() {
        assertEquals(32.0, app.celsiusParaFahrenheit(0.0), 0.001);
        assertEquals(212.0, app.celsiusParaFahrenheit(100.0), 0.001);
    }

    @Test
    public void testFahrenheitParaCelsius() {
        assertEquals(0.0, app.fahrenheitParaCelsius(32.0), 0.001);
        assertEquals(100.0, app.fahrenheitParaCelsius(212.0), 0.001);
    }
}