package my.safari.groovy

/**
 * Created by tdongsi on 4/13/17.
 * Demo from Safari: Groovy Programming Fundamentals
 */

String XML_BASE = 'https://maps.googleapis.com/maps/api/geocode/xml?'
List address = ['2700 Coast Ave', 'Mountain View', 'CA']

String encoded = address.collect {
    URLEncoder.encode(it, 'UTF-8')
}.join(',')

String queryString = "address=$encoded"
String url = "$XML_BASE$queryString"
println url.toURL().text

def root = new XmlSlurper().parse(url)
def loc = root.result[0].geometry.location // Navigate DOM using dot
println "Coordinates: ${loc.lat}, ${loc.lng}"


String JSON_BASE = 'http://api.icndb.com/jokes/random'
