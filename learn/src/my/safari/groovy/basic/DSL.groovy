package my.safari.groovy.basic

/**
 * Java code with standard implementation
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

println "1) Standard Java implementation"
JavaDsl javaDsl = new JavaDsl()
javaDsl.echo("Starting pipeline")
javaDsl.sh("ls .")
javaDsl.error("Error here")
javaDsl.withEnv("PATH=/usr/bin")
println ""

/**
 * Java code with Builder pattern
 * Try to simulate some kind of DSL like Pipeline steps in Jenkins
 */
class JavaBuilderDsl {

    JavaBuilderDsl echo(String message) {
        println "Echo: $message"
        return this
    }

    JavaBuilderDsl sh(String script) {
        println "Executing: $script"
        return this
    }

    JavaBuilderDsl error(String message) {
        println "Error here: $message"
        return this
    }

    // A more advanced DSL
    JavaBuilderDsl withEnv(String var) {
        println "Using: $var"
        println "Executing ..."
        return this
    }
}

println "2) Builder Java implementation"
JavaBuilderDsl builderDsl = new JavaBuilderDsl()
builderDsl.echo("Starting pipeline")
        .sh("ls .")
        .error("Error here")
        .withEnv("PATH=/usr/bin")
println ""

