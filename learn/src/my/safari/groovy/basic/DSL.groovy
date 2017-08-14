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
        println "Shell: $script"
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
        println "Shell: $script"
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
        println "Shell: $script"
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

    static void executeBetter(Closure closure) {
        GroovyDsl body = new GroovyDsl()
        // TRICKY: Modify the input var? Hmmm.
        closure.delegate = body
        closure()
        println "Executing ..."
    }

    static void executeBest(Closure closure) {
        GroovyDsl body = new GroovyDsl()
        body.with(closure)
        println "Executing ..."
    }

}

println "3) Standard Groovy implementation"
GroovyDsl.execute { dsl ->
    dsl.withEnv("PATH=/usr/bin")
    dsl.echo("Starting pipeline")
    dsl.sh("ls .")
    dsl.error("Error here")
}
println ""

println "4) DSL-style Groovy implementation"
GroovyDsl.executeBetter {
    withEnv("PATH=/usr/bin")
    echo("Starting pipeline")
    sh("ls .")
    error("Error here")
}
println ""

println "4b) DSL-style Groovy (better) implementation"
GroovyDsl.executeBest {
    withEnv("PATH=/usr/bin")
    echo("Starting pipeline")
    sh("ls .")
    error("Error here")
}
println ""
