# OpenSchool2-Metrics
Monitoring system using Kafka and Spring Actuator  

## How to run the application
- Download and start Kafka according to the [instructions](https://kafka.apache.org/quickstart#quickstart_startserver)

## How to test the application
- Send current metrics to the topic via Producer:  
`
curl -X POST http://localhost:8080/metrics
`
- Get all metrics via Consumer:    
`
curl -X GET http://localhost:8081/metrics
`
- Get metric with id 1:    
`
curl -X GET http://localhost:8081/metrics/1
`


## Used Kafka configuration:



## Some Kafka commands (to be executed from downloaded Kafka folder)
- Start Zookeeper  
`
bin/zookeeper-server-start.sh config/zookeeper.properties
`
- Start the Kafka server  
`
bin/kafka-server-start.sh config/server.properties
`  
- Delete all messages from the topic  
`
bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic metrics-topic
`
- Show all messages from the topic  
`
bin/kafka-console-consumer.sh --topic metrics-topic --from-beginning --bootstrap-server localhost:9092
`  
