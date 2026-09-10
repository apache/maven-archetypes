// the default locale renders at the root of the site, the additional one below it
assert new File(context.projectDir, 'target/site/index.html').isFile();
assert new File(context.projectDir, 'target/site/fr').isDirectory();
assert new File(context.projectDir, 'target/site/fr/index.html').isFile();