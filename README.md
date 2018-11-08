Fediz Client Example
===================

Overview
-----------

Simnple project that demonstrates the use of the http://cxf.apache.org/fediz.html[Apache Fediz] REST Api.

The project provides a web client that ignores SSL certificates and uses Basic authentication.

Getting started
-----------------

The library was built using the following toolchain:

* http://www.oracle.com/technetwork/java/javase/downloads/index.html[Java Oracle JDK 1.8]
* https://maven.apache.org/download.cgi[Maven 3.2.3]

Your mileage may vary with versions different than the ones specified above.

Follow these steps to get started:

1) Git-clone this repository.

```
git clone git://github.com/damianmcdonald/fediz-client.git my-project

```

2) Change directory into your clone:

```
cd my-project
```

3) Use Maven to compile everything:

```
mvn clean install
```
