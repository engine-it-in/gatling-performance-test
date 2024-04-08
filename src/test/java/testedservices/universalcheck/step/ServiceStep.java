package testedservices.universalcheck.step;

import io.gatling.javaapi.core.ChainBuilder;
import logic.ProcessingProperty;

import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class ServiceStep {

    public static final ChainBuilder stepService =
            exec(http("Name")
                    .post(ProcessingProperty.getConfigProperty().serviceUrl())
                    .body(ElFileBody("json/service/success/request.json")).asJson()
                    .check(status().is(200)));
}
