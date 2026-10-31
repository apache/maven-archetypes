File site = new File(basedir, 'project/basic-plugin-site/target/site')
for (String page in ['index.html', 'usage.html', 'examples/example.html', 'project-info.html']) {
    assert new File(site, page).isFile() : page + ' was not rendered'
}
