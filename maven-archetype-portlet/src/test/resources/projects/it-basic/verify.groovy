import java.util.zip.ZipFile

File war = new File(basedir, 'project/basic-portlet/target/basic-portlet-0.1-SNAPSHOT.war')
assert war.isFile() : 'the generated project did not package a war'
ZipFile zip = new ZipFile(war)
try {
    for (String entry in ['WEB-INF/portlet.xml', 'WEB-INF/web.xml', 'WEB-INF/classes/it/pkg/MyPortlet.class']) {
        assert zip.getEntry(entry) != null : entry + ' is missing from the war'
    }
} finally {
    zip.close()
}
