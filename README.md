# jQAssistant Architecture Pattern Plugin
While preparing for the [iSAQB](http://www.isaqb.org/?lang=en) exam I was facing the law of demeter again.
I thought about how to check it automatically in larger code bases.
With [jQAssistant](https://jqassistant.org/) it should be possible to check for complex dependency pattern.
Therefore I created this plugin to collect some pattern over time starting with the law of demeter.

## Installation
Declare a maven dependency to the jQAssistant plugin configuration or dowload the JAR.

```xml
<dependency>
    <groupId>de.sagr.jqassistant</groupId>
    <artifactId>architecture-pattern</artifactId>
    <version>1.0.0</version>
</dependency>
```
## Concepts
### basic:CreateObjectInMethod
The standard java plugin does add information about relations between classes, methods and some other elements of the java language.
For the law of demeter you need to know if the method created the object.
The CreateObjectInMethod concept adds a relation with the label "CONSTRUCTS" between the method which invokes the constructor and the class where the constructor is declared.

### arc:LawOfDemeterViolation
This concept checks each method invocation for compliance with the [law of demeter](https://en.wikipedia.org/wiki/Law_of_Demeter).
It forces a loose coupling between implementations. The concept sets a property (lawOfDemeterViolation) to the violating INVOKES relation.

More formally it requires that a method to invoke only methods on objects that meet the following criteria.
1. Methods declared in the same object
2. Methods on parameters of the method
3. Any object created/instantiated within the method
4. Any declared member of the object where the method is declared

The provided constraint is an approximation to the law of demeter.
In jQAssistant it is not possible to check call-chains.
Furthermore one could trick the constraint very easily by declaring member variables in the class where the method is declared.

Example Usage:
```
MATCH
    (m:Method)-[i:INVOKES]->(r:Method)
WHERE
    i.lawOfDemeterViolation = true
RETURN
    i as Violation,
    r as CalledMethod
```