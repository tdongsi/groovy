package my.safari.groovy.basic

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

// Demo: Sorting strings
List<String> strings = 'this is a list of strings'.split()

// Java way: natural ordering
Collections.sort(strings)
println strings

// Java: sort by length
Collections.sort(strings, new Comparator<String>() {
    int compare(String s1, String s2) {
        s1.size() <=> s2.size()
    }
})
println strings
println strings.collect { it.size() }
println strings *. size()

// Groovy: natural ordering and not destructive
println strings.sort(false)
println strings

// Groovy: sort by length in reverse
println strings.sort(false) { s1, s2 ->
    s2.size() <=> s1.size()
}

// Groovy: with one-param closure
println strings.sort(false) { it.size() }

// Groovy: sort by length, then reverse-alphabetically
println strings.sort(false) { String s1, String s2 ->
    (s1.size() <=> s2.size()) ?: s2 <=> s1
}

// Demo: summing a collection
List<Integer> dnums = [3,1,4,1,5,9,2,6,5]
assert dnums.sum() == 36
// Sum of squares
// Equivalent to dnums.colllect{ it**2 }.sum()
assert dnums.sum{ it ** 2 } == 198
assert dnums *. power(2) . sum() == 198

// Use inject(). Similar to reduce() in functional programming.
assert 198 == dnums.inject(0) { acc, val ->
    acc + val*val
}
