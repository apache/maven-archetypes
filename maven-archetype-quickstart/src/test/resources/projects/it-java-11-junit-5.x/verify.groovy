import groovy.xml.XmlSlurper

// the JUnit BOM must bring a working Jupiter engine: surefire has to report the test as run
File report = new File(basedir, 'project/java-11-junit-5x-quickstart/target/surefire-reports/TEST-it.pkg.AppTest.xml')
assert report.isFile() : 'surefire did not run it.pkg.AppTest'
def suite = new XmlSlurper().parse(report)
assert suite.@tests.text() == '1' : 'expected one test in it.pkg.AppTest'
assert suite.@failures.text() == '0'
assert suite.@errors.text() == '0'
