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
- Admin processes
