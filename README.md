Lib-Tag
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
* [API: com.github.naoghuman.lib.tag.core](#LiTaCo)
    * [TagBuilder](#TaBu)
    * [Tag](#Tag)
    * [TagRelationBuilder](#TaReBu)
    * [TagRelation](#TaRe)
    * [TagRelationContainerIdBuilder](#TaReCoIdBu)
    * [TagRelationContainerId](#TaReCoId)
    * [TagValidator](#TaVa)
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



API: com.github.naoghuman.lib.tag.core<a name="LiTaCo" />
---


### TagBuilder<a name="TaBu" />

```java
/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.core.TagBuilder} 
 * the developer can easily create an instance from the {@code Interface} 
 * {@link com.github.naoghuman.lib.tag.core.Tag}.
 * <ul>
 * <li>The first two attributes {@code id} and {@code title} are mandory.</li>
 * <li>All other attributes are optional, that means skipping them returns {@link java.util.Optional#empty()}.</li>
 * <li>Any attribute (mandory or optional if set) will be validate against {@link com.github.naoghuman.lib.tag.core.TagValidator}.</li>
 * </ul>
 *
 * @author  Naoghuman
 * @since   0.1.0
 * @version 0.3.0
 * @see     com.github.naoghuman.lib.tag.core.Tag
 * @see     com.github.naoghuman.lib.tag.core.TagBuilder
 * @see     com.github.naoghuman.lib.tag.core.TagValidator
 * @see     java.util.Optional#empty()
 */
public final class TagBuilder
```

```java
/**
 * Starting point from this fluent builder to generate and configured an 
 * instance from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.Tag}.
 * 
 * @return the first step to generate and configured an instance from the 
 *         {@code Interface} {@code Tag}.
 * @see    com.github.naoghuman.lib.tag.core.Tag
 */
public static final IdStep create()
```

```java
/**
 * First mandory step to generate and configured an instance from the 
 * {@code Interface} {@code Tag}.<br>
 * This {@code Interface} allowed to set the attribute {@code id}.
 */
public interface IdStep
```

```java
/**
 * Second mandory step to generate and configured an instance from the 
 * {@code Interface} {@code Tag}.<br>
 * This {@code Interface} allowed to set the attribute {@code title}.
 */
public interface TitleStep 
```

```java
/**
 * Third mandory step to generate and configured an instance from the 
 * {@code Interface} {@code Tag}.<br>
 * This {@code Interface} allowed to set the attribute {@code generationTime}.
 */
public interface GenerationTimeStep
```

```java
/**
 * Optional steps for the configuration from the new instance from the 
 * {@code Interface} {@code Tag}.<br>
 * <ul>
 * <li>All attributes in this {@code Interface} are optional. If not set, then {@link java.util.Optional#empty()} will be returned.</li>
 * <li>All setted values will be validate against the {@code Interface} {@link com.github.naoghuman.lib.tag.core.TagValidator}.</li>
 * <li>For any optinal attribute if setted more then ones then the last {@code value} will be used for the configuration.</li>
 * </ul>
 * 
 * @see com.github.naoghuman.lib.tag.core.TagValidator
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
 * Constant which defines the name from the attribute {@code description}.
 */
public static final String TAG_PARA__DESCRIPTION = "description"; // NOI18N
```

```java
/**
 * Constant which defines the name from the attribute {@code id}.
 */
public static final String TAG_PARA__ID = "id";
```

```java
/**
 * Constant which defines the name from the attribute {@code generationTime}.
 */
public static final String TAG_PARA__GENERATION_TIME = "generationTime"; // NOI18N
```

```java
/**
 * Constant which defines the name from the attribute {@code style}.
 */
public static final String TAG_PARA__STYLE = "style"; // NOI18N
```

```java
/**
 * Constant which defines the name from the attribute {@code title}.
 */
public static final String TAG_PARA__TITLE = "title"; // NOI18N
```

```java
/**
 * Gets the value from the attribute {@code id} from this {@code Tag}.
 * 
 * @return the value from the attribute {@code id}.
 */
public long getId();
```

```java
/**
 * Sets the new value from the attribute {@code id}.<br>
 * This is an mandory value. Setting the value will validate the value against 
 * {@link com.github.naoghuman.lib.tag.core.TagValidator}.
 * 
 * @param  id the new value for the attribute {@code id}.
 * @throws NullPointerException if {@code id} is NULL.
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
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
 * {@link com.github.naoghuman.lib.tag.core.TagValidator}.
 * 
 * @param  title the new value for the attribute {@code title}.
 * @throws IllegalArgumentException if {@code id} is EMPTY.
 * @throws NullPointerException     if {@code id} is NULL.
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
 */
public void setTitle(final String title);
```

```java
/**
 * Gets the value from the attribute {@code generationTime} from this {@code Tag}.
 * 
 * @return the value from the attribute {@code generationTime}.
 */
public Long getGenerationTime();
```

```java
/**
 * Sets the new optional value from the attribute {@code generationTime}.<br>
 * If the value is set then it will be valid against 
 * {@link com.github.naoghuman.lib.tag.core.TagValidator}.
 * 
 * @param  generationTime the new value for the attribute {@code generationTime}.
 * @throws NullPointerException if {@code generationTime} is NULL.
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
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
 * Sets the new optional value from the attribute {@code description}.<br>
 * If the value is set then it will be valid against 
 * {@link com.github.naoghuman.lib.tag.core.TagValidator}.
 * 
 * @param  description the new value for the attribute {@code description}.
 * @throws IllegalArgumentException if {@code description} is EMPTY.
 * @throws NullPointerException     if {@code description} is NULL.
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
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
**
 * Sets the new optional value from the attribute {@code style}.<br>
 * If the value is set then it will be valid against 
 * {@link com.github.naoghuman.lib.tag.core.TagValidator}.
 * 
 * @param  style the new value for the attribute {@code style}.
 * @throws IllegalArgumentException if {@code style} is EMPTY.
 * @throws NullPointerException     if {@code style} is NULL.
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
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
 * <li>All defined values will be validate against the {@code Interface} 
 *     {@link com.github.naoghuman.lib.tag.core.TagValidator}.</li>
 * </ul>
 *
 * @author  Naoghuman
 * @since   0.1.0
 * @version 0.3.0
 * @see     com.github.naoghuman.lib.tag.core.TagRelation
 * @see     com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see     com.github.naoghuman.lib.tag.core.TagValidator
 */
public final class TagRelationBuilder
```

```java
/**
 * Starting point from this fluent builder to configured and generate an 
 * instance from the {@code Interface} {@link com.github.naoghuman.lib.tag.core.TagRelation}.
 * 
 * @return the first step to configure and generate an instance from the 
 *         {@code Interface} {@code TagRelation}.
 * @see    com.github.naoghuman.lib.tag.core.TagRelation 
 */
public static final IdStep create()
```

```java
/**
 * First mandory step to configure and generate an instance from the {@code Interface} 
 * {@code TagRelation}.<br>
 * This {@code Interface} allowed to set the attribute {@code id}.
 */
 public interface IdStep
```

```java
/**
 * Second mandory step to generate and configured an instance from the 
 * {@code Interface} {@code TagRelation}.<br>
 * This {@code Interface} allowed to set the attribute {@code tagId}.
 */
public interface TagIdStep
```

```java
/**
 * Third mandory step to generate and configured an instance from the 
 * {@code Interface} {@code TagRelation}.<br>
 * This {@code Interface} allowed to set the attribute {@code containerId}.
 */
public interface ContainerIdStep
```

```java
/**
 * Last step to generate and configured an instance from the {@code Interface} 
 * {@code TagRelation}.<br>
 * This {@code Interface} returned the generated and configured instance.
 */
public interface Builder
```



### TagRelation<a name="TaRe" />

```java
/**
 * A {@code TagRelation} is a simple mapping between a container like 
 * {@link javafx.scene.layout.FlowPane} and all {@code Tag}s which should be shown
 * in this container.
 * <p>
 * An instance from this {@code Interface} can be easily generated with the fluent 
 * builder {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder} which is 
 * the preferred way to generate an implementation from this {@code Interface}.
 *
 * @author  Naoghuman
 * @since   0.1.0
 * @version 0.3.0
 * @see     com.github.naoghuman.lib.tag.core.TagRelationBuilder
 * @see     javafx.scene.layout.FlowPane
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
 * Constant which defines the name from the attribute {@code id}.
 */
public static final String TAG_RELATION__PARA__ID = "id"; // NOI18N
```

```java
/**
 * Constant which defines the name from the attribute {@code containerId}.
 */
public static final String TAG_RELATION__PARA__CONTAINER_ID = "containerId"; // NOI18N
```

```java
/**
 * Constant which defines the name from the attribute {@code tagId}.
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
 * <p>
 * The new value will be valid against {@link com.github.naoghuman.lib.tag.core.TagValidator}.
 * 
 * @param  id the new value for the attribute {@code id}.
 * @throws NullPointerException if {@code id} is NULL.
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
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
 * <p>
 * The new value will be valid against {@link com.github.naoghuman.lib.tag.core.TagValidator}.
 * 
 * @param  tagId the new value for the attribute {@code tagId}.
 * @throws NullPointerException if {@code tagId} is NULL.
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
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
 * <p>
 * The new value will be valid against {@link com.github.naoghuman.lib.tag.core.TagValidator}.
 * 
 * @param  containerId the new value for the attribute {@code containerId}.
 * @throws IllegalArgumentException if {@code containerId} is EMPTY.
 * @throws NullPointerException     if {@code containerId} is NULL.
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
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


### TagRelationContainerIdBuilder<a name="TaReCoIdBu" />

```java
/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.core.TagRelationContainerIdBuilder} 
 * the developer can create easily an unique {@code Id} and returned it as a {@link java.lang.String}.
 * <p>
 * The main point from this {@code builder} is the possibility to generate an unique 
 * {@code Id} for a relation between a {@link com.github.naoghuman.lib.tag.core.Tag}
 * and the container where the {@code Tag} will be embbeded.
 * 
 * <ul>
 * <li>All attributes are {@code mandory}.</li>
 * <li>All defined values will be validate against the {@code Interface} 
 *     {@link com.github.naoghuman.lib.tag.core.TagValidator}.</li>
 * </ul>
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    com.github.naoghuman.lib.tag.core.TagRelation
 * @see    com.github.naoghuman.lib.tag.core.TagValidator
 */
public class TagRelationContainerIdBuilder
```

```java
/**
 * Starting point from this fluent builder to configure and create an unique {@code Id},
 * returned as a {@link java.lang.String}.
 * 
 * @return the first step to generate and configured an unique {@code Id}.
 */
public static final PathStep create()
```

```java
/**
 * First mandory step to configure and create an unique {@code Id}.<br>
 * This {@code Interface} allowed to set the attribute {@code path}.
 */
public interface PathStep
```

```java
/**
 * Second mandory step to configure and create an unique {@code Id}.<br>
 * This {@code Interface} allowed to set the attribute {@code container}.
 */
public interface ContainerStep
```

```java
/**
 * Third mandory step to configure and create an unique {@code Id}.<br>
 * This {@code Interface} allowed to set the attribute {@code containerId}.
 */
public interface ContainerIdStep
```

```java
/**
 * In the last step the unique {@code Id} will created and returned.<br>
 * This {@code Interface} allowed to generate the {@code Id}.
 */
public interface Builder
```


### TagRelationContainerId<a name="TaReCoId" />

```java
/**
 * This {@code Interface} contains the default method {@code generateId(Class, Class, String)}
 * which allowed the developer to generate an unique {@code Id} and returned it 
 * as a {@link java.lang.String}.
 * <p>
 * The main point from this {@code Interface} is the possibility to generate an unique 
 * {@code Id} for a relation between a {@link com.github.naoghuman.lib.tag.core.Tag}
 * and the container where the {@code Tag} will be embbeded.
 * <p>
 * For additional information about the {@code relation} plz see
 * {@link com.github.naoghuman.lib.tag.core.TagRelationBuilder}.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    com.github.naoghuman.lib.tag.core.TagRelation
 * @see    com.github.naoghuman.lib.tag.core.TagRelationBuilder
 */
public interface TagRelationContainerId
```

```java
/**
 * Generates an (unique) {@code Id} as an {@link java.lang.String}.
 * 
 * The format from the {@code Id} is:
 * <ul>
 * <li>path.getCanonicalName() + '_' + container.getSimpleName() + '_' + containerId</li>
 * </ul>
 * 
 * Example:
 * <ul>
 * <li>com.github.naoghuman.lib.tag.internal.DefaultIdGeneratorTest_AnchorPane_832531206890821</li>
 * </ul>
 * 
 * Internal {@link com.github.naoghuman.lib.tag.internal.DefaultTagValidator}
 * will be used to validate if {@code path}, {@code container} and {@code containerId} isn't NULL. The parameter 
 * {@code containerId} will be checked additional if it isn't EMPTY.
 * 
 * @param  path        usually the path from the class where the {@code Tag} used.
 * @param  container   usually the type of the container where the {@code Tag} should be embbeded.
 * @param  containerId the {@code Id} from the container.
 * @return the generated {@code Id}.
 * @throws IllegalArgumentException if the containerId is EMPTY.
 * @throws NullPointerException     if path, container or containerId is NULL.
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.internal.DefaultTagValidator
 * @see    java.lang.System#nanoTime()
 */
public String generateId(final Class path, final Class container, final String containerId);
```


### TagValidator<a name="TaVa" />

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
public interface TagValidator
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
