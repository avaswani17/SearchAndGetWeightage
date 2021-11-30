#The project is for getting the wightage of input words based on their occurance in the files.

#Run jar with below command:-
scala search.jar <pathToDirectoryContainingTextFiles>

#Attached is the code generated in intellij IDE
-\src\main\scala\com.adevinta\Searcher.scala contains the implementation code. 
-\src\test\scala\TestSearcher.scala contains respective test cases.
-TestDir folder contains files for testing,used by test cases.
-build.sbt file contains defination of dependencies.

#Future expansion:-
-I have created a map with each words frequency in sentence so if we want to expand our ranking more deeply then it will be helpful.
-I have also included the functionality to break the loop if someone prints 'quit'.

#Notes:-
-jar has been generated using 'sbt package' command.
-complete code is written in scala '2.13.6' version.