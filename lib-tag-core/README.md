Lib-Tag-Core
===



Intention
---

The library `Lib-Tag-Core` provides the API to perform CRUD (`Create`, `Read`, 
`Update` and `Delete`) operations for a [Tag].

A `Tag` is basically a simple [String] which can be used for example in a [Label] or 
a [Button]. With a Tag it is easily to search for or analyse a topic if it is tagged.

_Image:_ [UML] Lib-Tag-Core  
![overview_lib-tag-core_2017-05-25_19-23.png][overview_lib-tag-core_2017-05-25_19-23]

> __Hint__  
> This libray is a part from the project [Lib-Tag]. Plz see for additional 
> informations like `Download`, `Requirements` or `Installation` there. Thanks :smile:



Content
---

* [Examples](#Ex)
    * [Usage of the class `TagBuilder`](#UsOfThClTaBu)
    * [Usage of the class `TagRelationBuilder`](#UsOfThClTaReBu)
* [API: com.github.naoghuman.lib.tag.core](#LiTaCo)
    * [TagBuilder](#TaBu)
    * [Tag](#Ta)
    * [TagRelationBuilder](#TaReBu)
    * [TagRelation](#TaRe)
    * [TagValidator](#TaVa)
* [API: com.github.naoghuman.lib.tag.internal](#LiTaCoIn)
    * [DefaultTag](#DeTa)
    * [DefaultTagRelation](#DeTaRe)
    * [DefaultTagValidator](#DeTaVa)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Ex" />
---


### Usage of the class `TagBuilder`<a name="UsOfThClTaBu" />

It is very easy with the class [TagBuilder] to create a [Tag].  
The following picture shows all __allowed__ combinations to generate a `Tag` with the `TagBuilder`:

_Image:_ All allowed combinations to create a `Tag`  
![tagbuilder_allowed-combinations_v0.1.0_2017-05-26_07-29.png][tagbuilder_allowed-combinations_v0.1.0_2017-05-26_07-29]

The same combinations __as__ a [Business process modeling (BPM)] diagram (create with the tool [Bizagi Modeler BPMN]):
> __Hint__  
> . The generation from a `Tag` starts with the method `create()`.  
> . `Blue` rectangles are `optional` attributes.  
> . `Green` rectangles are `mandory` attributes.  
> . The `Tag` will then created with the last method `build()`.

_Image:_ Business process modeling diagram from `TagBuilder`  
![tagbuilder_v0.1.0_2017-05-26_07-24.png][tagbuilder_v0.1.0_2017-05-26_07-24]

__Additional informations__  
* Design Pattern: [Fluent Interface]
* Design Pattern: [Builder pattern]
* Design Pattern: [Step builder pattern]


### Usage of the class `TagRelationBuilder`<a name="UsOfThClTaReBu" />

With a [TagRelation] its possible to `map` a [Tag] with a specific gui component. So the application `knows` which [Tag]s should be shown in a [Button] or in a [FlowPane]...  
The following picture shows __how__ to use the `TagRelationBuilder` to generate a `TagRelation`:

_Image:_ How to generate a `TagRelation` with the class `TagRelationBuilder`  
![tagrelationbuilder_allowed-combinations_v0.1.0_2017-05-28_09-27.png][tagrelationbuilder_allowed-combinations_v0.1.0_2017-05-28_09-27]

The same like above __as__ a [Business process modeling (BPM)] diagram (create with the tool [Bizagi Modeler BPMN]):
> __Hint__  
> . The generation from a `TagRelation` starts with the method `create()`.  
> . `Green` rectangles are `mandory` attributes.  
> . The `TagRelation` will then created with the last method `build()`.

_Image:_ Business process modeling diagram from `TagRelationBuilder`  
![tagrelationbuilder_v0.1.0_2017-05-28_09-35.png][tagrelationbuilder_v0.1.0_2017-05-28_09-35]

__Additional informations__  
* Api: [TagRelation](#TaRe)
* Api: [TagRelationBuilder](#TaReBu)
* Design Pattern: [Fluent Interface]
* Design Pattern: [Builder pattern]
* Design Pattern: [Step builder pattern]



API: com.github.naoghuman.lib.tag.core<a name="LiTaCo" />
---


### TagBuilder<a name="TaBu" />


### Tag<a name="Ta" />


### TagRelationBuilder<a name="TaReBu" />


### TagRelation<a name="TaRe" />


### TagValidator<a name="TaVa" />



API: com.github.naoghuman.lib.tag.internal<a name="LiTaCoIn" />
---

### DefaultTag<a name="DeTa" />


### DefaultTagRelation<a name="DeTaRe />


### DefaultTagValidator<a name="DeTaVa" />



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
[overview_lib-tag-core_2017-05-25_19-23]:https://cloud.githubusercontent.com/assets/8161815/26462105/c35caf22-417f-11e7-9831-fd6fadda85cb.png
[tagbuilder_v0.1.0_2017-05-26_07-24]:https://cloud.githubusercontent.com/assets/8161815/26481964/b6c955fc-41e4-11e7-9abf-7e1afbe20c5b.png
[tagbuilder_allowed-combinations_v0.1.0_2017-05-26_07-29]:https://cloud.githubusercontent.com/assets/8161815/26482025/2339675e-41e5-11e7-9ad2-a5d7b27aa931.png
[tagrelationbuilder_v0.1.0_2017-05-28_09-35]:https://cloud.githubusercontent.com/assets/8161815/26526919/637c694c-4389-11e7-8d48-f79eef97df55.png
[tagrelationbuilder_allowed-combinations_v0.1.0_2017-05-28_09-27]:https://cloud.githubusercontent.com/assets/8161815/26527041/a6677a1a-438b-11e7-9fe1-e66634b47d70.png



[//]: # (Links)
[Builder pattern]:https://en.wikipedia.org/wiki/Builder_pattern
[Business process modeling (BPM)]:https://en.wikipedia.org/wiki/Business_process_modeling
[Button]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
[Bizagi Modeler BPMN]:http://www.bizagi.com/de/produkte/plattform/modeler
[FlowPane]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/FlowPane.html
[Fluent Interface]:https://www.martinfowler.com/bliki/FluentInterface.html
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[Label]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html
[Lib-Tag]:https://github.com/Naoghuman/lib-tag
[Step builder pattern]:http://www.svlada.com/step-builder-pattern/
[String]:https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
[Tag]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/Tag.java
[TagBuilder]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/TagBuilder.java
[TagRelation]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/TagRelation.java
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language
