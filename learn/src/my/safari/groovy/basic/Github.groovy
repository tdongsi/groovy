package my.safari.groovy.basic

import groovy.json.JsonSlurper

/**
 * Created by tdongsi on 4/18/17.
 */

String username = System.getenv('GITHUB_USERNAME')
String password = System.getenv('GITHUB_PASSWORD')

String GITHUB_API = 'https://api.github.com/repos'
String repo = 'groovy'
String PR_ID = '2' // Pull request ID

String url = "${GITHUB_API}/${username}/${repo}/pulls/${PR_ID}"
println "Querying ${url}"
def text = url.toURL().getText(requestProperties: ['Authorization': "token ${password}"])
def json = new JsonSlurper().parseText(text)
def bodyText = json.body

// Check if Pull Request body has certain text
if ( bodyText.find('Safari') ) {
    println 'Found Safari user'
}

String cmd = "curl -s -H \"Authorization: token ${password}\" ${url}"
println "Equivalent shell command: $cmd"
println cmd.execute().text