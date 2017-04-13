package my.safari.groovy

/**
 * Created by tdongsi on 4/12/17.
 */

Range r = 1..10
println r
println r.class.name

// Python range
Range p = 1..<10
println p

List nums = [3, 1, 2 ,5]
println nums.class.name
println nums[1..<3]

// List's operator overloading defined in
// http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/List.html