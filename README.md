# JAVA STREAMS API :computer:

##### _¿What is it?_
Introduced in Java 8, the **Stream API** is used to process collections of objects. A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.

![Java Streams](https://miro.medium.com/max/1200/0*4UTBGNR_nB8DOI3n)

The features of Java stream are –
- A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
- Streams **don’t change the original data structure**, they only provide the result as per the pipelined methods.
- Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined. Terminal operations mark the end of the stream and return the result.

<p align="center"> ```SOURCE + (n * INTERMEDIATE METHODS) + TERMINAL METHOD ``` </p>

- A stream consists of **source** followed by zero or more **intermediate methods** combined together and a **terminal method** to process the objects obtained from the source as per the methods described.
- Stream is used to compute elements as per the pipelined methods without altering the original value of the object.

###### Intermediate Operations Example:
- map, filter, sorted, peek

###### Terminal Operations Example:
- collect, forEach, reduce, sum

###### Use cases: 
- File: ``./JavaStreamsAPI/src/streamsAPI/StreamsAPI.java``
______

##### Sources: 
- [https://stackify.com/streams-guide-java-8/](https://stackify.com/streams-guide-java-8/)
- [https://www.geeksforgeeks.org/stream-in-java/](https://www.geeksforgeeks.org/stream-in-java/) 

######  by · [Maria Eugenia Matto](https://www.linkedin.com/in/maria-matto/) :zap:

