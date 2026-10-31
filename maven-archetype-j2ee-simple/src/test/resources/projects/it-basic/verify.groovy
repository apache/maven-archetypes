import java.util.zip.ZipFile

File ear = new File(basedir, 'project/basic-j2ee-simple/ear/target/ear-0.1-SNAPSHOT.ear')
assert ear.isFile() : 'the generated project did not package an ear'
ZipFile zip = new ZipFile(ear)
try {
    // one entry per module the ear must bundle
    for (String entry in ['META-INF/application.xml',
                          'archetype.it-ejbs-0.1-SNAPSHOT.jar',
                          'archetype.it-primary-source-0.1-SNAPSHOT.jar',
                          'archetype.it-servlet-0.1-SNAPSHOT.war']) {
        assert zip.getEntry(entry) != null : entry + ' is missing from the ear'
    }
} finally {
    zip.close()
}
