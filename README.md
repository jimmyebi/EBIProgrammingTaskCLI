# Programming task Software Developer (EBI_00971)


You are given a list of comma separated accession numbers as input.

An accession number has the following format: L...LN...N (e.g. AB1234)

where L...L denotes one or more ASCII7 letters and N denotes one or more digits (0,1,2,3,4,5,6,7,8 or 9).

Please return an ordered list of accession numbers where any consecutive digits N...N that share the same prefix L...L are collapsed into an accession number range.
	
An accession number range has the following format : L...LN...N-L...LN...N (e.g. A00001-A00005).

Please note that the N...N digits are left padded using 0s (e.g. 00001) and that the length of the N...N digits must be the same for accession numbers to be part of the same accession number range.

Example input:

(can be found in the following path: EBIProgrammingTaskCLI/src/main/resources/inputSample.txt) 

A00000, A0001, ERR000111, ERR000112, ERR000113, ERR000115, ERR000116, ERR100114, ERR200000001, ERR200000002, ERR200000003, DRR2110012, SRR211001, ABCDEFG1

Expected output:
A00000, A0001, ABCDEFG1, DRR2110012, ERR000111-ERR000113, ERR000115-ERR000116, ERR100114, ERR200000001-ERR200000003, SRR211001 


## How to build and run the project

This application was created and tested successfully using Java 8, Maven and NetBeans 8.2 IDE on MacOS.

Netbeans can be used to compile / build / run the tests, directly from the IDE tools,
however these tasks can also be accomplished from the CLI following the steps below:

### To compile/build the application using Maven and the command line or terminal:

1) From the command line, change directory to the cloned folder (/EBIProgrammingTaskCLI), then type: 

        mvn package

2) Maven will generate the .jar file in the target folder: 

        EBIProgrammingTaskCLI/target/EBIProgrammingTaskCLI-0.1.jar

3) To run the program from the /target folder, using the sample file as input and writing the result to a file, type: 

        java -jar EBIProgrammingTaskCLI-0.1.jar < ../src/main/resources/inputSample.txt > output.txt


## To run the test file:

1) From the command line, change directory to the cloned folder (/EBIProgrammingTaskCLI), and type:

        mvn test
