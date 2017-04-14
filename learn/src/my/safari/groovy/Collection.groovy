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

def map = [a: 1, b: 2, c: 2]
map.d = 3
map['e'] = 1
println map
println map.getClass().name

def mNums = [3, 1, 4,1,5,9,2,6,5] as Set
println mNums
println mNums.class.name

