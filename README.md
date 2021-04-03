# Memory test for Classic Producer Consumer

Vary the queue size, producer rate, consumer rates, # of producers, # of consumers, delays, etc.

The program randomly produces and inserts fake users and fake quotes to a `BlockingQueue` structure and consumes (polls) from the queue. 

A program like [VisualVM](https://visualvm.github.io) can be used to profile the memory growth.

![alt text](docs/scrn.png)

## Instructions

Clone the project and run `App.java` file.

**Disclaimer**: *All configs are in `Constants` interface. Note that this is only a test program, and not intended to be deployed as an e2e solution. Therefore, best practices regarding program configuration, tests and deployments may not be adhered to here.*