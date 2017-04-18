package my.safari.groovy.basic

/**
 * Created by tdongsi on 4/18/17.
 */

String username = System.getenv('GITHUB_USERNAME')
String password = System.getenv('GITHUB_PASSWORD')

String GITHUB_API = 'https://api.github.com/repos/'
String repo = 'groovy'
String PR_ID = '1' // Pull request ID

String url = "${GITHUB_API}/${username}/${repo}/pulls/${PR_ID}"
println url
println url.toURL().getText(requestProperties: ['Authorization': "token ${password}"])
