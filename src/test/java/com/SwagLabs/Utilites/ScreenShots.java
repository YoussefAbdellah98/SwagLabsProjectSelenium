package com.SwagLabs.Utilites;
import com.SwagLabs.Utilites.Drivers.SettingUpWebDriver;
import com.SwagLabs.Utilites.Helpers.LogsUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

public class ScreenShots {

    public static void captureScreenShot(WebDriver driver, String testClassName, String testMethodName) {
        try {

            org.openqa.selenium.Point windowPosition = SettingUpWebDriver.getDriver().manage().window().getPosition();
            org.openqa.selenium.Dimension windowSize = SettingUpWebDriver.getDriver().manage().window().getSize();


            Rectangle browserRect = new Rectangle(windowPosition.getX(), windowPosition.getY(),
                    windowSize.getWidth(), windowSize.getHeight());


            BufferedImage browserScreenshot = new Robot().createScreenCapture(browserRect);


            String directoryPath = "test-outputs/screenshots";
            File targetDirectory = new File(directoryPath);
            if (!targetDirectory.exists()) {
                targetDirectory.mkdirs();
            }

            File targetFile = new File(targetDirectory, testClassName + "_" + testMethodName + ".png");
            ImageIO.write(browserScreenshot, "PNG", targetFile);


            try (FileInputStream fileInputStream = new FileInputStream(targetFile)) {
                Allure.addAttachment(testClassName + "_" + testMethodName + ".png", "image/png", new ByteArrayInputStream(fileInputStream.readAllBytes()), "png");
            }

        } catch (Exception e) {
            LogsUtils.error("Failed to take full-screen screenshot without Taskbar: " + e.getMessage());
        }
    }


}
