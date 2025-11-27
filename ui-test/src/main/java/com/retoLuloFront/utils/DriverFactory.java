package com.retoLuloFront.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        
        // Detectar si estamos en CI (GitHub Actions, Jenkins, etc.)
        boolean isCI = System.getenv("CI") != null || System.getenv("GITHUB_ACTIONS") != null;
        
        if (isCI) {
            // Configuración para entornos CI sin interfaz gráfica
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
        } else {
            // Configuración para desarrollo local
            chromeOptions.addArguments("--start-maximized");
        }
        
        // Opciones comunes para ambos entornos
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(chromeOptions);
    }
}
