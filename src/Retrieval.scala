import scala.xml.{Elem, NodeSeq, XML}

object GetUrlContent extends App {
  val url = "https://smstestbed.nist.gov/vds/current?path=//Devices//Device[@name=%22Mazak01%22]"
  val result = scala.io.Source.fromURL(url).mkString
  val xml: Elem = XML.loadString(result)
  println(xml)
  println("#########################################################")
  val test: NodeSeq = xml \ "Streams" \ "DeviceStream" \ "ComponentStream" \ "Events"
  test map {
    value =>
      println(value)
  }
}

//http://bcomposes.com/2012/05/04/basic-xml-processing-with-scala/