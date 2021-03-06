
/**
 * Program runner object.
 * Created by arorah on 12/08/2016.
 */
object Runner extends App {
  //Instantiating and inserting the test data into the trie data structure
  val dataTrie = new DataTrie(None)
  val inputDataList = List("Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv Priceline", "Press democrat",
    "Progressive", "Project runway", "Proactive", "Programming", "Progeria", "Progesterone", "Progenex", "Procurable",
    "Processor", "Proud", "Print", "Prank", "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe"
  )
  inputDataList.foreach(dataTrie.addData(_))

  //Infinite loop to let user search as many time as he/she wants
  while(true) {
    println("Either enter the text to be searched or just hit Ctrl+C to stop")
    val input = scala.io.StdIn.readLine()
    if(input != null) {
      val t0 = System.nanoTime()
      //Firing the search algorithm
      val res = dataTrie.search(input, 4)
      val t1 = System.nanoTime()
      if(res.isEmpty) {
        println("No match found")
      } else {
        println("Found matches are as following : ")
        res.foreach(println)
        println("Total execution time = " + (t1 - t0) / 1000000000.0 + " Sec")
      }
    }
  }

}
