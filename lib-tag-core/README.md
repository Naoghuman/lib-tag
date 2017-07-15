Lib-Tag-Core
===



Intention
---

The sublibrary `Lib-Tag-Core` contains the core functionalities to perform the 
CRUD (`Create`, `Read`, `Update` and `Delete`) operations for a [Tag].

A `Tag` is basically a simple [String] which can be used for example in a [Button], 
[Label] or another [JavaFX] component. Suchlike tagged topics can be easily searched 
or analysed for a `Tag`.

> __Hint__
> The generated `Tags` can be easily shown in different `JavaFX` gui components 
> with the sub-library [Lib-Tag-Components] (which will be implemented in future 
> releases) :smile:.

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
    * [Tag](#Tag)
    * [TagRelationBuilder](#TaReBu)
    * [TagRelation](#TaRe)
    * [Validator](#Vali)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Ex" />
---


### Usage of the class `TagBuilder`<a name="UsOfThClTaBu" />

It is very easy to create a [Tag] with the fluent builder [TagBuilder]:

```java
/**
 * With the fluent builder {@code TagBuilder} its possible to create a 
 * {@code Tag}.
 * <ul>
 * <li>The first two attributes {@code id} and {@code title} are mandory.</li>
 * <li>The other attributes are {@code optional}.</li>
 * <li>All defined values will be validate against the {@code Interface}
 * {@code Validator}.</li>
 * </ul>
 */
final Tag tag = TagBuilder.create()
        .id(Tag.DEFAULT_ID)               // mandory (NOT NULL)
        .title("title")                   // mandory (NOT NULL && NOT EMPTY)
        .generationTime(Long.MIN_VALUE)   // optional
        .description("description")       // optional
        .style("style")                   // optional
        .build();
```

The same combinations __as__ a [Business process modeling (BPM)] diagram (create with the tool [Bizagi Modeler BPMN]):
_Image:_ Business process modeling diagram from `TagBuilder`  
![tagbuilder_v0.1.0_2017-07-15_10-48.png][tagbuilder_v0.1.0_2017-07-15_10-48]

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
So the application `knows` which [Tag]s should be shown in a [Button] or in a [FlowPane]...

```java
/**
 * With the fluent builder {@code TagRelationBuilder} its possible to create
 * a {@code TagRelation} which can be used to map a {@code Tag} against 
 * a gui component.
 * <ul>
 * <li>All attributes in the builder are {@code mandory}.</li>
 * <li>All defined values will be validate against the {@code Interface}
 * {@code Validator}.</li>
 * </ul>
 */
final TagRelation tagRelation = TagRelationBuilder.create()
        .id(TagRelation.DEFAULT_ID)     // mandory (NOT NULL)
        .tagId(0L)                      // mandory (NOT NULL)
        .containerId("containerId")     // mandory (NOT NULL && NOT EMPTY)
        .containerType("containerType") // mandory (NOT NULL && NOT EMPTY)
        .build();
```

The same like above __as__ a [Business process modeling (BPM)] diagram (create with the tool [Bizagi Modeler BPMN]):
_Image:_ Business process modeling diagram from `TagRelationBuilder`  
![tagrelationbuilder_v0.1.0_2017-05-28_09-35.png][tagrelationbuilder_v0.1.0_2017-05-28_09-35]

> __Hint__  
> . The generation from a `TagRelation` starts with the method `create()`.  
> . `Green` rectangles are `mandory` attributes.  
> . The `TagRelation` will then created with the last method `build()`.

__Additional informations__  
* Design Pattern: [Fluent Interface]
* Design Pattern: [Builder pattern]
* Design Pattern: [Step builder pattern]



API: com.github.naoghuman.lib.tag.core<a name="LiTaCo" />
---


### TagBuilder<a name="TaBu" />

```java
/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.core.TagBuilder} 
 * the developer can create easily an instance from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.core.Tag}.
 * <ul>
 * <li>The first two attributes {@code id} and {@code title} are mandory.</li>
 * <li>All other attributes are optional, that means skipping them returns {@link java.util.Optional#empty()}.</li>
 * <li>Any optinal attribute if set will be validate against {@link com.github.naoghuman.lib.tag.core.Validator}.</li>
 * </ul>
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    com.github.naoghuman.lib.tag.core.TagBuilder
 * @see    com.github.naoghuman.lib.tag.core.Validator
 * @see    java.util.Optional#empty()
 */
public final class TagBuilder
```

```java
/**
 * Starting point from this fluent builder to generate and configured an 
 * instance from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.Tag}.
 * 
 * @return the first step to generate and configured an instance from the {@code Interface} {@code Tag}.
 * @see    com.github.naoghuman.lib.tag.core.Tag
 */
public static final IdStep create()
```

```java
/**
 * First mandory step to generate and configured an instance from the {@code Interface} {@code Tag}.<br>
 * This {@code Interface} allowed to set the attribute {@code id}.
 */
public interface IdStep
```

```java
/**
 * Second mandory step to generate and configured an instance from the {@code Interface} {@code Tag}.<br>
 * This {@code Interface} allowed to set the attribute {@code title}.
 */
public interface TitleStep
```

```java
/**
 * Optional steps for the configuration from the new instance from the 
 * {@code Interface} {@code Tag}.<br>
 * <ul>
 * <li>All attributes in this {@code Interface} are optional. If not set, then {@link java.util.Optional#empty()} for every unset attribute will returned.</li>
 * <li>All setted values will be validate against the {@code Interface} {@link com.github.naoghuman.lib.tag.core.Validator}.</li>
 * <li>Any optinal attribute is set more then ones then the last {@code value} will be used for the configuration.</li>
 * </ul>
 * 
 * @see com.github.naoghuman.lib.tag.core.Validator
 * @see java.util.Optional#empty()
 */
public interface Step
```


### Tag<a name="Tag" />

```java
/**
 * From the basic idea a {@code Tag} is a simple {@link java.lang.String} which 
 * can be used to displayed in a {@link javafx.scene.control.Button},  
 * {@link javafx.scene.control.Label} or another {@code JavaFX} component.<br>
 * Tagged topics can be easily searched or analysed for a Tag.
 * <p>
 * An instance from this {@code Interface} can be easily generated with the fluent builder 
 * {@link com.github.naoghuman.lib.tag.core.TagBuilder} which is the preferred way 
 * to generate an implementation from this {@code Interface}.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.TagBuilder
 * @see    java.lang.String
 * @see    javafx.scene.control.Button
 * @see    javafx.scene.control.Label
 */
public interface Tag extends Comparable<Tag>, Externalizable
```

```java
/**
 * Constant which defines the attribute {@code default-id} (= 
 * {@link java.lang.Long#MIN_VALUE}) from a {@code Tag}.
 */
public static final Long DEFAULT_ID = Long.MIN_VALUE;
```

```java
/**
 * Constant which defines an empty {@link java.lang.String}.
 * 
 * @see java.lang.String
 */
public static final String SIGN__EMPTY = ""; // NOI18N
```

```java
/**
 * Constant which defines the attribute {@code description}.
 */
public static final String TAG_PARA__DESCRIPTION = "description"; // NOI18N
```

```java
/**
 * Constant which defines the attribute {@code id}.
 */
public static final String TAG_PARA__ID = "id";
```

```java
/**
 * Constant which defines the attribute {@code generationTime}.
 */
public static final String TAG_PARA__GENERATION_TIME = "generationTime"; // NOI18N
```

```java
/**
 * Constant which defines the attribute {@code style}.
 */
public static final String TAG_PARA__STYLE = "style"; // NOI18N
```

```java
/**
 * Constant which defines the attribute {@code title}.
 */
public static final String TAG_PARA__TITLE = "title"; // NOI18N
```

```java
/**
 * Gets the value from the attribute {@code id} from this {@code Tag}.
 * 
 * @return the value from the attribute {@code id}.
 */
public Long getId();
```

```java
/**
 * Sets the new value from the attribute {@code id}.<br>
 * This is an mandory value. Setting the value will validate the value against 
 * {@link com.github.naoghuman.lib.tag.core.Validator}.
 * 
 * @param id the new value for the attribute {@code id}.
 * @see   com.github.naoghuman.lib.tag.core.Validator
 */
public void setId(final Long id);
```

```java
/**
 * Gets the value from the attribute {@code title} from this {@code Tag}.
 * 
 * @return the value from the attribute {@code title}.
 */
public String getTitle();
```

```java
/**
 * Sets the new value from the attribute {@code title}.<br>
 * This is an mandory value. Setting the value will validate the value against 
 * {@link com.github.naoghuman.lib.tag.core.Validator}.
 * 
 * @param title the new value for the attribute {@code title}.
 * @see   com.github.naoghuman.lib.tag.core.Validator
 */
public void setTitle(final String title);
```

```java
/**
 * Gets the value from the attribute {@code generationTime} from this {@code Tag}.<br>
 * This is an optional value. That means if not set then {@link java.util.Optional#empty()}
 * will returned.
 * 
 * @return the value from the attribute {@code generationTime}.
 * @see    java.util.Optional#empty()
 */
public Optional<Long> getGenerationTime();
```

```java
/**
 * Sets the new value from the attribute {@code generationTime}.
 * 
 * @param generationTime the new value for the attribute {@code generationTime}.
 */
public void setGenerationTime(final Long generationTime);
```

```java
/**
 * Gets the value from the attribute {@code description} from this {@code Tag}.<br>
 * This is an optional value. That means if not set then {@link java.util.Optional#empty()}
 * will returned.
 * 
 * @return the value from the attribute {@code description}.
 * @see    java.util.Optional#empty()
 */
public Optional<String> getDescription();
```

```java
/**
 * Sets the new value from the attribute {@code description}.
 * 
 * @param description the new value for the attribute {@code description}.
 */
public void setDescription(final String description);
```

```java
/**
 * Gets the value from the attribute {@code style} from this {@code Tag}.<br>
 * This is an optional value. That means if not set then {@link java.util.Optional#empty()}
 * will returned.
 * 
 * @return the value from the attribute {@code style}.
 * @see    java.util.Optional#empty()
 */
public Optional<String> getStyle();
```

```java
/**
 * Sets the new value from the attribute {@code style}.
 * 
 * @param style the new value for the attribute {@code style}.
 */
public void setStyle(final String style);
```

```java
/**
 * Gets the value from the attribute {@code markAsChanged} from this {@code Tag}.
 * 
 * @return the value from the attribute {@code markAsChanged}.
 */
@Transient
public boolean isMarkAsChanged();
```

```java
/**
 * Sets the new value from the attribute {@code markAsChanged}.
 * 
 * @param markAsChanged the new value for the attribute {@code markAsChanged}.
 */
public void setMarkAsChanged(final boolean markAsChanged);
```


### TagRelationBuilder<a name="TaReBu" />

```java
/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder} 
 * the developer can create easily an instance from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.core.TagRelation}.
 * <ul>
 * <li>All attributes are {@code mandory}.</li>
 * <li>All defined values will be validate against the {@code Interface} {@code Validator}.</li>
 * </ul>
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.TagRelation
 * @see    com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see    com.github.naoghuman.lib.tag.core.Validator
 */
public final class TagRelationBuilder
```


### TagRelation<a name="TaRe" />

```java
/**
 * A {@code TagRelation} is a simple mapping between a container like 
 * {@link javafx.scene.layout.FlowPane} and all {@code Tag}s which should be shown
 * in the container.
 * <p>
 * An instance from this {@code Interface} can be easily generated with the fluent 
 * builder {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder} which is 
 * the preferred way to generate an implementation from this {@code Interface}.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see    javafx.scene.layout.FlowPane
 */
public interface TagRelation extends Comparable<TagRelation>, Externalizable
```

```java
/**
 * Constant which defines the attribute {@code default-id}(= 
 * {@link java.lang.Long#MIN_VALUE}) from a {@code TagRelation}.
 */
public static final Long DEFAULT_ID = Long.MIN_VALUE;
```

```java
/**
 * Constant which defines the attribute {@code id}.
 */
public static final String TAG_RELATION__PARA__ID = "id"; // NOI18N
```

```java
/**
 * Constant which defines the attribute {@code containerId}.
 */
public static final String TAG_RELATION__PARA__CONTAINER_ID = "containerId"; // NOI18N
```

```java
/**
 * Constant which defines the attribute {@code containerType}.
 */
public static final String TAG_RELATION__PARA__CONTAINER_TYPE = "containerType"; // NOI18N
```

```java
/**
 * Constant which defines the attribute {@code tagId}.
 */
public static final String TAG_RELATION__PARA__TAG_ID = "tagId"; // NOI18N
```

```java
/**
 * Gets the value from the attribute {@code id} from this {@code TagRelation}.
 * 
 * @return the value from the attribute {@code id}.
 */
public long getId();
```

```java
/**
 * Sets the new value from the attribute {@code id}.
 * 
 * @param id the new value for the attribute {@code id}.
 */
public void setId(final Long id);
```

```java
/**
 * Returnes the attribute {@code id} as a {@link javafx.beans.property.LongProperty}.
 * 
 * @return the attribute {@code id} as a {@code LongProperty}.
 * @see    javafx.beans.property.LongProperty
 */
public LongProperty idProperty();
```

```java
/**
 * Gets the value from the attribute {@code tagId} from the {@code Tag}.
 * 
 * @return the value from the attribute {@code tagId}.
 */
public long getTagId();
```

```java
/**
 * Sets the new value from the attribute {@code tagId}.
 * 
 * @param tagId the new value for the attribute {@code tagId}.
 */
public void setTagId(final Long tagId);
```

```java
/**
 * Returnes the attribute {@code tagId} as a {@link javafx.beans.property.LongProperty}.
 * 
 * @return the attribute {@code tagId} as a {@code LongProperty}.
 * @see    javafx.beans.property.LongProperty
 */
public LongProperty tagIdProperty();
```

```java
/**
 * Gets the value from the attribute {@code containerId} which defines the 
 * {@code id} from the container where the {@code Tag} is added.
 * 
 * @return the value from the attribute {@code containerId}.
 */
public String getContainerId();
```

```java
/**
 * Sets the new value from the attribute {@code containerId}.
 * 
 * @param containerId the new value for the attribute {@code containerId}.
 */
public void setContainerId(final String containerId);
```

```java
/**
 * Returnes the attribute {@code containerId} as a {@link javafx.beans.property.StringProperty}.
 * 
 * @return the attribute {@code containerId} as a {@code StringProperty}.
 * @see    javafx.beans.property.StringProperty
 */
public StringProperty containerIdProperty();
```

```java
/**
 * Gets the value from the attribute {@code containerType} which defines the 
 * {@code type} from the container where the {@code Tag} is added.
 * 
 * @return the value from the attribute {@code containerType}.
 */
public String getContainerType();
```

```java
/**
 * Sets the new value from the attribute {@code containerType}.
 * 
 * @param containerType the new value for the attribute {@code containerType}.
 */
public void setContainerType(final String containerType);
```

```java
/**
 * Returnes the attribute {@code containerType} as a {@link javafx.beans.property.StringProperty}.
 * 
 * @return the attribute {@code containerType} as a {@code StringProperty}.
 * @see    javafx.beans.property.StringProperty
 */
public StringProperty containerTypeProperty();
```


### Validator<a name="Vali" />

```java
/**
 * This {@code Interface} contains different default methods to validate if an 
 * {@link java.lang.Object} conforms specific behaviours or not. For example if 
 * an {@code Object} is NULL or not.
 *
 * @author Naoghuman
 * @since  0.1.0
 * @see    java.lang.Object
 */
public interface Validator 
```

```java
/**
 * Validates if the parameter {@code value} isn't NULL.
 *
 * @param value the attribute which should be validated.
 * @param <T>   the type of the reference.
 * @throws      NullPointerException if (value == NULL).
 */
public default <T> void requireNonNull(T value) throws NullPointerException
```

```java
/**
 * Validates if the {@link java.lang.String} {@code value} isn't NULL and not EMPTY.
 *
 * @param value the attribute which should be validated.
 * @see         java.lang.String
 * @throws      NullPointerException if (value == NULL).
 * @throws      IllegalArgumentException if (value.trim() == EMPTY).
 */
public default void requireNonNullAndNotEmpty(String value) throws NullPointerException, IllegalArgumentException
```



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
[tagbuilder_v0.1.0_2017-07-15_10-48]:https://user-images.githubusercontent.com/8161815/28238038-702dd80a-694b-11e7-9779-0d2c904cce86.png
[tagrelationbuilder_v0.1.0_2017-05-28_09-35]:https://cloud.githubusercontent.com/assets/8161815/26526919/637c694c-4389-11e7-8d48-f79eef97df55.png



[//]: # (Links)
[Builder pattern]:https://en.wikipedia.org/wiki/Builder_pattern
[Business process modeling (BPM)]:https://en.wikipedia.org/wiki/Business_process_modeling
[Button]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
[Bizagi Modeler BPMN]:http://www.bizagi.com/de/produkte/plattform/modeler
[FlowPane]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/FlowPane.html
[Fluent Interface]:https://www.martinfowler.com/bliki/FluentInterface.html
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[Label]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html
[Lib-Tag]:https://github.com/Naoghuman/lib-tag
[Lib-Tag-Components]:https://github.com/Naoghuman/lib-tag/tree/master/lib-tag-components
[Step builder pattern]:http://www.svlada.com/step-builder-pattern/
[String]:https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
[Tag]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/Tag.java
[TagBuilder]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/TagBuilder.java
[TagRelation]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/TagRelation.java
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language
