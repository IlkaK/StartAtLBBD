# Spring Boot Actuator #

actuator = Bedienungselement, Ausloeser

### What value does Spring Boot Actuator provide? ###

- production grade monitoring without having to implement it yourself
- a framework to easily gather and return metrics
- integration with 3rd party dashboards => show health and metrics of distributed systems

### What are the two protocols you can use to access actuator endpoints? ###

- JMX and http endpoints

### What are the actuator endpoints that are provided out of the box? ###

actuator info, health and metric

### What is info endpoint for? How do you supply data? ###

- general data, custom data, build information or details about the latest commit

### How do you change logging level of a package using loggers endpoint? ###

- via ./actutor/logger
- log level can be configured during runtime
- POST a partial entity to the resources URI '{"configuredLevel":"INFO"}'

### How do you access an endpoint using a tag? ###

- metrics are tagged
- you can add a number of tag=KEY:VALUE query parameters to the end of the URL to dimensionally drill down on a meter
- e.g. /actuator/metrics/jvm.memory.max?tag=area:nonheaptag=id:Metaspace

### What is metrics for? ###

- SpringBootActuator provides dependency managment and auto-configuration for Micrometer => application metrics facade that supports numerous monitoring systems

### How do you create a custom metric with or without tags? ###

- register custom metrics => inject MeterRegistry

### What is Health Indicator? ###

- health information => checks status of running application
- Health indicator provides actual health information, including a status

### What are the Health Indicators that are provided out of the box? ###

- Cassandra, Couchbase, DataSource, DiskSpace, ElasticSearchRest, Hazelcast, InfluxDb, Jms, Ldap, Maiil, Mongo, Neokj, Ping, Rabbit, ReadinessState, Redis, Solr

### What is a Health Indicator status? ###

It shows in which state the component / subsystem is.

### What are the Health Indicator statuses that are provided out of the box? ###

Unknown, Up, Down, OutOfService

### How do you change the Health Indicator status severity order? ###
 
With the property management.health.status.order

### Why do you want to leverage (wirksam einsetzen) 3rd party external monitoring system? ###

Data from Actuator needs to be gathered, aggregated and graphed for easy consumption.