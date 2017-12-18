Lib-Tag-Component
===



Intention
---

The sublibrary `Lib-Tag-Component` contains different possibilities to show a 
[Tag] in different [JavaFX] gui components.
* Currently a `Tag` can be represented as a [Button] or a [Label].
* A list of `Tag`s can then be shown in the container [FlowPane].

_Image:_ [UML] Lib-Tag-Component  
![uml_lib-tag-components_2017-12-16_21-53.png][uml_lib-tag-components_2017-12-16_21-53]

> __Hint__  
> The `UML` diagram is created with the `Online Modeling Platform` [GenMyModel].

> __Hint__  
> This libray is a part of the project [Lib-Tag]. Plz see for additional 
> informations like `Download`, `Requirements` or `Installation` there. Thanks :smile:



Content
---
* [API: com.github.naoghuman.lib.tag.component.core](#LiTaCom)
    * [TagComponentsFacade](#TaComFa)
    * [TagButton](#TaBu)
    * [TagLabel](#TaLa)
    * [TagFlowPane](#TaFlPa)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



API: com.github.naoghuman.lib.tag.component.core<a name="LiTaCom" />
---


### TagComponentsFacade<a name="TaComFa" />

```java
/**
 * Over the {@code Class} {@link com.github.naoghuman.lib.tag.component.core.TagComponentsFacade} 
 * the developer have access to several possibilities to show a {@link  com.github.naoghuman.lib.tag.core.Tag} 
 * in different {@code JavaFX} gui components.
 * <p>
 * Momentary following possibilities exists:<br>
 * Show a {@code Tag} as a
 * <ul>
 * <li>JavaFX {@link javafx.scene.control.Button}.</li>
 * <li>JavaFX {@link javafx.scene.control.Label}.</li>
 * </ul>
 * Show a {@link java.util.List} of {@code Tag}s in a
 * <ul>
 * <li>JavaFX {@link javafx.scene.layout.FlowPane}.</li>
 * </ul>
 * 
 * @author Naoghuman
 * @since  0.2.0
 * @see    com.github.naoghuman.lib.tag.component.core.TagButton
 * @see    com.github.naoghuman.lib.tag.component.core.TagFlowPane
 * @see    com.github.naoghuman.lib.tag.component.core.TagLabel
 */
public final class TagComponentsFacade implements TagButton, TagFlowPane, TagLabel
```

```java
/**
 * Returns a singleton instance from the class {@code TagComponentsFacade}.
 * 
 * @return a singleton instance from the class {@code TagComponentsFacade}.
 */
public static final TagComponentsFacade getDefault()
```


### TagButton<a name="TaBu" />

```java
/**
 * TODO
 * 
 * @author Naoghuman
 * @since  0.2.0
 */
public interface TagButton
```


### TagLabel<a name="TaLa" />

```java
/**
 * TODO
 * 
 * @author Naoghuman
 * @since  0.2.0
 */
public interface TagLabel
```


### TagFlowPane<a name="TaFlPa" />

```java
/**
 * TODO
 * 
 * @author Naoghuman
 * @since  0.2.0
 */
public interface TagFlowPane
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
[uml_lib-tag-components_2017-12-16_21-53]:https://user-images.githubusercontent.com/8161815/34074267-d60f73d4-e2ab-11e7-91d6-8eb2a611cc03.png



[//]: # (Links)
[Button]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html
[FlowPane]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/FlowPane.html
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[GenMyModel]:https://www.genmymodel.com/
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[Label]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html
[Lib-Tag]:https://github.com/Naoghuman/lib-tag
[Tag]:https://github.com/Naoghuman/lib-tag/blob/master/lib-tag-core/src/main/java/com/github/naoghuman/lib/tag/core/Tag.java
[UML]:https://en.wikipedia.org/wiki/Unified_Modeling_Language
