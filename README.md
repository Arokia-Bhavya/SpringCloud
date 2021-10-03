# SpringCloud
***12 factor***
- code base (github,gitlab,bitbucket)
- dependencies (pom.xml in maven)
- config (spring clod config and profiling)
- backing services (datasource,mq resource config in app.properties)
- Build,release,run (use of CI/CD tools like jenkins,concourse)
- Stateless Processes (avoid sticky sessions and store user session info in redis or memcached)
- Port Binding (defining port in application.properties or docker command)
- Concurrency (horizontal scaling)
- Disposability (use of load balancer and heathcheck url configuration)
- Dev/Prod parity (use of docker helps us to achieve same environment across stages)
- Logs (use of splunk,ELK,DataDog helps to consume logs as event stream)
- Admin processes (triggering processes like one time script,db backup should follow the codebase,config and release)

***Spring cloud config***
- helps to manage the properties across microservices and profiles
- All microservices has to be registered as config client (add dependency in pom.xml)
- @EnableConfigServer annotation in Config server

***Eureka Server***
- All microservices has to be registered as eureka client (add dependency in pom.xml)
- @EnableEurekaServer annotation in Config server


***Load Balancer***
- helps to route traffic to different clients
- -Dserver.port configuration to generate random port
- setting different profile while running spring boot app

***API Gateway***
- helps to route traffic to different servers
- If it is registered as eureka client then route paths can be configured using eureka service id
- If it is spring cloud project then route paths can be configured using host url

***Circuit Breaker***

***Distributed Tracing***

***Spring Cloud Stream***
