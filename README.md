## Play Scala invoke Java Controller with Compile-Time DI

This simple program illustrates the issue with invoking Java controller from a Scala Play application
that is configured through compile-time dependency injection.

### Guice DI

Switch to `guice_di` branch and start the application with:

    % sbt run
    
The application should be running at port 9000. There is a Scala controller and a Java controller.
They can be access with:

    localhost:9000/scalaPing?msg=something
    
    or
    
    localhost:9000/javaPing?msg=something
    
These should work and response with a simple _pong_ message.


### Compile-time DI

Switch to `compile_time_di` branch. Start the app, and try with the same _ping_ actions. The
Scala version should work; but the Java version would return the following exception:


    [error] a.a.ActorSystemImpl - Internal server error, sending 500 response
    java.lang.RuntimeException: AkkaHttpServer doesn't handle Handlers of this type: play.core.routing.HandlerInvokerFactory$JavaActionInvokerFactory$$anon$3$$anon$4@6058c29a
            at scala.sys.package$.error(package.scala:30)
            at play.core.server.AkkaHttpServer.executeHandler(AkkaHttpServer.scala:337)
            at play.core.server.AkkaHttpServer.handleRequest(AkkaHttpServer.scala:263)
            at play.core.server.AkkaHttpServer.$anonfun$createServerBinding$1(AkkaHttpServer.scala:138)
            at akka.stream.impl.fusing.MapAsyncUnordered$$anon$31.onPush(Ops.scala:1318)
            at akka.stream.impl.fusing.GraphInterpreter.processPush(GraphInterpreter.scala:519)
            at akka.stream.impl.fusing.GraphInterpreter.processEvent(GraphInterpreter.scala:482)
            at akka.stream.impl.fusing.GraphInterpreter.execute(GraphInterpreter.scala:378)
            at akka.stream.impl.fusing.GraphInterpreterShell.runBatch(ActorGraphInterpreter.scala:588)
            at akka.stream.impl.fusing.GraphInterpreterShell$AsyncInput.execute(ActorGraphInterpreter.scala:472)
    
