package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath="//div[@class=\"content_price\"]/span")
    List<WebElement> prices;
@FindBy(xpath="//li[@class=\"last\"]/a[@href=\"https://hmstudio.com.ua/ru/788-eco-friendly\"]")
WebElement ecoFriendly;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void clickOnButton() {
        ecoFriendly.click();
    }
    public void putPricesToFile() throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        int countOfElements = prices.size();
        List <Integer> finalPrices = new ArrayList<>();
        for (int i =0; i <countOfElements; i++) {
            WebElement eachPrice = prices.get(i);
            String textPrice = eachPrice.getText();
            String parsePrice = textPrice.replace("грн.", "").replace(",00", "");
            int intPrice = Integer.parseInt(parsePrice);
            finalPrices.add(intPrice);
        }
        System.out.println(finalPrices);
        Collections.sort(finalPrices);
        for (int x = 0; x <countOfElements; x++) {
            int eachIntPrice = finalPrices.get(x);
            writer.write(eachIntPrice + System.getProperty("line.separator"));
        }
        writer.close();


        }
    }



