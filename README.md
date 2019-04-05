## Play Scala invoke Java Controller with Compile-Time DI

This simple program illustrate the issue with invoking Java controller from a Scala Play application
this is configured through compile-time dependency injection.

### Guice DI

Switch to `guice_di` branch and start the application with:

    % sbt run
    
The application should be running at port 9000. There is a Scala controller and a Java controller.
They can be access with:

    localhost:9000/scalaPing?msg=something
    
    or
    
    localhost:9000/javaPing?msg=something
    
This should work and response with a simple _pong_ message.


### Compile-time DI

Switch to `compile_time_di` branch. Start the app, and try with the same _ping_ actions. The
Scala version should work; but the Java version would return the following exception:

