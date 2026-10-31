File site = new File(basedir, 'project/basic-site-simple/target/site')
for (String page in ['index.html', 'markdown.html', 'markdown-velocity.html', 'project-info.html']) {
    assert new File(site, page).isFile() : page + ' was not rendered'
}
// Velocity reads a Markdown "##" heading as a comment, so the page only keeps its heading when the template escapes it
String velocity = new File(site, 'markdown-velocity.html').text
assert velocity.contains('<h2>Markdown Format with Velocity works</h2>') : 'the Velocity page lost its heading'
