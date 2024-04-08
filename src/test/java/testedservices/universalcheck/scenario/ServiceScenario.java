package testedservices.universalcheck.scenario;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;
import testedservices.universalcheck.step.ServiceStep;

import java.util.List;

public class ServiceScenario {

    public static ScenarioBuilder scenarioUniversalCheck() {
        return CoreDsl.scenario("Performance Test")
                .exec(
                        List.of(
                                ServiceStep.stepService
                        ));
    }

}
