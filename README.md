Lib-Tag
===



Intention
===

`Lib-Tag` is a library to use and handle easily [Tag]s in your a [JavaFX] &amp; 
[Maven] application.  
A `Tag` is basically a simple [String] which can be used for example in a [Button], 
[Label] or another [JavaFX] components. Suchlike tagged topics can be easily searched 
or analysed for a `Tag`.

Written in [JavaFX] and [NetBeans] the project contains several sub-libraries 
for specific tasks. For example:
* The sub-library `Lib-Tag-Core` contains the core functionalities from the project.
* The sub-library `Lib-Tag-Components` allowed to show [Tag]s in different [JavaFX] 
  gui components.



Content
===

* [Libraries](#Libraries)
    * [Sublibrary Lib-Tag-Core](#LiTaCor)
    * [Sublibrary Lib-Tag-Components](#LiTaCom)
* [Download](#Download)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Libraries<a name="Libraries" />
---

Like I said in the section `Intention` the project `Lib-Tag` contains several 
sub-libraries.
* Minimal the sub-library `Lib-Tag-Core` is needed.
* Additional the sub-library `Lib-Tag-Components` can be used to show [Tag]s in 
  different [JavaFX] components.


### Sublibrary Lib-Tag-Core<a name="LiTaCor" />

The sublibrary [Lib-Tag-Core] contains the core functionalities to perform the 
CRUD (`Create`, `Read`, `Update` and `Delete`) operations for a [Tag].

A `Tag` is basically a simple [String] which can be used for example in a [Button], 
[Label] or another [JavaFX] components. Suchlike tagged topics can be easily 
searched or analysed for a `Tag`.

_Image:_ [UML] Lib-Tag-Core  
![uml_lib-tag-core_2017-11-26_18-19.png][uml_lib-tag-core_2017-11-26_18-19]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

> __Hint__  
> For more informations about the sublibrary (examples, api) plz see [Lib-Tag-Core] 
> :smile: .


### Sublibrary Lib-Tag-Components<a name="LiTaCom" />

The sublibrary [Lib-Tag-Components] contains different possibilities to show a 
[Tag] in different [JavaFX] gui components.
* Currently a `Tag` can be represented as a [Button] or a [Label].
* A list of `Tag`s can then be shown in the container [FlowPane].

_Image:_ [UML] Lib-Tag-Components  
![UML-diagram_Lib-Tag-Components_v0.2.0_2017-07-22_18-07.png][UML-diagram_Lib-Tag-Components_v0.2.0_2017-07-22_18-07]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

> __Hint__  
> For more informations about the sublibrary (examples, api) plz see [Lib-Tag-Components] 
> :smile: .



Download<a name="Download" />
---

Current `version` is `0.2.0`. Main points in this release are:
* First release from the sub-library `Lib-Tag-Components` :smile: .

**Maven coordinates**  
In context from a [Maven] project you can use following maven coordinates: 
```xml
<dependencies>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-tag-core</artifactId>
        <version>0.2.0</version>
    </dependency>
    <dependency>
        <groupId>com.github.naoghuman</groupId>
        <artifactId>lib-tag-components</artifactId>
        <version>0.2.0</version>
    </dependency>
</dependencies>
```

**Download manuell**
* [Release v0.2.0 (07.22.2017 / MM.dd.yyyy)]

**An overview** about all existings releases can be found here:
* [Overview from all releases in Lib-Tag]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.



Installation<a name="Installation" />
---

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application download 
    the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for 
  the development.
* Download or clone the library [Lib-Tag].



Documentation<a name="Documentation" />
---

* In the section `API` from the respective sub-library you can see the main point(s) 
  to access the functionality in the library.
    * [Lib-Tag-Core]
    * [Lib-Tag-Components]
* For additional information plz see the [JavaDoc] in the sub-library itself.



Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to `contribute` to the project plz fork the project and do a [Pull Request].



License<a name="License" />
---

* The project `Lib-Tag` and all sub-projects are licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

* The project `Lib-Tag` and all sub-projects are maintained by me, Peter Rogge. 
  See [Contact](#Contact).



Contact<a name="Contact" />
---

* You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[uml_lib-tag-core_2017-11-26_18-19]:https://user-images.githubusercontent.com/8161815/33242513-7f2aa87a-d2d6-11e7-9a02-0b45f9223f54.png
[UML-diagram_Lib-Tag-Components_v0.2.0_2017-07-22_18-07]:https://user-images.githubusercontent.com/8161815/28492739-f0c22878-6f08-11e7-9b92-3d95f33990cb.png



[//]: # (Links)
[Button]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
[Eclipse]:https://www.eclipse.org/
[FlowPane]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/FlowPane.html
[FXML]:http://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[GenMyModel]:https://www.genmymodel.com/
[IntelliJ IDEA]:http://www.jetbrains.com/idea/
[Issue]:https://github.com/Naoghuman/lib-tag/issues
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://gluonhq.com/labs/scene-builder/
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Label]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html
[Lib-Tag]:https://github.com/Naoghuman/lib-tag
[Lib-Tag-Components]:https://github.com/Naoghuman/lib-tag/tree/master/lib-tag-components
[Lib-Tag-Core]:https://github.com/Naoghuman/lib-tag/tree/master/lib-tag-core
[Maven]:http://maven.apache.org/
[NetBeans]:https://netbeans.org/
[Overview from all releases in Lib-Tag]:https://github.com/Naoghuman/lib-tag/releases
[Pull Request]:https://help.github.com/articles/using-pull-requests
[Release v0.2.0 (07.22.2017 / MM.dd.yyyy)]:https://github.com/Naoghuman/lib-tag/releases/tag/v0.2.0
[String]:https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
[Tag]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/Tag.java
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language
