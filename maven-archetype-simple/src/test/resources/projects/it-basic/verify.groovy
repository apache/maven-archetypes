import groovy.xml.XmlSlurper

File project = new File(basedir, 'project/basic-simple')
File report = new File(project, 'target/surefire-reports/TEST-it.pkg.AppTest.xml')
assert report.isFile() : 'surefire did not run it.pkg.AppTest'
def suite = new XmlSlurper().parse(report)
assert suite.@tests.text() == '1' : 'expected one test in it.pkg.AppTest'
assert suite.@failures.text() == '0'
assert suite.@errors.text() == '0'

assert new File(project, 'target/basic-simple-0.1-SNAPSHOT.jar').isFile()
assert new File(project, 'target/site/index.html').isFile()
