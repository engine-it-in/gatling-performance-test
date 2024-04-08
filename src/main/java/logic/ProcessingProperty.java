package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.ProcessingException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import model.ConfigProperty;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Component processing property from config.properties
 */
@UtilityClass
@Slf4j
public class ProcessingProperty {
    private static final ObjectMapper objectMapper =
            new ObjectMapper();

    /**
     * Получить значения из config.properties
     *
     * @return Property объект
     */
    public static ConfigProperty getConfigProperty() {
        log.info("Load properties file config.properties");
        return objectMapper.convertValue(
                loadPropertiesFromFile("config.properties"),
                ConfigProperty.class);
    }

    /**
     * Загрузить содержимое файла
     *
     * @param fileProperties - название файла с конфигурационными переменными
     * @return содержимое файла
     */
    private static Properties loadPropertiesFromFile(String fileProperties) {

        Properties properties = new Properties();

        try (InputStream inputStream =
                     ProcessingProperty.class.getClassLoader()
                             .getResourceAsStream(fileProperties)) {

            properties.load(inputStream);
        } catch (IOException exception) {
            throw new ProcessingException(
                    String.format(
                            "Ошибка при обработке конфигурационных переменных : %s", exception.getMessage()));
        }
        return properties;
    }

}