Deletes all topics from the topic  
`
bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic metrics-topic
`

Shows all messages from the topic  
`
bin/kafka-console-consumer.sh --topic metrics-topic --from-beginning --bootstrap-server localhost:9092
`
