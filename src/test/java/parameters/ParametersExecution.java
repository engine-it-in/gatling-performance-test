package parameters;

import dictionary.TestMode;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ParametersExecution {

    @UtilityClass
    public class ConnectionParameters {

        public static final Integer CONNECTIONS_PER_HOST = 100;

    }

    @UtilityClass
    public class AssertPerformanceParameters {

        public static final Integer GATE_FOR_RESPONSE_MILISECONDS = 1000;
        public static final Double PERCENT_SUCCESS_RESPONSE = 99d;

    }

    @UtilityClass
    public class PerformanceParameters {

        public static final int START_USER_COUNT
                = Integer.parseInt(System.getProperty("START_USER_COUNT", "1"));
        public static final int END_USER_COUNT
                = Integer.parseInt(System.getProperty("START_USER_COUNT", "10"));
        public static final int WORK_UNDER_PRESSURE
                = Integer.parseInt(System.getProperty("WORK_UNDER_PRESSURE", "120"));
        public static final TestMode TEST_MODE
                = TestMode.valueOf(System.getProperty("TEST_MODE", TestMode.CONSTANT.toString()));

    }

    @UtilityClass
    public class HeaderType {

        public static final String JSON_TYPE_HEADER = "application/json";

    }


}
