# Hello Pluggy Java!

A sample repository showing how to use the [pluggy-sdk-java](https://github.com/pluggyai/pluggy-sdk-java) library.

## Setup

1. Since the `pluggy-java` dependency is only available Github Packages at the moment, we need first to add the GH Packages server config to our `.m2/settings.xml` file. Follow [these steps](https://docs.github.com/en/packages/using-github-packages-with-your-projects-ecosystem/configuring-apache-maven-for-use-with-github-packages#authenticating-to-github-packages) for more details.
2. Install dependencies:

```
mvn clean install
```

## Running

1. Make sure to define `PLUGGY_CLIENT_ID` and `PLUGGY_CLIENT_SECRET` env variables.
### Unix / bash
```
export PLUGGY_CLIENT_ID="<your client id>" && export PLUGGY_CLIENT_ID="<your client secret>"
```
### Windows / cmd
```
set PLUGGY_CLIENT_ID="<your client id>" && set PLUGGY_CLIENT_SECRET="<your client secret>"
```

2. Compile & Run the main class [HelloPluggyJava](./src/main/java/ai/pluggy/HelloPluggyJava.java)
```
mvn compile exec:java
```
(Of course, you can also run it using any IDE of your choice)

3. If everything went smoothly, you should see logs showing an API request response.
