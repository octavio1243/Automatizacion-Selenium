package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public class SeleniumConfig {
    //"Windows" o "Linux"
    private final String OS = "Linux";
    private WebDriver driver;

    public SeleniumConfig(String browser) {
        if (!(Objects.equals(browser, "chrome") || Objects.equals(browser, "firefox"))) {
            throw new RuntimeException("Navegador inválido. No se puede crear driver");
        }

        String rutaProyecto = System.getProperty("user.dir"); // Obtener ruta del proyecto para localizar el driver
        System.out.println("Creando driver para " + browser);

        if (Objects.equals(browser, "chrome")) {
            // Crear Driver para Chrome
            String rutaDriver = (OS == "Windows" ? "\\selenium\\chromedriver.exe" : "/selenium/chromedriver");
            System.setProperty("webdriver.chrome.driver", rutaProyecto + rutaDriver);
            this.driver = new ChromeDriver();
        } else if (Objects.equals(browser, "firefox")) {
            // Crear Driver para firefox
            String rutaDriver = (OS == "Windows" ? "\\selenium\\geckodriver.exe" : "/selenium/geckodriver");
            System.setProperty("webdriver.gecko.driver", rutaProyecto + rutaDriver);
            this.driver = new FirefoxDriver();
        }

        this.configBasic();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void configBasic() {
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Espera de 10 segundos para que aparezca un elemento
    }
}
