File descriptorFile = new File( basedir, "project/basic-maven-plugin/target/classes/META-INF/maven/plugin.xml" );
assert descriptorFile.isFile()

def pluginDescriptor = new XmlParser().parse( descriptorFile );

def mojo = pluginDescriptor.mojos.mojo.findAll{ it.goal.text() == "touch" }[0]

assert mojo.goal.text() == 'touch'
assert mojo.implementation.text() == 'it.pkg.plugin.MyMojo'
assert mojo.language.text() == 'java'
assert mojo.description.text() == 'Goal which touches a timestamp file.'
assert mojo.phase.text() == 'process-sources'

assert mojo.configuration.outputDirectory[0].text() == '${outputDir}'
assert mojo.configuration.outputDirectory[0].'@implementation' == 'java.io.File'
assert mojo.configuration.outputDirectory[0].'@default-value' == '${project.build.directory}'

def parameter = mojo.parameters.parameter.findAll{ it.name.text() == "outputDirectory"}[0]

assert parameter.name.text() == 'outputDirectory'
assert parameter.type.text() == 'java.io.File'
assert parameter.required.text() == 'true'
assert parameter.description.text() == 'Location of the file.'

File testFile = new File( basedir, "project/basic-maven-plugin/src/main/java/it/pkg/plugin/MyMojo.java" );
assert testFile.exists()

testFile = new File( basedir, "project/basic-maven-plugin/src/test/java/it/pkg/plugin/MyMojoTest.java" );
assert testFile.exists()

testFile = new File( basedir, "project/basic-maven-plugin/src/test/resources/project-to-test/pom.xml" );
assert testFile.exists()

testFile = new File( basedir, "project/basic-maven-plugin/src/it/simple-it/verify.groovy" );
assert testFile.exists()

testFile = new File( basedir, "project/basic-maven-plugin/src/it/simple-it/pom.xml" );
assert testFile.exists()

testFile = new File( basedir, "project/basic-maven-plugin/src/it/settings.xml" );
assert testFile.exists()

