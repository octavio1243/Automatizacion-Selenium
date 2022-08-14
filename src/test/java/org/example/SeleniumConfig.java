package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumConfig {
    private WebDriver driver;

    public SeleniumConfig() {
    }

    public SeleniumConfig(String tipo){
        String rutaProyecto=System.getProperty("user.dir"); // Obtener ruta del proyecto para localizar el driver

        if (tipo=="chrome"){
            // Crear Driver para Chrome
            System.out.println("Creando driver para chrome");
            System.setProperty("webdriver.chrome.driver",rutaProyecto+"\\selenium\\chromedriver.exe");
            this.driver=new ChromeDriver();
        }
        else if (tipo=="firefox"){
            // Crear Driver para firefox
            System.out.println("Creando driver para firefox");
            System.setProperty("webdriver.gecko.driver",rutaProyecto+"\\selenium\\geckodriver.exe");
            this.driver=new FirefoxDriver();
        }
        else{
            System.out.println("Navegador inválido. No se puede crear driver");
        }
        this.configBasic();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void configBasic(){
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Espera de 10 segundos para que aparezca un elemento
    }
}
