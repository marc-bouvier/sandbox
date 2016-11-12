p4ee-plugin
===========

This is an example of implementation of *[Plugin](http://martinfowler.com/eaaCatalog/plugin.html)* design pattern as defined
in [Martin Fowler](http://martinfowler.com/)'s
[Patterns of Enterprise Application Architecture](http://martinfowler.com/eaaCatalog/).

Purpose
-------

> Links classes during configuration rather than compilation

This pattern allows a clean separation between a component implementation and
the consumer of this component.
This allows to delay the implementation choice at the last moment .
It also allows to change the implementation of the component without code
change in the consumer.


How to run this example
-----------------------

Open a command line in p4ee-plugin.

Build the consumer maven project : `p4ee-plugin/p4ee-plugin-consumer`

```
    mvn clean install
```

Build the consumer maven project : `p4ee-plugin/p4ee-plugin-plugin`

```
    mvn clean install
```

The plugin must be in the classpath of the consumer.

Run
```
    env P4EE_PLUGIN_CONSUMER_CONF_PATH="p4ee-configuration/conf.properties"  java -cp "p4ee-plugin-consumer/target/p4ee-plugin-consumer-1.0-SNAPSHOT.jar;p4ee-plugin-plugin/target/p4ee-plugin-plugin-1.0-SNAPSHOT.jar" fr.bouvier.marc.MainApp
```

You can change implementation of the plugin by changing configuration in `p4ee-configuration/conf.properties`

```
plugin.internal.fr.bouvier.marc.helloworld.plugin.HelloWorld=fr.bouvier.marc.helloworld.plugin.SysOutHelloWorld
#plugin.internal.fr.bouvier.marc.helloworld.plugin.HelloWorld=fr.bouvier.marc.alternative.helloworld.plugin.AlternativeHelloWorld
```