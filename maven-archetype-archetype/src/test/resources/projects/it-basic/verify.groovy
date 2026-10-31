import java.util.zip.ZipFile

File archetype = new File(basedir, 'project/basic-archetype/target/basic-archetype-0.1-SNAPSHOT.jar')
assert archetype.isFile() : 'the generated archetype was not packaged'
ZipFile zip = new ZipFile(archetype)
try {
    assert zip.getEntry('META-INF/maven/archetype-metadata.xml') != null : 'archetype descriptor is missing'
    assert zip.getEntry('archetype-resources/pom.xml') != null : 'archetype template pom is missing'
} finally {
    zip.close()
}

// the generated archetype ships its own IT; "verify" must have run it and generated a project from the archetype
File nested = new File(basedir, 'project/basic-archetype/target/test-classes/projects/it-basic/project/basic-project/pom.xml')
assert nested.isFile() : 'the archetype IT of the generated archetype did not generate its project'
