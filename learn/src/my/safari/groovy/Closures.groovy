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

