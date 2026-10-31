// the default locale renders at the root of the site, the additional one below it
assert new File(context.projectDir, 'target/site/index.html').isFile();
assert new File(context.projectDir, 'target/site/fr').isDirectory();
assert new File(context.projectDir, 'target/site/fr/index.html').isFile();
// the site name comes from the artifactId, not from a literal placeholder
for (String page in ['target/site/index.html', 'target/site/fr/index.html']) {
    String title = (new File(context.projectDir, page).text =~ /<title>([^<]*)<\/title>/)[0][1]
    assert title.endsWith('basic-site') : page + ' has title "' + title + '"'
}
