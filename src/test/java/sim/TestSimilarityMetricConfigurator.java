package sim;

import utils.ConfigurationFile;
import utils.TestUtils;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.*;

public class TestSimilarityMetricConfigurator {
    @Test
    public void testBuild() throws ConfigurationFile.ConfigurationException, IOException, InterruptedException {
        List<SimilarityMetric> models = TestUtils.buildAllModels();
        assertEquals(models.size(), 6);
    }

}
