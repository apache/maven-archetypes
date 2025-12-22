assert new File(context.projectDir, 'target/site/en').exists();
assert new File(context.projectDir, 'target/site/fr').isDirectory();
assert new File(context.projectDir, 'target/site/en/index.html').exists();
assert new File(context.projectDir, 'target/site/fr/index.html').isFile();