# Autocomplete
A scala project to implement fast prefix search to provide autocomplete solutions 

##Problem definition 

![Autocomplete problem](ex004-autocomplete.pdf)

##Implementation details

This problem is implemented in Scala by using the **Prefix tree/trie** data structure.

Trie  is  an  ordered  multi-way tree  data  structure  that  is  used  to  store strings over an alphabet.Each  node  contains  an  array  of each character in the alphabet and all the descendants of a node have a common prefix of the string associated with that node. The root is associated with the empty string and values are normally not associated with every node, only with leaves.

A trie is a tree data structure that allows strings  with similar character prefixes to use the same prefix data and store only the tails as  separate data. One character of the string  is stored at each level of the tree, with the first character of the string stored at the root.

##How to run

Before cloning and running Autocomplete on your machine make sure:

    1. You have a JDK8 installed on your machine
    2. JAVA_HOME system variable pointing to JDK8
    3. $JAVA_HOME\bin is present in your system path
    4. You have SBT installed (if not then refer: http://www.scala-sbt.org/download.html)
    5. SBT_installation_path\bin is present in your system path variable
    6. You have GIT installed on your machine

To run this application:

    1. Clone this to your machine by using the follwong command
        - git clone https://github.com/HimanshuArora1234/Autocomplete.git
    2. Once cloned run the following command on the root directory of project
        - sbt run 
          
PS. `sbt run` will automatically find the `Runner.scala` object which is the Scala App object to kick start this program.

##Answers of the optional questions

1. What would you change if the list of keywords was large (several millions)?

    ```
    When it comes to stroing a large amount of data, the data structure that comes in handy is HastTable which stores data into an array of buckets (linked-list).
    
    But in this case we are supposed to preform autocomplete (prefix search) with sorted results. Hence I will stick with the implemenation of Trie done using TreeMap.
    ```

2. What would you change if the requirements were to match any portion of the
keywords ?
    
    ```
    To match any portion, we will need to use a pattern matching algorithm. As for exemple Knuth–Morris–Pratt algorithm which searches for occurrences of a "word" within a "text string".
    
    But given the problem, we are not dealing with a single string but a large number of strings. In that case instead of constructing a prefix tree data structure we will need a Suffix tree data structure to perform a full text search.
    ```


