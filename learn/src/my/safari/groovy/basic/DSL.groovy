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
    }

    void execute() {
        println "Executing ..."
    }

}

println "1) Standard Java implementation"
JavaDsl javaDsl = new JavaDsl()
javaDsl.withEnv("PATH=/usr/bin")
javaDsl.echo("Starting pipeline")
javaDsl.sh("ls .")
javaDsl.error("Error here")
javaDsl.execute()
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
        return this
    }

    void execute() {
        println "Executing ..."
    }
}

println "2) Fluent Java implementation (Builder)"
JavaBuilderDsl builderDsl = new JavaBuilderDsl()
builderDsl.withEnv("PATH=/usr/bin")
        .echo("Starting pipeline")
        .sh("ls .")
        .error("Error here")
        .execute()
println ""


/**
 * Groovy code with standard implementation
 * Try to simulate some kind of DSL like Pipeline steps in Jenkins
 */
class GroovyDsl {

    def echo(String message) {
        println "Echo: $message"
    }

    def sh(String script) {
        println "Executing: $script"
    }

    def error(String message) {
        println "Error here: $message"
    }

    // A more advanced DSL
    def withEnv(String var) {
        println "Using: $var"
    }

    static void execute(closure) {
        GroovyDsl body = new GroovyDsl()
        closure(body)
        println "Executing ..."
    }

}

println "3) Standard Groovy implementation"
GroovyDsl.execute { it ->
    it.withEnv("PATH=/usr/bin")
    it.echo("Starting pipeline")
    it.sh("ls .")
    it.error("Error here")
}
