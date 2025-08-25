package guru.qa.rococo.page.component;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.rococo.jupiter.extension.ScreenShotTestExtension;
import guru.qa.rococo.utils.ScreenDiffResult;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Picture {
    private final SelenideElement element;

    public Picture(SelenideElement element) {
        this.element = element;
    }

    public void checkPhoto(BufferedImage expected) throws IOException {
        Selenide.sleep(1000);
        BufferedImage actualImage = ImageIO.read(Objects.requireNonNull(element.screenshot()));
        assertFalse(
                new ScreenDiffResult(
                        actualImage, expected
                ),
                ScreenShotTestExtension.ASSERT_SCREEN_MESSAGE
        );
    }
}
