# JEP457 Hello World Translator

[JEP 457 Class-File API](https://openjdk.org/jeps/457) is a preview API to provide a standard API for parsing, 
generating, and transforming Java class files.

The example here shows how easy it is to use to read and modify an existing class file. 
The example modifies a single `ldc` instruction to change the constant printed from "Hello World" to
another string provided as an argument.

For examples of generating a class from scratch see [JEP457 Hello World](https://github.com/mrjameshamilton/jep457-hello-world)
and [JEP457 Brainf*ck Compiler](https://github.com/mrjameshamilton/bf-jep457).

# Building

You'll need JDK 22 which is currently available as an early access version.
The easiest way to install this is with [SDK man](https://sdkman.io/):

```shell
sdk install java 22.ea.36-open
```

If you have Java 22, you can then execute the `run.sh` script which will
compile and execute `HelloWorld.java` and `HelloTranslator.java`.
`HelloTranslator` will transform `HelloWorld.class`, changing
the constant "Hello World" into the script argument,
and then executing it.

```shell
$ ./run.sh "Hallo Wereld"
```

# Similar projects

There are many similar projects for parsing,
generating, and transforming Java class files, including:

* [ASM](https://asm.ow2.io/)
* [ProGuardCORE](https://github.com/Guardsquare/proguard-core)
* [ByteBuddy](https://bytebuddy.net/#/)
