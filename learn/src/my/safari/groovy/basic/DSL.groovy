package my.safari.groovy.basic

/**
 * Java style for Build pattern
 * Try to simulate some kind of DSL like Pipeline steps in Jenkins
 */
class JavaDsl {

    void echo(String message) {
        println "Echo: $message"
    }

    void sh(String script) {
        println "Executing: $script"
    }

    void error(String message) {
        println "Error here: $message"
    }

    // A more advanced DSL
    void withEnv(String var) {
        println "Using: $var"
        println "Executing ..."
    }

}

JavaDsl javaDsl = new JavaDsl()
javaDsl.echo("Starting pipeline")
javaDsl.sh("ls .")
javaDsl.error("Error here")
javaDsl.withEnv("PATH=/usr/bin")

