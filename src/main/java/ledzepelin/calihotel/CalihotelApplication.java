package ledzepelin.calihotel;

import javafx.application.Application;
import ledzepelin.calihotel.application.SpringbootJavaFxApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalihotelApplication {

    public static void main(String[] args) {
        Application.launch(SpringbootJavaFxApplication.class, args);
    }

}
