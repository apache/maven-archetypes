assert new File(context.projectDir, 'target/site').exists();
assert new File(context.projectDir, 'target/site').isDirectory();
assert new File(context.projectDir, 'target/site/index.html').exists();
assert new File(context.projectDir, 'target/site/index.html').isFile();