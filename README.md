# Producer-Consumer
This program will demonstrate a Producer-Consumer problem. the main idea is to have Producer to generate data 
while at the same time, having the consumer to consume the data. Both Producer and Consumer share the same 
fixed-size buffer that will be used as a queue. This program will take 3 inputs:

1. Sleep time
2. Producer threads
3. Consumer threads

After taking the inputs, the program will generate the producer threads & consumer threads based on the input.
While genrating/consuming the data, the program will print out the data.

To run this program:

>>javac ProducerConsumer.java
>>java ProducerConsumer *Sleep time* *Producer threads* *Consumer threads*
