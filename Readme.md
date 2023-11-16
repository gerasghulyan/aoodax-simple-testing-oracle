# Integration tests
source: https://hub.docker.com/r/gvenzl/oracle-xe

Currently, there is no Oracle Database port for ARM chips, hence Oracle XE images cannot run on the new Apple M chips via Docker Desktop.
Fortunately, there are other technologies that can spin up x86_64 software on Apple M chips, such as colima. To run these Oracle XE images on Apple M hardware, follow these simple steps:

Install colima (instructions)
Run

``colima start --arch x86_64 --memory 4``

Wait unit will see **done** log
Start container as usual

TO exclude integration tests in gradle build just call 

```gradle clean build -PintegrationTests=false```