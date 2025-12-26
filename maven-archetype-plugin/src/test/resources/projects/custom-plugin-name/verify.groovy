import groovy.xml.XmlParser

File descriptorFile = new File( basedir, "project/custom-plugin-name/target/classes/META-INF/maven/plugin.xml" )
assert descriptorFile.isFile()

def pluginDescriptor = new XmlParser().parse( descriptorFile );
assert pluginDescriptor.goalPrefix.text() == 'custom-plugin-name'
