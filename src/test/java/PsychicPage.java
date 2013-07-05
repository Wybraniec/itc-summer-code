import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 04.07.13
 * Time: 09:34
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class PsychicPage {
    @Drone
    private WebDriver browser;
}
