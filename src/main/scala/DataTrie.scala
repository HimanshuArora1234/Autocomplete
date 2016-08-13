import scala.collection.immutable.TreeMap

/**
 * A prefix tree (trie) data structure used to store the string data to perform efficient prefix search.
 * It can be used to provide auto-complete solutions backed by a fast data search.
 * For more details refer https://en.wikipedia.org/wiki/Trie
 * @param character key of the nodes, None for root node
 * Created by arorah on 12/08/2016.
 */
class DataTrie(character: Option[Char]) {

  /**
   * To store the children of a node using TreeMap data structure.
   * TreeMap stores data in lexical/alphabetical order.
   */
  var children = new TreeMap[Char, DataTrie]
  /**
   * While adding a word to this trie, the last character node will not have any children. So storing the whole word with this node.
   * Needed while returning the matched string as a result of prefix search.
   * Only leaf node will contain the value in `mayBeWord`.
   */
  var mayBeWord: Option[String] = None

  //Function to insert new word in trie
  def addData(data: String): DataTrie = add(data, data.toLowerCase.replaceAll(" ", ""))  //Lowercase called to make search case-insensitive and there is no need to store spaces as nodes

  /**
   * This function inserts a word character by character.
   * For each char of the data, it checks if the char has already been inserted.
   * If so then there is no need to insert that char but rather call recursive this same function to insert the remain chars as the children of the node of current char.
   * But if the current char has not already been inserted then this function creates a new node for that char and inserts it in the TreeMap and then calls recursively to
   * itself to insert the remain chars as children of this last inserted node.
   * @param data a copy of original data, used to set `mayBeWord` for leaf nodes
   * @param suffix suffix of the word to be inserted, same as the data being searched at the beginning
   */
  private def add(data: String, suffix: String): DataTrie = {
    suffix.toList match {
      case Nil => {
        this.mayBeWord = Some(data)
        this
      }
      case head::tail => {
        this.children.get(head).fold{
          val newNode = new DataTrie(Some(head))
          this.children = this.children.insert(head, newNode)
          newNode.add(data, tail.mkString)
        }(_.add(data, tail.mkString))
      }
    }
  }

  //Find the root node whose prefix tree (including the node itself) is the data provided in arguments.
  private def findNode(data: String): Option[DataTrie] = data.toLowerCase.replaceAll(" ", "").toList match {
    case Nil => Some(this)
    case head::tail => this.children.get(head).flatMap(_.findNode(tail.mkString))
  }

  //To find all the leaf nodes containing complete words
  private def findAllWords: List[String] = {
    this.mayBeWord.toList ++ this.children.values.flatMap(_.findAllWords)
  }

  //Prefix search function, returns list of matched words
  def search(text: String): List[String] = {
    findNode(text).toList.flatMap(_.findAllWords)
  }

}

