package test;

import org.junit.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class
WritingPricesToFile extends BaseTest {
    @Test
    public void writingPricesToFile() throws IOException, InterruptedException {
        sleep(3000);

        mainPage.clickOnButton();
        mainPage.putPricesToFile();



    }
}