package my.safari.groovy.basic

import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

/**
 * Created by tdongsi on 4/16/17.
 */

def MYFILE = '/Users/tdongsi/Matrix/Aqueduct/settings.xml'
def inFile = new File( MYFILE )
def outFile = new File( 'temp.xml')
def xml = new XmlSlurper(false, false).parse(inFile)

println xml.servers.server[0].username
println xml.servers.server[0].password

/*
xml.servers.server[0].username = 'user101'
xml.servers.server[0].password = 'password123'
*/

xml.servers.server.each { node ->
    node.username = 'user101'
    node.password = 'password123'
}

def outBuilder = new StreamingMarkupBuilder()
def outWriter = outFile.newWriter()
XmlUtil.serialize( outBuilder.bind{ mkp.yield xml }, outWriter )

/*
infile.withWriter { outWriter ->
    XmlUtil.serialize( new StreamingMarkupBuilder().bind( mkp.yield xml ), outWriter)
}
*/