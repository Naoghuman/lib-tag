Lib-Tag
===

[![Build Status](https://travis-ci.org/Naoghuman/lib-tag.svg?branch=master)](https://travis-ci.org/Naoghuman/lib-tag)
[![license: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![GitHub release](https://img.shields.io/github/release/Naoghuman/lib-tag.svg)](https://GitHub.com/Naoghuman/lib-tag/releases/)



Intention
---

The sublibrary `Lib-Tag-Core` contains the core functionalities to perform the 
CRUD (`Create`, `Read`, `Update` and `Delete`) operations for a [Tag].

A `Tag` is basically a simple [String] which can be used for example in a [Button], 
[Label] or another [JavaFX] component. Suchlike tagged topics can be easily searched 
or analysed for a `Tag`.

> __Hint__  
> The generated `Tags` can be easily shown in different `JavaFX` gui components 
> with the sub-library [Lib-Tag-Components].

_Image:_ [UML] Lib-Tag  
![uml_lib-tag_v0.4.0_2019-06-13_19-10.png][uml_lib-tag_v0.4.0_2019-06-13_19-10]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

> __Hint__  
> This libray is a part of the project [Lib-Tag]. Plz see for additional 
> informations like `Download`, `Requirements` or `Installation` there. Thanks :smile:



Content
---
* [Examples](#Ex)
    * [Usage of the class `TagBuilder`](#UsOfThClTaBu)
    * [Usage of the class `TagRelationBuilder`](#UsOfThClTaReBu)
    * [Usage of the class `TagRelationContainerIdBuilder`](#UsOfThClTaReCoIdBu)
* [JavaDoc](#JavaDoc)
* [Download](#Download)
* [Requirements](#Requirements)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Ex" />
---


### Usage of the class `TagBuilder`<a name="UsOfThClTaBu" />

It is very easy to create a [Tag] with the fluent builder [TagBuilder]:

```java
/**
 * With the fluent builder {@link com.github.naoghuman.lib.tag.core.TagBuilder} 
 * its possible to create easly a {@code Tag} which is the preferred way.
 * 
 * <ul>
 * <li>The first three attributes {@code id}, {@code title} and {@code generationTime} are mandory.</li>
 * <li>All other attributes are {@code optional}.</li>
 * <li>All defined values will be validate against the {@code Interface} {@code TagValidator}.</li>
 * </ul>
 * 
 * @see com.github.naoghuman.lib.tag.core.Tag
 * @see com.github.naoghuman.lib.tag.core.TagBuilder
 * @see com.github.naoghuman.lib.tag.core.TagValidator
 */
final Tag tag = TagBuilder.create()
        .id(Tag.DEFAULT_ID)               // mandory (NOT NULL)
        .title("title")                   // mandory (NOT NULL && NOT EMPTY)
        .generationTime(Long.MIN_VALUE)   // mandory (NOT NULL)
        .description("description")       // optional
        .style("style")                   // optional
        .build();
```

The same __as__ a [Business process modeling (BPM)] diagram (create with the tool [Bizagi Modeler BPMN]):  
_Image:_ Business process modeling diagram from `TagBuilder`  
![bpm_lib-tag-core_tagbuilder_2017-12-17_08-23.png][bpm_lib-tag-core_tagbuilder_2017-12-17_08-23]

> __Hint__  
> . The generation from a `Tag` starts with the method `create()`.  
> . `Green` rectangles are `mandory` attributes.  
> . `Blue` rectangles are `optional` attributes.  
> . The `Tag` will then created with the last method `build()`.

__Additional informations__  
* Design Pattern: [Fluent Interface]
* Design Pattern: [Builder pattern]
* Design Pattern: [Step builder pattern]


### Usage of the class `TagRelationBuilder`<a name="UsOfThClTaReBu" />

With a [TagRelation] its possible to `map` a [Tag] with a specific gui component. 
So the application `knows` which [Tag]s should be shown for example in a [Button] 
or in a [FlowPane].

```java
/**
 * With the fluent builder {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder} 
 * its possible to create easly a {@link com.github.naoghuman.lib.tag.core.TagRelation}
 * which can be used to map a {@link com.github.naoghuman.lib.tag.core.Tag} against 
 * a gui component.
 * 
 * <ul>
 * <li>All attributes in the builder are {@code mandory}.</li>
 * <li>All defined values will be validate against the {@code Interface} {@code TagValidator}.</li>
 * </ul>
 * 
 * @see com.github.naoghuman.lib.tag.core.Tag
 * @see com.github.naoghuman.lib.tag.core.TagRelation
 * @see com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see com.github.naoghuman.lib.tag.core.TagRelationContainerIdBuilder
 * @see com.github.naoghuman.lib.tag.core.TagValidator
 */
final TagRelation tagRelation = TagRelationBuilder.create()
        .id(TagRelation.DEFAULT_ID)                         // mandory (NOT NULL)
        .tagId(0L)                                          // mandory (NOT NULL)
        .containerId(TagRelationContainerIdBuilder.create()
                .path(TagRelationContainerId.class)         // mandory (NOT NULL)
                .container(AnchorPane.class)                // mandory (NOT NULL)
                .containerId("container-id")                // mandory (NOT NULL && NOT EMPTY)
                .build())
        .build();
```

The same like above __as__ a [Business process modeling (BPM)] diagram (create with the tool [Bizagi Modeler BPMN]):  
_Image:_ Business process modeling diagram from `TagRelationBuilder`  
![bpm_lib-tag-core_tagreleationbuilder_2017-11-25_22-42.png][bpm_lib-tag-core_tagreleationbuilder_2017-11-25_22-42]

> __Hint__  
> . The generation from a `TagRelation` starts with the method `create()`.  
> . `Green` rectangles are `mandory` attributes.  
> . The `TagRelation` will then created with the last method `build()`.

__Additional informations__  
* Design Pattern: [Fluent Interface]
* Design Pattern: [Builder pattern]
* Design Pattern: [Step builder pattern]


### Usage of the class `TagRelationContainerIdBuilder`<a name="UsOfThClTaReContainerIdBu" />

To identify the container and the assoziated [Tag]s from the container a unique `id` 
is required. Here comes the following fluent builder in the game:

```java
/**
 * With the fluent builder {@link com.github.naoghuman.lib.tag.core.TagRelationContainerIdBuilder} 
 * its possible to create easly an unique {@code Id} which can be used to map a 
 * {@link com.github.naoghuman.lib.tag.core.Tag} against a gui component.
 * 
 * For more information about how to map a {@code Tag} with a container see 
 * {@link com.github.naoghuman.lib.tag.core.TagRelation}.
 * 
 * <ul>
 * <li>All attributes in the builder are {@code mandory}.</li>
 * <li>All defined values will be validate against the {@code Interface} {@code TagValidator}.</li>
 * </ul>
 * 
 * @see com.github.naoghuman.lib.tag.core.Tag
 * @see com.github.naoghuman.lib.tag.core.TagRelation
 * @see com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see com.github.naoghuman.lib.tag.core.TagRelationContainerIdBuilder
 * @see com.github.naoghuman.lib.tag.core.TagValidator
 */
final String tagRelationContainerId = TagRelationContainerIdBuilder.create()
        .path(TagRelationContainerId.class) // mandory (NOT NULL)
        .container(AnchorPane.class)        // mandory (NOT NULL)
        .containerId("container-id")        // mandory (NOT NULL && NOT EMPTY)
        .build();
```

Again the same __as__ a [Business process modeling (BPM)] diagram (create with the tool [Bizagi Modeler BPMN]):  
_Image:_ Business process modeling diagram from `TagRelationContainerIdBuilder`  
![bpm_lib-tag-core_tagrelationcontaineridbuilder_2017-12-17_08-32.png][bpm_lib-tag-core_tagrelationcontaineridbuilder_2017-12-17_08-32]

> __Hint__  
> . The generation from a `TagRelationContainerId` starts with the method `create()`.  
> . `Green` rectangles are `mandory` attributes.  
> . The `TagRelationContainerId` will then created with the last method `build()`.

__Additional informations__  
* Design Pattern: [Fluent Interface]
* Design Pattern: [Builder pattern]
* Design Pattern: [Step builder pattern]



JavaDoc<a name="JavaDoc" />
---

The [JavaDoc] from the library `Lib-TAG` can be explored here: [JavaDoc Lib-Tag]

_Image:_ JavaDoc Lib-Tag v0.4.0
![javadoc_lib-tag_v0.4.0_2019-06-16_11-34.png][javadoc_lib-tag_v0.4.0_2019-06-16_11-34]



Download<a name="Download" />
---

Current `version` is `0.4.0`. Main points in this release are:
* ...
* ...

Download:
* [Release v0.4.0] (06.dd.2019 / MM.dd.yyyy)

Maven:
```xml
<!-- https://mvnrepository.com/artifact/com.github.naoghuman/lib-tag -->
<dependency>
    <groupId>com.github.naoghuman</groupId>
    <artifactId>lib-tag</artifactId>
    <version>0.4.0</version>
</dependency>
```

An `overview` about all existings releases can be found here:
* [Overview] from all releases in Lib-Tag.



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* The library [lib-tag-0.4.0](#Installation).

In the library following dependencies are registered:
* No additional relationship



License<a name="License" />
---

The project `Lib-Tag` and all sub-projects are licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Lib-Tile` and all sub-projects are maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[javadoc_lib-tag_v0.4.0_2019-06-16_11-34]:https://user-images.githubusercontent.com/8161815/59562255-d484a600-902a-11e9-9111-7eeb03089be1.png
[bpm_lib-tag-core_tagbuilder_2017-12-17_08-23]:https://user-images.githubusercontent.com/8161815/34077423-0925b636-e304-11e7-823f-4e2e288acd24.png
[bpm_lib-tag-core_tagreleationbuilder_2017-11-25_22-42]:https://user-images.githubusercontent.com/8161815/34077425-16aecb9e-e304-11e7-8c23-d1cf42dbf8ee.png
[bpm_lib-tag-core_tagrelationcontaineridbuilder_2017-12-17_08-32]:https://user-images.githubusercontent.com/8161815/34077450-fef599fa-e304-11e7-903d-e3ad075a0d63.png
[uml_lib-tag_v0.4.0_2019-06-13_19-10]:https://user-images.githubusercontent.com/8161815/59452927-1a652280-8e0f-11e9-8319-d120b47ebd16.png



[//]: # (Links)
[Builder pattern]:https://en.wikipedia.org/wiki/Builder_pattern
[Business process modeling (BPM)]:https://en.wikipedia.org/wiki/Business_process_modeling
[Button]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
[Bizagi Modeler BPMN]:http://www.bizagi.com/de/produkte/plattform/modeler
[FlowPane]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/FlowPane.html
[Fluent Interface]:https://www.martinfowler.com/bliki/FluentInterface.html
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[GenMyModel]:https://www.genmymodel.com/
[JavaDoc]:http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
[JavaDoc Lib-Tag]:http://naoghuman.github.io/lib-tag/apidocs
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Label]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html
[Lib-Tag]:https://github.com/Naoghuman/lib-tag
[Lib-Tag-Components]:https://github.com/Naoghuman/lib-tag/tree/master/lib-tag-components
[Overview]:https://github.com/Naoghuman/lib-tag/releases
[Release v0.4.0]:https://github.com/Naoghuman/lib-tag/releases/tag/v0.4.0
[Step builder pattern]:http://www.svlada.com/step-builder-pattern/
[String]:https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
[Tag]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/Tag.java
[TagBuilder]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/TagBuilder.java
[TagRelation]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/TagRelation.java
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language
