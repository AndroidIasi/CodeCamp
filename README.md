# CodeCamp
CodeCamp app repository

[![alt logo](https://play.google.com/intl/en_us/badges/images/badge_new.png)](https://play.google.com/store/apps/details?id=ro.androidiasi.codecamp.iasi.live)

The CodeCamp app is an AndroidIasi product meant to demonstrate the usage of AndroidAnnotations and MVP architecture to be used as a support for the AndroidAnnotations presentation.

### Code Analysis tools 

The following code analysis tools are set up on this project:

* [PMD](https://pmd.github.io/): It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. See [this project's PMD ruleset](quality/pmd/pmd-ruleset.xml).

``` 
./gradlew pmd
```

* [Findbugs](http://findbugs.sourceforge.net/): This tool uses static analysis to find bugs in Java code. Unlike PMD, it uses compiled Java bytecode instead of source code.

```
./gradlew findbugs
```

* [Checkstyle](http://checkstyle.sourceforge.net/): It ensures that the code style follows [Ribot's Android code guidelines](https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md#2-code-guidelines) See our [checkstyle config file](quality/checkstyle/checkstyle-config.xml).

```
./gradlew checkstyle
```

* Flow
```
--> CheckStyle --> FindBugs --> PMD --> (To be continued --> Android Lint --> UnitTests --> Functional Test) --> ✔️
```
Special thanks to Ribot for the [android-boilerplate project](https://github.com/ribot/android-boilerplate)
