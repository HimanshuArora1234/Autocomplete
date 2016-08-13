# Autocomplete
A scala project to implement fast prefix search to provide autocomplete solutions 

##Problem definition 

![Autocomplete problem](ex004-autocomplete.pdf)

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
          
PS. `sbt run` will automatically find the `Runner.scala` object which is the Scala App class to kick start this program.
