package my.safari.groovy.basic

/**
 * Created by tdongsi on 8/13/17.
 * Based on https://www.youtube.com/watch?v=URkFOLywex4
 */

def foo(value, Closure closure) {
    closure(value * 2)
}

foo( 3, {println it })

foo(3) {
    println it
}

// Delegates ~ protype inheritance
// `this` corresponds to the enclosing class where the closure is defined (never a Closure)
// `owner` corresponds to the enclosing object where the closure is defined, which may be either a class or a closure
// `delegate` corresponds to a third party object where methods calls or properties are resolved
// whenever the receiver of the message is not defined
// By default, the delegate is set to owner.

def greet = { name -> println "hello $name" }
greet('Joe')

def greet2 = { name -> println "${toUpperCase()} $name" }
def salutes = ['hello', 'howdy']
for (salute in salutes) {
    greet2.delegate = salute
    greet2 'Joe'
}

def t = 'Teapot'
def upperCaseNameUsingVars = { t.toUpperCase() }
println upperCaseNameUsingVars()

def p = 'Norman'
def upperCaseName = { delegate.toUpperCase() } // === {toUpperCase()}
upperCaseName.delegate = p
println upperCaseName()

// The difference is
// 1) t is the local variable that can be referenced
// 2) delegate can be used transparently.

// Memoization: The cache used in all memoize variants is a LRU cache.
