Lib-Tag-Component
===



Intention
---

The sublibrary `Lib-Tag-Component` contains different possibilities to show a 
[Tag] in different [JavaFX] gui components.
* Currently a `Tag` can be presented as a [Button] or a [Label].
* A list of `Tag`s can then be shown in the container [FlowPane].

_Image:_ [UML] Lib-Tag-Component  
![uml_lib-tag-components_2018-01-01_07-10.png][uml_lib-tag-components_2018-01-01_07-10]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

> __Hint__  
> This libray is a part of the project [Lib-Tag]. Plz see for additional 
> informations like `Download`, `Requirements` or `Installation` there. Thanks :smile:



Content
---
* [Examples](#Examples)
    * [Usage of the class `TagButtonBuilder`](#UsOfThClTaBuBu)
    * [Usage of the class `TagLabelBuilder`](#UsOfThClTaLaBu)
    * [Usage of the class `TagFlowPaneBuilder`](#UsOfThClTaFlPaBu)
* [API: com.github.naoghuman.lib.tag.component.core](#LiTaCom)
    * [TagButtonBuilder](#TaBuBu)
    * [TagLabelBuilder](#TaLaBu)
    * [TagFlowPaneBuilder](#TaFlPaBu)
    * [TagComponentEventHandler](#TaCoEvHa)
    * [TagComponentValidator](#TaCoVa)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Examples<a name="Examples" />
---


### Usage of the class `TagButtonBuilder`<a name="UsOfThClTaBuBu" />

It is very easy to create a [Button] in context from this library with the fluent 
builder [TagButtonBuilder]:

```java
/**
 * The fluent builder {@link com.github.naoghuman.lib.tag.component.core.TagButtonBuilder} 
 * allowed to create easly a configured {@link javafx.scene.control.Button} with the 
 * given {@link com.github.naoghuman.lib.tag.core.Tag}.
 * 
 * <ul>
 * <li>All attributes are mandory.</li>
 * <li>All values will be validate against the {@code Interface} {@code TagComponentValidator}.</li>
 * </ul>
 * 
 * @see com.github.naoghuman.lib.tag.component.core.TagButtonBuilder
 * @see com.github.naoghuman.lib.tag.component.core.TagComponentValidator
 * @see com.github.naoghuman.lib.tag.core.Tag
 * @see javafx.scene.control.Button
 */
final Button btn = TagButtonBuilder.create()
        .tag(null)           // mandory (NOT NULL)
        .actionHandler(null) // mandory (NOT NULL)
        .mouseHandler(null)  // mandory (NOT NULL)
        .build();
        
// Example from the usage from TagComponentEventHandler
final EventHandler<ActionEvent> actionHandler = TagComponentEventHandler.actionHandler(Long.MIN_VALUE);
final EventHandler<MouseEvent>  mouseHandler  = TagComponentEventHandler.mouseHandler(Long.MIN_VALUE, 
        TagComponentEventHandler.MouseClick.ONE_RIGHT_CLICK);
final Button btn2 = TagButtonBuilder.create()
        .tag(null)                    // mandory (NOT NULL)
        .actionHandler(actionHandler) // mandory (NOT NULL)
        .mouseHandler(mouseHandler)   // mandory (NOT NULL)
        .build();
```

The same __as__ a [Business process modeling (BPM)] diagram (create with the tool [Bizagi Modeler BPMN]):  
_Image:_ Business process modeling diagram from `TagButtonBuilder`  
![bpm_lib-tag-component_tagbuttonbuilder_2017-12-30_14-43.png][bpm_lib-tag-component_tagbuttonbuilder_2017-12-30_14-43]

> __Hint__  
> . The generation from the `Button` starts with the method `create()`.  
> . `Green` rectangles are `mandory` attributes.  
> . The `Button` will then created with the last method `build()`.

__Additional informations__  
For additional informations about the used design patterns see: [Fluent Interface], 
[Builder pattern] and [Step builder pattern]


### Usage of the class `TagLabelBuilder`<a name="UsOfThClTaLaBu" />

To create a [Label] in context from this library with the fluent 
builder [TagLabelBuilder] you have following possibilities:

```java
/**
 * The fluent builder {@link com.github.naoghuman.lib.tag.component.core.TagLabelBuilder} 
 * allowed to create easly a configured {@link javafx.scene.control.Label} with the 
 * given {@link com.github.naoghuman.lib.tag.core.Tag}.
 * 
 * <ul>
 * <li>All attributes are mandory.</li>
 * <li>All values will be validate against the {@code Interface} {@code TagComponentValidator}.</li>
 * </ul>
 * 
 * @see com.github.naoghuman.lib.tag.component.core.TagLabelBuilder
 * @see com.github.naoghuman.lib.tag.component.core.TagComponentValidator
 * @see com.github.naoghuman.lib.tag.core.Tag
 * @see javafx.scene.control.Label
 */
final Label lbl = TagLabelBuilder.create()
        .tag(null)          // mandory (NOT NULL)
        .mouseHandler(null) // mandory (NOT NULL)
        .build();
        
// Example from the usage from the enum TagComponentEventHandler.MouseClick
final EventHandler<MouseEvent>  mouseHandler = TagComponentEventHandler.mouseHandler(Long.MIN_VALUE, 
        TagComponentEventHandler.MouseClick.DOUBLE_LEFT_OR_ONE_RIGHT_CLICK);
final Label lbl2 = TagLabelBuilder.create()
        .tag(null)                  // mandory (NOT NULL)
        .mouseHandler(mouseHandler) // mandory (NOT NULL)
        .build();
```

The same __as__ a [Business process modeling (BPM)] diagram (create with the tool [Bizagi Modeler BPMN]):  
_Image:_ Business process modeling diagram from `TagLabelBuilder`  
![bpm_lib-tag-component_taglabelbuilder_2017-12-30_18-26.png][bpm_lib-tag-component_taglabelbuilder_2017-12-30_18-26]

> __Hint__  
> . The generation from the `Label` starts with the method `create()`.  
> . `Green` rectangles are `mandory` attributes.  
> . The `Label` will then created with the last method `build()`.

__Additional informations__  
For additional informations about the used design patterns see: [Fluent Interface], 
[Builder pattern] and [Step builder pattern]


### Usage of the class `TagFlowPaneBuilder`<a name="UsOfThClTaFlPaBu" />

A [FlowPane] in context from this library can be created with the fluent 
builder [TagFlowPaneBuilder] where you have following possibilities:

```java
/**
 * The fluent builder {@link com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder} 
 * allowed to configured a {@link javafx.scene.layout.FlowPane} with a list from 
 * {@link com.github.naoghuman.lib.tag.core.Tag} which are wrapped in 
 * {@link javafx.scene.control.Button}s or {@link javafx.scene.control.Label}s.
 * 
 * <ul>
 * <li>All attributes are mandory.</li>
 * <li>All values will be validate against the {@code Interface} {@code TagComponentValidator}.</li>
 * </ul>
 * 
 * @see com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder
 * @see com.github.naoghuman.lib.tag.component.core.TagComponentValidator
 * @see com.github.naoghuman.lib.tag.core.Tag
 * @see javafx.scene.control.Button
 * @see javafx.scene.control.Label
 * @see javafx.scene.layout.FlowPane
 */
final FlowPane fpWithButtons = TagFlowPaneBuilder.create()
        .style("style") // mandory (NOT NULL)
        .buttons(null)  // mandory (NOT NULL)
        .build();
        
final FlowPane fpWithLabels = TagFlowPaneBuilder.create()
        .style("style") // mandory (NOT NULL)
        .labels(null)   // mandory (NOT NULL)
        .build();
```

Again the same __as__ a [Business process modeling (BPM)] diagram (create with the tool [Bizagi Modeler BPMN]):  
_Image:_ Business process modeling diagram from `TagFlowPaneBuilder`  
![bpm_lib-tag-component_tagflowpanebuilder_2018-01-01_07-26.png][bpm_lib-tag-component_tagflowpanebuilder_2018-01-01_07-26]

> __Hint__  
> . The generation from the `Label` starts with the method `create()`.  
> . `Green` rectangles are `mandory` attributes.  
> . The `Label` will then created with the last method `build()`.

__Additional informations__  
For additional informations about the used design patterns see: [Fluent Interface], 
[Builder pattern] and [Step builder pattern]



API: com.github.naoghuman.lib.tag.component.core<a name="LiTaCom" />
---


### TagButtonBuilder<a name="TaBuBu" />

```java
/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.component.core.TagButtonBuilder} 
 * the developer can easily create an instance from a {@link javafx.scene.control.Button} 
 * configured with a {@link com.github.naoghuman.lib.tag.core.Tag} and different 
 * {@link javafx.event.EventHandler}s.
 * <ul>
 * <li>All attributes are mandory.</li>
 * <li>Any attribute will be validate against {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.</li>
 * </ul>
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.component.core.TagButtonBuilder
 * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.event.EventHandler
 * @see    javafx.scene.control.Button
 */
public final class TagButtonBuilder
```

```java
/**
 * Starting point from this fluent builder to generate and configured an instance 
 * from a {@link javafx.scene.control.Button} configured with the given 
 * {@link com.github.naoghuman.lib.tag.core.Tag} and different {@link javafx.event.EventHandler}s.
 * <p>
 * Internal all attributes will be validate against 
 * {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @return the first step {@code TagStep} from this fluent builder.
 * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.scene.control.Button
 * @see    javafx.scene.control.EventHandler
 */
public static final TagStep create()
```

```java
/**
 * First mandory step to generate and configured an instance from a 
 * {@link javafx.scene.control.Button}.
 * <br>
 * This {@code Interface} allowed to set the attribute {@code tag}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    javafx.scene.control.Button
 */
public interface TagStep 
```

```java
/**
 * Second mandory step to generate and configured an instance from a 
 * {@link javafx.scene.control.Button}.
 * <br>
 * This {@code Interface} allowed to set the attribute {@code actionHandler}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    javafx.scene.control.Button
 */
public interface ActionHandlerStep
```

```java
/**
 * Third mandory step to generate and configured an instance from a 
 * {@link javafx.scene.control.Button}.
 * <br>
 * This {@code Interface} allowed to set the attribute {@code mouseHandler}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    javafx.scene.control.Button
 */
public interface MouseHandlerStep
```

```java
/**
 * Last step to generate and configured an instance from a 
 * {@link javafx.scene.control.Button}.
 * <br>
 * This {@code Interface} returned the generated and configured {@code Button} 
 * in context from the library {@code Lib-Tag}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    javafx.scene.control.Button
 */
public interface BuilderStep
```


### TagLabelBuilder<a name="TaLaBu" />

```java
/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.component.core.TagLabelBuilder} 
 * the developer can easily create an instance from a {@link javafx.scene.control.Label} 
 * configured with a {@link com.github.naoghuman.lib.tag.core.Tag} and different 
 * {@link javafx.event.EventHandler}s.
 * <ul>
 * <li>All attributes are mandory.</li>
 * <li>Any attribute will be validate against {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.</li>
 * </ul>
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.component.core.TagButtonBuilder
 * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.event.EventHandler
 * @see    javafx.scene.control.Label
 */
public final class TagLabelBuilder 
```

```java
/**
 * Starting point from this fluent builder to generate and configured an instance 
 * from a {@link javafx.scene.control.Label} configured with the given 
 * {@link com.github.naoghuman.lib.tag.core.Tag} and different {@link javafx.event.EventHandler}s.
 * <p>
 * Internal all attributes will be validate against 
 * {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @return the first step {@code TagStep} from this fluent builder.
 * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.scene.control.Label
 * @see    javafx.scene.control.EventHandler
 */
public static final TagStep create()
```

```java
/**
 * First mandory step to generate and configured an instance from a 
 * {@link javafx.scene.control.Label}.
 * <br>
 * This {@code Interface} allowed to set the attribute {@code tag}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    javafx.scene.control.Label
 */
public interface TagStep
```

```java
/**
 * Second mandory step to generate and configured an instance from a 
 * {@link javafx.scene.control.Label}.
 * <br>
 * This {@code Interface} allowed to set the attribute {@code mouseHandler}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    javafx.scene.control.Label
 */
public interface MouseHandlerStep
```

```java
/**
 * Last step to generate and configured an instance from a 
 * {@link javafx.scene.control.Label}.
 * <br>
 * This {@code Interface} returned the generated and configured {@code Label} 
 * in context from the library {@code Lib-Tag}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    javafx.scene.control.Label
 */
public interface BuilderStep
```


### TagFlowPaneBuilder<a name="TaFlPaBu" />

```java
/**
 * With the fluent builder {@code Class} {@link com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder} 
 * the developer can easily create an instance from a {@link javafx.scene.layout.FlowPane} 
 * configured with a list from {@link javafx.scene.control.Button}s or {@link javafx.scene.control.Label}s 
 * which elements presented a {@link com.github.naoghuman.lib.tag.core.Tag}.
 * <ul>
 * <li>All attributes are mandory.</li>
 * <li>Any attribute will be validate against {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.</li>
 * </ul>
 * 
 * The list ({@code buttons} or {@code labels}) can easily with the fluent builders 
 * {@link com.github.naoghuman.lib.tag.component.core.TagButtonBuilder} or 
 * {@link com.github.naoghuman.lib.tag.component.core.TagLabelBuilder}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.component.core.TagButtonBuilder
 * @see    com.github.naoghuman.lib.tag.component.core.TagFlowPaneBuilder
 * @see    com.github.naoghuman.lib.tag.component.core.TagLabelBuilder
 * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.scene.control.Button
 * @see    javafx.scene.control.Label
 * @see    javafx.scene.layout.FlowPane
 */
public final class TagFlowPaneBuilder
```

```java
/**
 * Starting point from this fluent builder to generate and configured an instance 
 * from a {@link javafx.scene.layout.FlowPane} configured with a list from 
 * {@link javafx.scene.control.Button}s or {@link javafx.scene.control.Label}s 
 * which elements presented a {@link com.github.naoghuman.lib.tag.core.Tag}.
 * <p>
 * Internal all attributes will be validate against 
 * {@link com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @return the first step {@code StyleStep} from this fluent builder.
 * @see    com.github.naoghuman.lib.tag.component.internal.DefaultTagComponentValidator
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.scene.control.Button
 * @see    javafx.scene.control.Label
 * @see    javafx.scene.layout.FlowPane
 */
public static final StyleStep create()
```

```java
/**
 * First mandory step to generate and configured an instance from a 
 * {@link javafx.scene.layout.FlowPane}.
 * <br>
 * This {@code Interface} allowed to set the attribute {@code style}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    javafx.scene.layout.FlowPane
 */
public interface StyleStep
```

```java
/**
 * Second mandory step to generate and configured an instance from a 
 * {@link javafx.scene.layout.FlowPane}.
 * <br>
 * This {@code Interface} allowed to set the childrens from the {@code FlowPane}. 
 * Either this can be a list from {@link javafx.scene.control.Button}s or a list 
 * {@link javafx.scene.control.Label}s which elements presented a 
 * {@link com.github.naoghuman.lib.tag.core.Tag}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.scene.control.Button
 * @see    javafx.scene.control.Label
 * @see    javafx.scene.layout.FlowPane
 */
public interface ChildrenStep
```

```java
/**
 * Last step to generate and configured an instance from a 
 * {@link javafx.scene.layout.FlowPane} in context from the library {@code Lib-Tag}.
 * <br>
 * This {@code Interface} returned the generated and configured {@code FlowPane}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    javafx.scene.control.FlowPane
 */
public interface BuilderStep
```


### TagComponentEventHandler<a name="TaCoEvHa" />

```java
/**
 * The class {@code TagComponentEventHandler} allowed to configure different 
 * {@link javafx.event.EventHandler}s in context from the library {@code Lib-Action}.
 * <br>
 * That means the events transferred a {@link com.github.naoghuman.lib.action.core.TransferData} 
 * when they triggered.
 * <p>
 * With the enum {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick} 
 * the developer can configure under which conditions the {@code EventHandler} will trigger. 
 * For example with the value {@code MouseClick#ONE_RIGHT_CLICK} the mouse event will 
 * trigger when the user clicks {@code one right click} on the given component.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick
 * @see    javafx.event.EventHandler
 */
public final class TagComponentEventHandler
```

```java
/**
 * Constant which defines an {@code actionId} which allowed to receive the 
 * {@link com.github.naoghuman.lib.action.core.TransferData} transferred by 
 * the {@link javafx.event.EventHandler} returned by 
 * {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#actionHandler(java.lang.Long)}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#actionHandler(java.lang.Long)
 * @see    javafx.event.EventHandler
 */
public static final String ON_ACTION__TRIGGER_ACTION_EVENT = "ON_ACTION__TRIGGER_ACTION_EVENT"; // NOI18N
```

```java
/**
 * Constant which defines an {@code actionId} which allowed to receive the 
 * {@link com.github.naoghuman.lib.action.core.TransferData} transferred by 
 * the {@link javafx.event.EventHandler} returned by 
 * {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick)}.
 * <br>
 * The parameter {@code MouseClick} need to be {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick#DOUBLE_LEFT_CLICK}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick)
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick
 * @see    javafx.event.EventHandler
 */
public static final String ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK = "ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK"; // NOI18N
```

```java
/**
 * Constant which defines an {@code actionId} which allowed to receive the 
 * {@link com.github.naoghuman.lib.action.core.TransferData} transferred by 
 * the {@link javafx.event.EventHandler} returned by 
 * {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick)}.
 * <br>
 * The parameter {@code MouseClick} need to be {@link com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick#ONE_RIGHT_CLICK}.
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#mouseHandler(java.lang.Long, com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick)
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick
 * @see    javafx.event.EventHandler
 */
public static final String ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK = "ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK"; // NOI18N
```

```java
/**
 * Creates an {@link javafx.event.EventHandler} where the transferred
 * {@link com.github.naoghuman.lib.action.core.TransferData} will configured with 
 * the following values:
 * <ul>
 * <li>The given {@code tagId} (can then received with transferData.getLong()).</li>
 * <li>The {@code actionId} which is {@code ON_ACTION__TRIGGER_ACTION_EVENT} (can then received with transferData.getActionId()).</li>
 * </ul>
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @param  tagId the {@code id} from the {@link com.github.naoghuman.lib.tag.core.Tag}.
 * @return 
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#ON_ACTION__TRIGGER_ACTION_EVENT
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.event.EventHandler
 */
public static final EventHandler<ActionEvent> actionHandler(Long tagId)
```

```java
/**
 * Creates an {@link javafx.event.EventHandler} where the transferred
 * {@link com.github.naoghuman.lib.action.core.TransferData} will configured with 
 * the following values:
 * <ul>
 * <li>The given {@code tagId} (can then received with transferData.getLong()).</li>
 * <li>The given {@code mouseTrigger} which allowed to configure the {@code EventHandler}.</li>
 * <li>The {@code actionId} which is {@code ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK} 
 * or {@code ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK} (can then received with transferData.getActionId()).</li>
 * </ul>
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @param  tagId the {@code id} from the {@link com.github.naoghuman.lib.tag.core.Tag}.
 * @param  mouseTrigger allowed the developer to configure the {@code EventHandler}.
 * @return 
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#ON_ACTION__TRIGGER_MOUSE_EVENT__DOUBLE_LEFT_CLICK
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler#ON_ACTION__TRIGGER_MOUSE_EVENT__ONE_RIGHT_CLICK
 * @see    com.github.naoghuman.lib.tag.component.core.TagComponentEventHandler.MouseClick
 * @see    com.github.naoghuman.lib.tag.core.Tag
 * @see    javafx.event.EventHandler
 */
public static final EventHandler<MouseEvent> mouseHandler(final Long tagId, final MouseClick mouseTrigger)
```

```java
/**
 * Enum which help to distinguish different {@link javafx.scene.input.MouseEvent}.
 * <p>
 * The single constants from this enum described the under which conditions 
 * the mouse event will trigger with the given {@code actionId} (which allowed 
 * then to receive the {@link com.github.naoghuman.lib.action.core.TransferData}.
 * <br>
 * For example:
 * <ul>
 * <li>{@code DOUBLE_LEFT_CLICK} will be triggered if the user double left clicks on the given component.</li>
 * </ul>
 * 
 * @author Naoghuman
 * @since  0.3.0
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    javafx.scene.input.MouseEvent
 */
public enum MouseClick
```


### TagComponentValidator<a name="TaCoVa" />

```java
/**
 * This {@code Interface} contains different default methods to validate if an 
 * {@link java.lang.Object} conforms specific behaviours or not. For example if 
 * an {@code Object} is NULL or not.
 *
 * @author Naoghuman
 * @since  0.3.0
 * @see    java.lang.Object
 */
public interface TagComponentValidator
```

```java
/**
 * Validates if the parameter {@code value} isn't NULL.
 *
 * @author      Naoghuman
 * @param value the attribute which should be validated.
 * @param <T>   the type of the reference.
 * @throws      NullPointerException if (value == NULL).
 * @since       0.3.0
 */
public default <T> void requireNonNull(T value) throws NullPointerException
```

```java
/**
 * Validates if the {@link java.lang.String} {@code value} isn't NULL and not EMPTY.
 *
 * @author      Naoghuman
 * @param value the attribute which should be validated.
 * @see         java.lang.String
 * @throws      NullPointerException if (value == NULL).
 * @throws      IllegalArgumentException if (value.trim() == EMPTY).
 * @since       0.3.0
 */
public default void requireNonNullAndNotEmpty(String value) throws NullPointerException, IllegalArgumentException
```



License<a name="License" />
---

The project `Lib-Tag-Component` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Lib-Tag-Component` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[bpm_lib-tag-component_tagbuttonbuilder_2017-12-30_14-43]:https://user-images.githubusercontent.com/8161815/34454662-29980196-ed70-11e7-8a46-7d1649cef2b6.png
[bpm_lib-tag-component_tagflowpanebuilder_2018-01-01_07-26]:https://user-images.githubusercontent.com/8161815/34466006-0e7b4af6-eec6-11e7-9317-3624bc894178.png
[bpm_lib-tag-component_taglabelbuilder_2017-12-30_18-26]:https://user-images.githubusercontent.com/8161815/34456118-2e6a826a-ed8f-11e7-9e39-db57f64b7385.png
[uml_lib-tag-components_2018-01-01_07-10]:https://user-images.githubusercontent.com/8161815/34465913-13d2989a-eec3-11e7-8298-0298c375b51f.png



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
[Step builder pattern]:http://www.svlada.com/step-builder-pattern/
[Tag]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/Tag.java
[TagButtonBuilder]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-component/src/main/java/com/github/naoghuman/lib/tag/component/core/TagButtonBuilder.java
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language
