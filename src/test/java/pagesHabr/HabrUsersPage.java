package pagesHabr;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HabrUsersPage extends HabrBasePage {

    private Actions actions = new Actions(driver);
    private By searchUserField = By.xpath("//input[@name=\"searchQuery\"]");
    private WebElement firstUserInList = driver.findElements(By.xpath("//div[@class='tm-users-list']//div[@class = 'tm-users-list__item'][1]//a[@class = 'tm-user-snippet__nickname']")).get(0);

    public HabrUsersPage(WebDriver driver) {
        super(driver);
    }

    @Step("searching user by name")
    public HabrUsersPage search(String myUserSearch) {
        driver.findElement(searchUserField).sendKeys(myUserSearch);
        logger.info("Search page HABR is open");
        return this;
    }

    @Step("open info for first user in the list")
    public HabrUsersPage openPersonalInfoFirstUser() {
        actions.click(firstUserInList).build().perform();
        return this;
    }
}
