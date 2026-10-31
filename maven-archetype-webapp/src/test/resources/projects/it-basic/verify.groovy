import java.util.zip.ZipFile

File war = new File(basedir, 'project/basic-webapp/target/basic-webapp.war')
assert war.isFile() : 'the generated project did not package a war'
ZipFile zip = new ZipFile(war)
try {
    assert zip.getEntry('WEB-INF/web.xml') != null : 'web.xml is missing from the war'
    assert zip.getEntry('index.jsp') != null : 'index.jsp is missing from the war'
} finally {
    zip.close()
}
