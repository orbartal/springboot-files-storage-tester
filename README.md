# springboot-files-storage-tester
An app that run E2E test against a file storage service.

### Description

We assume that the target (tested) service has 2 API:
1. Upload a file to the service and get uid in response.
2. Download file using a uid that belong to the file.

Note: The testGetHello assume there is a third API, Get, that response with "hello". Its goal is the test that the target is reachable.

The target url and the path to its 2 API can be config in the tester application.properties.

### How to run tests
1. Build the project: mvn clean install -DskipTests
2. Run the servr: mvn spring-boot:run
3. Open browser in url: [springboot-swagger-ui](http://localhost:8090/swagger-ui/index.html#)
4. Select one test to run. The test response with test_uid
5. Query the test [getTaskStatus](http://localhost:8090/swagger-ui/index.html#/task-read-controller/getTaskStatus) to see if its still running or finished and the test results, [getTaskReport](http://localhost:8090/swagger-ui/index.html#/task-read-controller/getTaskReport) with the test_uid from the test response.

### Tests
- test4Results: run 4 tests cases, each should end with a different result: success, ignore, fail assert and throw exception.
- testCallOrder: Run 4 tests one after the other in pre-define order. The test will successed only if all 4 run at the correct order. 
- testGetHello: Use RestAssured to query the tergetd (tested) service for a simple API, GET "hello".
- testOneFile: The only test that actually verify the files service. It is much more complicated than the other.

testOneFile:
1. Create small temp local text file.
2. Upload the file and read the UID from the response.
3. Download the file using the same UID.
4. Read the text from the uploaded and downloaded files and compare them.

### Related projects

0. [springboot-files-storage-tester](https://github.com/orbartal/springboot-files-storage-tester):

A tester that enable to run e2e test of upload and download a file (using same UID for both actions):

1. [springboot-files-storage](https://github.com/orbartal/springboot-files-storage):

An example target (tested) service. A demo of a springboot universal file storage service to upload and download files with uid and metadata.

2. [docker-tester-spring-files](https://github.com/orbartal/docker-tester-spring-files):

A docker-compose that enable to run the target serivce with different config properties and supporting DBS.

And that allow the tester to test the service while its using the different config and DBS options. 

Note: The target details code and DB are transparent to the tester who only knows about the API contract.
