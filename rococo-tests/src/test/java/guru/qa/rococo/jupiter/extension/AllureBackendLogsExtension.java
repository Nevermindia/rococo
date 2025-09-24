package guru.qa.rococo.jupiter.extension;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.TestResult;
import lombok.SneakyThrows;

import javax.annotation.ParametersAreNonnullByDefault;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@ParametersAreNonnullByDefault
public class AllureBackendLogsExtension implements SuiteExtension{

    private static final String caseName = "Rococo backend logs";

    @SneakyThrows
    @Override
    public void afterSuite() {
        final AllureLifecycle allureLifecycle = Allure.getLifecycle();
        final String caseId = UUID.randomUUID().toString();
        allureLifecycle.scheduleTestCase(new TestResult().setUuid(caseId).setName(caseName));
        allureLifecycle.startTestCase(caseId);
        attachLogForService(allureLifecycle, "rococo-auth log", ".logs/rococo-auth/app.log");
        attachLogForService(allureLifecycle, "rococo-artist log", ".logs/rococo-artist/app.log");
        attachLogForService(allureLifecycle, "rococo-gateway log", ".logs/rococo-gateway/app.log");
        attachLogForService(allureLifecycle,"rococo-geo log", ".logs/rococo-geo/app.log");
        attachLogForService(allureLifecycle,"rococo-museum log", ".logs/rococo-museum/app.log");
        attachLogForService(allureLifecycle,"rococo-painting log", ".logs/rococo-painting/app.log");
        attachLogForService(allureLifecycle,"rococo-userdata log", ".logs/rococo-userdata/app.log");

        allureLifecycle.stopTestCase(caseId);
        allureLifecycle.writeTestCase(caseId);
    }

    @SneakyThrows
    private static void attachLogForService(AllureLifecycle allureLifecycle, String name, String path){
        allureLifecycle.addAttachment(
                name,
                "text/html",
                ".log",
                Files.newInputStream(Path.of(path))
        );
    }
}
