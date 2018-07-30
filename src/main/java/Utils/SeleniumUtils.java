package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import Setup.TestRule;

public class SeleniumUtils{

	public static WebDriver driver;
	
	public SeleniumUtils() {
		driver = TestRule.getDriver();
	}
	
	public void sleep(Long milis) {
		try {
			Thread.sleep(milis);
		} catch (Exception e) {
			System.out.println(e);
		}
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
}
