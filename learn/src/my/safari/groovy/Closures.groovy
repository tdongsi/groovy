package my.safari.groovy

/**
 * Created by tdongsi on 4/13/17.
 */

List nums = [9,6,7,5,8,6,4,2,3]
for (int num: nums) {
    // println num
}

for (num in nums) {
    // println num
}

nums.each( { num ->
    // println num
}
)

println nums.collect { it * 2 }         // map
    .findAll { it % 3 == 0 }    // filter
    .sum()                      // reduce

println nums.collect { it*2 }
// Spread dot operator
println nums *. multiply(2)

class Department {
    Manager boss
}
class Manager {
    String name
}
Department d1 = new Department(boss: new Manager(name: 'ABC'))
Department d2 = new Department()
println d1 ?. boss ?. name
// Standard d2.boss.name will throw NPE.
println d2 ?. boss ?. name

// Spaceship operator
println 1 <=> 2

// Groovy truth
// Elvis operator
String input
String greet = 'Hello ' + (input ?: 'World')
println greet

// Demo: Closure as filter
println ((-3..3).findAll { it > 0 } )

(0..15).each { Number n ->
    println Integer.toBinaryString(n).padLeft(4, '0')
}