package guru.qa.rococo.jupiter.extension;

import guru.qa.rococo.api.impl.AllureDockerApiClient;
import guru.qa.rococo.model.allure.AllureResult;
import guru.qa.rococo.model.allure.AllureResults;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

public class AllureResultsDockerExtension implements SuiteExtension {
    private static final boolean isDocker = "docker".equals(System.getProperty("test.env"));
    private static final AllureDockerApiClient allureApiClient = new AllureDockerApiClient();
    private static final String PROJECT_ID = "rococo";
    private static final String ALLURE_RESULTS_DIRECTORY = "./rococo-tests/build/allure-results";

    @Override
    public void beforeSuite(ExtensionContext context) {
        if (isDocker) {
            allureApiClient.createProjectIfNotExist(PROJECT_ID);
        }
    }

    @Override
    public void afterSuite() {
        if (isDocker) {
            final Base64.Encoder encoder = Base64.getEncoder();
            final List<AllureResult> results = new ArrayList<>();

            try (Stream<Path> filePathStream = Files.walk(Paths.get(ALLURE_RESULTS_DIRECTORY))) {
                filePathStream
                        .filter(Files::isRegularFile)
                        .forEach(filePath -> {
                            try (InputStream is = Files.newInputStream(filePath)) {
                                results.add(
                                        new AllureResult(
                                                filePath.getFileName().toString(),
                                                encoder.encodeToString(is.readAllBytes())
                                        )
                                );
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });

                allureApiClient.uploadResults(
                        PROJECT_ID,
                        new AllureResults(results)
                );

                allureApiClient.generateReport(
                        PROJECT_ID,
                        System.getenv("HEAD_COMMIT_MESSAGE"),
                        System.getenv("BUILD_URL"),
                        System.getenv("EXECUTION_TYPE")
                );

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
