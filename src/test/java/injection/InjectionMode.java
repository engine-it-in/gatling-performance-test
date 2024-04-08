package injection;

import dictionary.TestMode;
import io.gatling.javaapi.core.ClosedInjectionStep;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.constantConcurrentUsers;
import static io.gatling.javaapi.core.CoreDsl.rampConcurrentUsers;
import static parameters.ParametersExecution.PerformanceParameters.*;

public class InjectionMode {

    public static ClosedInjectionStep chooseInjectionStrategy(TestMode testMode) {
        switch (testMode) {
            case RAMP -> {
                return injectionRampRateProfile();
            }
            default -> {
                return injectionConstantRateProfile();
            }
        }
    }

    // Схема нагрузки -> Заданное количество пользователей сразу
    private static ClosedInjectionStep injectionConstantRateProfile() {
        return constantConcurrentUsers(END_USER_COUNT)
                .during(Duration.ofSeconds(WORK_UNDER_PRESSURE));
    }

    // Схема нагрузки -> Увеличение количества пользователей от  стартового значения
    // до конечного значений
    private static ClosedInjectionStep injectionRampRateProfile() {
        return rampConcurrentUsers(START_USER_COUNT)
                .to(END_USER_COUNT)
                .during(Duration.ofSeconds(WORK_UNDER_PRESSURE));
    }

}