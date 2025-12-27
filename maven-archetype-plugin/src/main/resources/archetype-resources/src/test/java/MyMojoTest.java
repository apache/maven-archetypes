package $package;

##
## Copyright 2001-2005 The Apache Software Foundation.
##
## Licensed under the Apache License, Version 2.0 (the "License");
## you may not use this file except in compliance with the License.
## You may obtain a copy of the License at
##
##      http://www.apache.org/licenses/LICENSE-2.0
##
## Unless required by applicable law or agreed to in writing, software
## distributed under the License is distributed on an "AS IS" BASIS,
## WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
## See the License for the specific language governing permissions and
## limitations under the License.
##

import org.apache.maven.api.plugin.testing.InjectMojo;
import org.apache.maven.api.plugin.testing.MojoTest;
import org.apache.maven.api.plugin.testing.MojoExtension;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.apache.maven.api.plugin.testing.MojoExtension.getBasedir;

import java.io.File;

@MojoTest
public class MyMojoTest {

    /**
     * @throws Exception if any
     */
    @Test
    @InjectMojo(goal = "touch", pom = "classpath:/project-to-test/pom.xml")
    public void testSomething(MyMojo myMojo) throws Exception {

        myMojo.execute();

        File outputDirectory = (File)MojoExtension.getVariableValueFromObject(myMojo, "outputDirectory");
        assertNotNull(outputDirectory);
        assertTrue(outputDirectory.exists());

        File touch = new File(outputDirectory, "touch.txt");
        assertTrue(touch.exists());

        File expectedOutputDirectory = new File(getBasedir(), "target/test-harness/project-to-test");
        assertEquals(expectedOutputDirectory, outputDirectory);
    }

    /**
     * Do not need the Mojo.
     */
    @Test
    public void testSomethingWhichDoesNotNeedTheMojoAndProbablyShouldBeExtractedIntoANewClassOfItsOwn() {
        assertTrue(true);
    }
}

