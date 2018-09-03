package Utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SeleniumUtils{

	protected static WebDriver driver;
	protected static int contador = 0;
	public SeleniumUtils() {
		driver = Setup.TestRule.getDriver();
	}
	
	protected static Boolean esperaElemento(WebElement element, long segundos) {
		WebElement webElement = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(segundos, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class).ignoring(TimeoutException.class);
			try {
				webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
			return false;
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
			return false;
		}
		return webElement != null;
	}

	protected static void printaTela() throws AWTException {
		Robot robot = new Robot();
		BufferedImage bi = robot.createScreenCapture(new Rectangle(0, 0, 1920, 1080));
		try {
			ImageIO.write(bi, "jpg", new File("C:/Users/letscode/Desktop/InteliJ/Prints/print" + contador +".jpg"));
		}catch(IOException io){
			io.printStackTrace();
		}
		contador++;
	}
}
