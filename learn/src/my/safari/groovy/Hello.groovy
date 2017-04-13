package my.safari.groovy

/**
 * Created by tdongsi on 3/30/17.
 */

println "Hello World"
println InetAddress.localHost

int x = 3
int y = 4
assert 7 == x + y
// assert 7 == x + y + 1

def a = 1
println a.class.name
println 9876432198764321.class.name

def b = 0.2
println b.class.name
println ''

/*
 * Strings in Groovy
 */

def s = 'This is a string'
println s.reverse()
println s.class.name

/*
 * Operator overloading for String
 * http://docs.groovy-lang.org/latest/html/groovy-jdk/java/lang/CharSequence.html
 */
println s + ' and more' // plus()
println s - 'is' // minus()
println 'abc' * 3 // multiply()
println s[-1] // getAt()
println s[0..3]

s = "This is a string ${1+1}"
println s
println s.class.name