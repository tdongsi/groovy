package my.safari.groovy

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by tdongsi on 4/12/17.
 */

@ToString
@EqualsAndHashCode
class Person {
    String first
    String last

    void setLast(String last) {
        println 'setter for this.last'
        this.last = last
    }

    /*
    String toString() {
        "$first $last"
    }
    */
}

Person p = new Person()
p.first = 'David'
p.last = 'Ortiz'
println "${p.getFirst()} ${p.last}"

Person e = new Person(first: 'Helen', last: 'Keller')
println "${e.getFirst()} ${e.last}"
println e

Person e_same = new Person(first: 'Helen', last: 'Keller')
println e == e_same

Set<Person> people = [p, e, e_same]
println people.size()

