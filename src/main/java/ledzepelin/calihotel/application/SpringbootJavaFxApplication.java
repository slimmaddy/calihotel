package ledzepelin.calihotel.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import ledzepelin.calihotel.CalihotelApplication;
import ledzepelin.calihotel.application.event.model.StageEvent;
import ledzepelin.calihotel.application.event.publisher.StageEventPublisher;
import ledzepelin.calihotel.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author <a href="mailto:rene.gielen@gmail.com">Rene Gielen</a>
 * @noinspection RedundantThrows
 */
public class SpringbootJavaFxApplication extends Application {

    private ConfigurableApplicationContext context;

    @Autowired
    StageEventPublisher publisher;

    @Override
    public void init() throws Exception {
        this.context = new SpringApplicationBuilder()
                .sources(CalihotelApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        context.publishEvent(new StageEvent(Constants.STATE_READY,primaryStage));
//        publisher.publish(new StageReadyEvent(Constants.STATE_READY,primaryStage));
    }

    @Override
    public void stop() throws Exception {
        context.close();
        Platform.exit();
    }
}
