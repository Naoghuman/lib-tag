Lib-Tag
===



Intention
===

`Lib-Tag` is a multi [Maven] library written in [JavaFX] and [NetBeans IDE] and 
provides functionalities to use and handle easily [Tag]s in your [JavaFX] application.


The current `version` is `0.1.0` from MM.dd.2017 (MM.dd.yyyy).



Content
===

* [Libraries](#Libraries)
    * [Sublibrary Lib-Tag-Core](#LiTaCor)
* [Download](#Download)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Libraries<a name="Libraries" />
---

Like I said in the section `Intention` the project `Lib-Tag` is a multi [Maven] 
library.
* Minimal the sublibrary `Lib-Tag-Core` is needed.
* Additional the sublibrary `Lib-Tag-Components` can be used to show the [Tag]s 
  in different [JavaFX] components.


### Sublibrary Lib-Tag-Core<a name="LiTaCor" />

The sublibrary [Lib-Tag-Core] provides the API to perform CRUD (`Create`, `Read`, 
`Update` and `Delete`) operations for a [Tag].

A `Tag` is basically a simple [String] which can be used for example in a [Button], 
[Label] or another [JavaFX] component. Tagged topics can be easily searched or 
analysed for a `Tag`.

_Image:_ [UML] Lib-Tag-Core  
![overview_lib-tag-core_2017-05-25_19-23.png][overview_lib-tag-core_2017-05-25_19-23]

For more informations about the sublibrary (examples, api) plz see [Lib-Tag-Core] :smile: .



Download<a name="Download" />
---

Add text...



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.



Installation<a name="Installation" />
---

* If not installed download the [JRE 8] or the [JDK 8].
  * Optional: To work better with [FXML] files in a [JavaFX] application download 
    the [JavaFX Scene Builder] under 'Additional Resources'.
* Choose your preferred IDE (e.g. [NetBeans], [Eclipse] or [IntelliJ IDEA]) for 
  development.
* Download or clone the library [Lib-Tag].



Documentation<a name="Documentation" />
---

* In section [Api](#Api) you can see the main point(s) to access the functionality 
  in this library.
* For additional information you can see the [JavaDoc] in the library itself.



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
[overview_lib-tag-core_2017-05-25_19-23]:https://cloud.githubusercontent.com/assets/8161815/26462105/c35caf22-417f-11e7-9831-fd6fadda85cb.png



[//]: # (Links)
[Button]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[Issue]:https://github.com/Naoghuman/lib-tag/issues
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX Scene Builder]:http://gluonhq.com/labs/scene-builder/
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Label]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html
[Lib-Tag]:https://github.com/Naoghuman/lib-tag
[Lib-Tag-Core]:https://github.com/Naoghuman/lib-tag/tree/master/lib-tag-core
[Maven]:http://maven.apache.org/
[NetBeans IDE]:https://netbeans.org/
[Pull Request]:https://help.github.com/articles/using-pull-requests
[String]:https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
[Tag]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/Tag.java
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language
