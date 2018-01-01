Welcome to `Lib-Tag` with the new release `0.3.0`.

`Lib-Tag` is a library to use and handle easily [Tag]s in your a [JavaFX] & [Maven] 
application.  
A `Tag` is basically a simple [String] which can be used for example in a [Button], 
[Label] or another [JavaFX] components. Suchlike tagged topics can be easily searched 
or analysed for a `Tag`.

Written in [JavaFX] and [NetBeans IDE] the project contains several sub-libraries 
for specific tasks. For example:
* `Lib-Tag-Core`     : The sub-library contains the core functionalities from the project.
* `Lib-Tag-Component`: The sub-library allowed to show [Tag]s in different [JavaFX] gui components.



#### Summary
* Add UnitTests to the library Lib-Tag-Core.
* Add different fluent builders in the library Lib-Tag-Component.



#### New



#### Enhancement
#10 [Tag] Optional attributes should be used in DefaultTag.create(...) method.
#9  [Tag] Add Unittests for the default implementation.
#8  [TagRelation] Add Unittests for the default implementation.
#7  [TagValidator] Add Unittests for the default implementation.
#5  [TagRelation] To identify the path + component for a Tag is embbed an unique 'containerId' is needed.



#### Feature
#18 [Lib-Tag-Component] Add new class TagFlowPaneBuilder which replace the interface TagFlowPane.
#17 [Lib-Tag-Component] Add new class TagLabelBuilder which replace the interface TagLabel.
#16 [Lib-Tag-Component] Add new class TagButtonBuilder which replace the interface TagButton.
#15 [Lib-Tag-Component] Add new interface (and class) TagComponentValidator.



#### Bug



#### Refactoring
#19 [Lib-Tag-Component] Add new class TagComponentEventHandler.
#14 [Lib-Tag-Component] Remove the class TagComponentsFacade.
#13 [Lib-Tag-Components] Rename the library to Lib-Tag-Component.
#12 [Lib-Tag-Component] Update documentation to v0.3.0.
#11 [Documentation] Update the documentation to v0.3.0.
#6  [Validator] Rename Validator to TagValidator to fit the naming convention.



#### Additional



Greetings
Naoghuman



[//]: # (Issues which will be integrated in this release)



[//]: # (Links)
[Button]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[Label]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html
[Maven]:http://maven.apache.org/
[NetBeans IDE]:https://netbeans.org/
[String]:https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
[Tag]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/Tag.java
