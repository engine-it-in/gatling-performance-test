package simulation;

import injection.InjectionMode;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.global;
import static parameters.ParametersExecution.AssertPerformanceParameters.*;
import static parameters.ParametersExecution.ConnectionParameters.CONNECTIONS_PER_HOST;
import static parameters.ParametersExecution.HeaderType.JSON_TYPE_HEADER;
import static parameters.ParametersExecution.PerformanceParameters.TEST_MODE;
import static testedservices.universalcheck.scenario.ServiceScenario.scenarioUniversalCheck;


public class ServiceSimulation extends Simulation {


    // Симуляция
    public ServiceSimulation() {
        setUp(
                scenarioUniversalCheck()
                        .injectClosed(InjectionMode.chooseInjectionStrategy(TEST_MODE))

        )
                .protocols(setupHttpForSimulation())
                .assertions(
                        global().responseTime().max().lte(GATE_FOR_RESPONSE_MILISECONDS),
                        global().successfulRequests().percent().gt(PERCENT_SUCCESS_RESPONSE)
                );
    }

    // Протокол подключения
    private static HttpProtocolBuilder setupHttpForSimulation() {

        return HttpDsl.http
                .acceptHeader(JSON_TYPE_HEADER)
                .contentTypeHeader(JSON_TYPE_HEADER)
                .maxConnectionsPerHost(CONNECTIONS_PER_HOST)
                ;
    }

}