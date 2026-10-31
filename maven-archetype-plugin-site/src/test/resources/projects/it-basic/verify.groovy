File site = new File(basedir, 'project/basic-plugin-site/target/site')
for (String page in ['index.html', 'usage.html', 'examples/example.html', 'project-info.html']) {
    assert new File(site, page).isFile() : page + ' was not rendered'
}
// the site name comes from the artifactId, not from a literal placeholder
String title = (new File(site, 'index.html').text =~ /<title>([^<]*)<\/title>/)[0][1]
assert title.endsWith('basic-plugin-site') : 'index.html has title "' + title + '"'
