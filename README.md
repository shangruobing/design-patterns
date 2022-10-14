# Design Patterns

***Use Java to learn and implement design patterns.***

***Reference book:*** [*Refactoring and Design Patterns*](https://refactoring.guru/)



# 相关概念

## 面向对象程序设计

- 抽象：对真实世界对象的特定属性和动作进行建模
- 封装：隐藏对象自身部分属性和行为，只对外暴露部分内容
- 继承：根据已有类创建新类，实现代码复用
- 多态：根据对象所继承的父类，调用其子类具体实现的能力



## 对象之间的关系

- 依赖：最基础、最微弱的关系，如类中使用其他类的方法
- 关联：一个对象使用另一个对象(永久性联系)，如类成员变量
- 聚合：一个对象”包含“一组其他对象，并扮演着容器的角色
- 组合：一种特殊的聚合，组合中的组件不能单独存在，而聚合中的组件可以单独存在
- 实现：类class实现接口interface中定义的方法
- 继承：类class继承父类superclass的接口和实现，并且可以进行拓展



## 软件设计原则

- 代码复用：类、模式、框架
- 扩展性：**变化**是生命中唯一不变的事情
- 封装性：将程序中不变的内容封装起来
- 面向接口进行开发，而不是面向实现
- 依赖于抽象类型，而不是具体类
- 组合优于继承，继承是”是“关系，组合是”有“关系



## SOLID原则

- 单一职责原则(每个类只负责软件中的一个功能)

- 开闭原则(一个类要鼓励”拓展“，拒绝”修改“)

- 里氏替换原则(子类必须保持与父类行为的兼容)

- 接口隔离原则(尽量缩小接口的范围，避免实现不必要的行为)

- 依赖倒置原则(低层次的类依赖于高层次的抽象)

  

**里氏替换原则补充**

- 子类方法参数类型必须比其超类的参数类型相匹配或更加抽象
- 子类方法的返回值类型必须与超类方法的返回值类型或是其子类别相匹配
- 子类中的方法不应抛出基础方法预期之外的异常类型
- 子类不应该加强其前置条件(父类允许int，子类只要正数)
- 子类不能削弱其后置条件
- 超类的不变量必须保留
- 子类不能修改超类中私有成员变量的值

  

## 设计模式

**设计模式**是软件设计中常见问题的典型解决方案。 它们就像能根据需求进行调整的预制蓝图， 可用于解决代码中反复出现的设计问题。

- 创建型模式：提供创建对象的机制， 增加已有代码的灵活性和可复用性
- 结构型模式：介绍如何将对象和类组装成较大的结构， 并同时保持结构的灵活和高效
- 行为模式：负责对象间的高效沟通和职责委派



# 创建型模式

*创建型模式提供了创建对象的机制， 能够提升已有代码的灵活性和可复用性。*

## 工厂方法

*亦称：虚拟构造函数、Virtual Constructor、Factory Method*

**工厂方法**是一种创建型设计模式，其在父类中提供一个创建对象的方法，允许子类决定实例化对象的类型。

> 如需要制作古典音乐和流行音乐，但是希望创造出来的音乐是属于同一种类的，那么如何来做呢？

```mermaid
classDiagram
direction BT
class AbstractMusicFactory {
  + createMusic() Music
}
class ClassicMusic {
  + play() void
}
class ClassicMusicFactory {
  + createMusic() Music
}
class Music {
<<Interface>>
  + play() void
}
class PopMusic {
  + play() void
}
class PopMusicFactory {
  + createMusic() Music
}

ClassicMusic  ..>  Music 
ClassicMusicFactory  -->  AbstractMusicFactory 
PopMusic  ..>  Music 
PopMusicFactory  -->  AbstractMusicFactory
```

步骤1：创建一个产品接口

```java
public interface Music {
    void play();
}
```

步骤2：创建实现接口的实体类

```java
public class ClassicMusic implements Music {

    @Override
    public void play() {
        System.out.println("Classical music is playing.");
    }
}

public class PopMusic implements Music {

    @Override
    public void play() {
        System.out.println("Pop music is playing.");
    }
}
```

步骤3：创建一个抽象工厂

```java
public abstract class AbstractMusicFactory {
    public abstract Music createMusic();
}
```

步骤4：创建实现抽象工厂的工厂类

```java
public class ClassicMusicFactory extends AbstractMusicFactory {

    @Override
    public Music createMusic() {
        return new ClassicMusic();
    }
}

public class PopMusicFactory extends AbstractMusicFactory {

    @Override
    public Music createMusic() {
        return new PopMusic();
    }
}
```

步骤5：通过工厂获得产品

```java
public class MainApp {
    public static void main(String[] args) {
        ClassicMusicFactory classicMusicFactory = new ClassicMusicFactory();
        classicMusicFactory.createMusic().play();
        PopMusicFactory popMusicFactory = new PopMusicFactory();
        popMusicFactory.createMusic().play();
    }
}
```



## 抽象工厂

*亦称：Abstract Factory*
**抽象工厂**是一种创建型设计模式，它能创建一**系列**相关的对象，而无需指定其具体类。

> 如需要生产下面4种产品，按照**工厂模式**需要4个不同的工厂，而使用**抽象工厂**，则可以根据品牌进行生产。

| 品牌  | 电视   | 冰箱   |
|-----|------|------|
| 海信  | 海信电视 | 海信冰箱 |
| 海尔  | 海尔电视 | 海尔冰箱 |

```mermaid
classDiagram
direction BT
class AbstractFactory {
  + createTelevision() Television
  + createFridge() Fridge
}
class Fridge {
<<Interface>>
  + freeze() void
}
class HaierFactory {
  + createFridge() Fridge
  + createTelevision() Television
}
class HaierFridge {
  + freeze() void
}
class HaierTelevision {
  + play() void
}
class HisenseFactory {
  + createFridge() Fridge
  + createTelevision() Television
}
class HisenseFridge {
  + freeze() void
}
class HisenseTelevision {
  + play() void
}
class Television {
<<Interface>>
  + play() void
}

HaierFactory  -->  AbstractFactory 
HaierFridge  ..>  Fridge 
HaierTelevision  ..>  Television 
HisenseFactory  -->  AbstractFactory 
HisenseFridge  ..>  Fridge 
HisenseTelevision  ..>  Television 
```

步骤1：创建一个电视接口

```java
public interface Television {
    void play();
}
```

步骤2：创建实现电视接口的实体类

```java
public class HisenseTelevision implements Television{

    @Override
    public void play() {
        System.out.println("Hisense TV is playing.");
    }
}

public class HaierTelevision implements Television {

    @Override
    public void play() {
        System.out.println("Haier TV is playing.");
    }
}
```

步骤3：创建一个冰箱接口

```java
public interface Fridge {
    void freeze();
}
```

步骤4：创建实现冰箱接口的实体类

```java
public class HisenseFridge implements Fridge {

    @Override
    public void freeze() {
        System.out.println("Hisense Fridge is freezing.");
    }
}

public class HaierFridge implements Fridge {

    @Override
    public void freeze() {
        System.out.println("Haier Fridge is freezing.");
    }
}
```

步骤5：创建抽象工厂用于制造冰箱和电视。

```java
public abstract class AbstractFactory {
    public abstract Television createTelevision();
    public abstract Fridge createFridge();
}
```

步骤6：各品牌分别实现抽象工厂

```java
public class HisenseFactory extends AbstractFactory {

    @Override
    public Television createTelevision() {
        return new HisenseTelevision();
    }

    @Override
    public Fridge createFridge() {
        return new HisenseFridge();
    }
}

public class HaierFactory extends AbstractFactory {
    @Override
    public Television createTelevision() {
        return new HaierTelevision();
    }

    @Override
    public Fridge createFridge() {
        return new HaierFridge();
    }
}

```

步骤7：通过各品牌工厂获得产品

```Java
public class MainApp {
    public static void main(String[] args) {
        HisenseFactory hisenseFactory = new HisenseFactory();
        hisenseFactory.createTelevision().play();
        hisenseFactory.createFridge().freeze();

        HaierFactory haierFactory = new HaierFactory();
        haierFactory.createTelevision().play();
        haierFactory.createFridge().freeze();
    }
}
```



## 生成器

*亦称：建造者模式、Builder*

**生成器**是一种创建型设计模式，使你能够分步骤创建复杂对象。该模式允许你使用相同的创建代码生成不同类型和形式的对象。

> 如需要生产一辆汽车🚗，汽车有各种各样的配件(名称、引擎、座位数、是否是敞篷等等)，如果我们采用构造函数来生成对象，需要利用**overload**写各种各样类型的构造函数，利用**生成器**模式可以实现分步骤装配。

```mermaid
classDiagram
direction BT
class Car {
  + getters()
}
class Builder {
<<Interface>>
  + reset() void
  + setters()
}

class CarBuilder {
  + getProduct() Car
  + reset() void
  + setters()
}
class Director {
  + constructSportsCar(Builder) void
  + constructCar(Builder) void
}

CarBuilder  ..>  Builder 
CarBuilder  ..>  Car : «create»
```

步骤1：创建一个汽车实体类

```java
public class Car {
    private final String name;
    private final int seats;
    private final String engine;
    private final boolean sunroof;

    public Car() {
        this.name = "Default Name";
        this.seats = 4;
        this.engine = "Default Engine";
        this.sunroof = false;
    }

    public Car(String name, int seats, String engine, boolean sunroof) {
        this.name = name;
        this.seats = seats;
        this.engine = engine;
        this.sunroof = sunroof;
    }
    // getters has been omitted.
}
```

步骤2：根据汽车的配置创建生成器接口

```java
public interface Builder {
	 
    void reset();
    Builder setName(String name);
    Builder setSeats(int quantity);
    Builder setEngine(String name);
    Builder setSunroof(boolean install);
}
```

步骤3：创建实现生成器接口的汽车实体类

```java
public class CarBuilder implements Builder {
    private String name;
    private int seats;
    private String engine;
    private boolean sunroof;

    public Car getProduct() {
        Car car = new Car(this.name, this.seats, this.engine, this.sunroof);
        this.reset();
        return car;
    }

    @Override
    public void reset() {
        Car car = new Car();
        this.name = car.getName();
        this.seats = car.getSeats();
        this.engine = car.getEngine();
        this.sunroof = car.isSunroof();
    }

    @Override
    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Builder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public Builder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public Builder setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
        return this;
    }

}
```

步骤4：创建一个主管类(可选)，用来指挥生成器工作

```java
public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setName("Sports Car")
                .setSeats(2)
                .setEngine("Engine A")
                .setSunroof(true);
    }

    public void constructCar(Builder builder) {
        builder.setName("Car")
                .setSeats(4)
                .setEngine("Common Engine")
                .setSunroof(false);
    }
}
```

步骤5：通过主管和生成器类实现制造和自定义汽车🚗

```java
public class MainApp {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();

        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getProduct();
        System.out.println(car);

        director.constructCar(carBuilder);
        car = carBuilder.getProduct();
        System.out.println(car);

        carBuilder.setName("Ruobing").setSunroof(true).setSeats(8);
        car = carBuilder.getProduct();
        System.out.println(car);
    }
}
```



## 原型

*亦称：克隆、Clone、Prototype*

**原型**是一种创建型设计模式，使你能够复制已有对象，而又无需使代码依赖它们所属的类。

> 如需要根据对象来克隆一个相同的对象，但是又不想了解其所属的类别，克隆是一把好手。

```mermaid
classDiagram
direction BT
class AbstractShape {
  + clone() AbstractShape
   - int y
   - int x
}
class Circle {
  + clone() Circle
  - int radius
}
class Rectangle {
  + clone() Rectangle
  - int width
  - int height
}
class ShapeGroup {
  - ArrayList~AbstractShape~ shapes
}

Circle  -->  AbstractShape 
Rectangle  -->  AbstractShape 
ShapeGroup "1" *--> AbstractShape 
ShapeGroup  ..>  Circle : «create»
ShapeGroup  ..>  Rectangle : «create»

```

步骤1：创建一个抽象父类，在其中定义一个抽象clone方法

```java
public abstract class AbstractShape {
    private int x;
    private int y;

    public AbstractShape() {
    }

    public AbstractShape(AbstractShape source) {
        this.x = source.x;
        this.y = source.y;
    }

    @Override
    public abstract AbstractShape clone();

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
```

步骤2：创建继承于抽象类的实体类，重点其可以根据当前对象创建一个新对象。

> 具体实现于有参构造函数(注意需要继承父类的属性)和clone方法

```java
public class Circle extends AbstractShape {
    private int radius;

    public Circle() {
    }

    public Circle(Circle source) {
        super(source);
        this.radius = source.radius;
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
```

步骤3：可以创建一个**原型组**在其中初始化一系列原型(可选)

```java
public class ShapeGroup {
    private final ArrayList<AbstractShape> shapes = new ArrayList<>();

    public ShapeGroup() {
        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(10);
        circle.setRadius(20);
        shapes.add(circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        shapes.add(rectangle);
    }

    public ArrayList<AbstractShape> getShapes() {
        return shapes;
    }
}
```

步骤4：使用原型进行克隆

```java
public class MainApp {

    public static void main(String[] args) {
        ShapeGroup shapeGroup = new ShapeGroup();
        ArrayList<AbstractShape> shapes = shapeGroup.getShapes();
        ArrayList<AbstractShape> shapesCopy = new ArrayList<>();

        for (AbstractShape shape : shapes) {
            shapesCopy.add(shape.clone());
        }
        shapes.forEach(System.out::println);
        shapesCopy.forEach(System.out::println);
    }
}
```



## 单例

*亦称：单件模式、Singleton*

**单例**是一种创建型设计模式，让你能够保证一个类只有一个实例，并提供一个访问该实例的全局节点。

> 如果你的系统中只想拥有某个类的一个实例，并且这个实例是全局可用的，那么单例是最适合的解决方案。

```mermaid
classDiagram
direction BT
class Singleton {
  - Singleton(String) 
  + getInstance(String) Singleton
  - String value
}
```

步骤1：创建一个单例类

> - 构造函数必须是private的，且instance必须是一个类变量
> - 同时提供一个名为getInstance的类方法对外暴露出实例
> - 注意thread-safe、懒汉/饿汉模式

```java
public final class Singleton {
    /**
     * The field must be declared volatile 
     * so that double check lock would work correctly.
     */
    private static volatile Singleton instance;
    private final String value;

    private Singleton(String value) {
        this.value = value;
    }

    /**
     * double-checked locking (DCL)
     * threads safe
     */
    public static Singleton getInstance(String value) {
        if (instance != null) {
            return instance;
        }
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }

    public String getValue() {
        return value;
    }
}
```

步骤2：使用单例

> 注意两个instance的地址是相同的，说明他们是同一个instance，也就是**单例**

```java
public class MainApp {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance("instance No.1");
        System.out.println(instance);
        System.out.println(instance.getValue());

        // The obtained instance is still instance No.1, 
        // and they have the same memory address.
        instance = Singleton.getInstance("instance No.2");
        System.out.println(instance);
        System.out.println(instance.getValue());
    }
}
```

# 结构型模式

*结构型模式介绍如何将对象和类组装成较大的结构，并同时保持结构的灵活和高效。*

## 适配器

*亦称：封装器模式、Wrapper、Adapter*

**适配器**是一种结构型设计模式，它能使接口不兼容的对象能够相互合作。

> 如果你去到美国，但是你的手机却需要220V的电压充电，那么不错的方法就是适配美国110V的电压。

```mermaid
classDiagram
direction BT
class ChinaStandard {
  + charge(Device) void
}
class Device {
  + getVoltage() int
}
class VoltageAdapter {
  + getVoltage() int
}
class AmericanStandard {
  + charge(Device) void
}
VoltageAdapter  -->  Device 
VoltageAdapter *--> Device 

```
步骤1：创建中国和美国的电压标准实体类

```java
public class ChinaStandard {
    private final static int VOLTAGE = 220;

    public static void charge(Device device) {
        if (VOLTAGE >= device.getVoltage()) {
            System.out.println("charging...");
        } else {
            System.out.println(VOLTAGE + "V and " + device.getVoltage() + "V are incompatible!");
        }
    }
}

public class AmericanStandard {
    private final static int VOLTAGE = 110;

    public static void charge(Device device) {
        if (VOLTAGE >= device.getVoltage()) {
            System.out.println("charging...");
        } else {
            System.out.println(VOLTAGE + "V and " + device.getVoltage() + "V are incompatible!");
        }
    }
}
```

步骤2：创建一台中国制造的设备(充电电压220V)

```java
public class Device {
    private final static int VOLTAGE = 220;

    public int getVoltage() {
        return VOLTAGE;
    }
}
```

步骤3：创建一个电压适配器用于适应美国标准的电压

> 需要继承于设备，通常使用一个设备的实例作为成员变量

```java
public class VoltageAdapter extends Device {
    private final Device device;

    public VoltageAdapter(Device device) {
        this.device = device;
    }

    @Override
    public int getVoltage() {
        return this.device.getVoltage() / 2;
    }
}
```

步骤4：中国设备成功在美国充上电

```java
public class MainApp {
    public static void main(String[] args) {
        Device device = new Device();
        ChinaStandard.charge(device);
        AmericanStandard.charge(device);

        VoltageAdapter adapter = new VoltageAdapter(device);
        ChinaStandard.charge(adapter);
        AmericanStandard.charge(adapter);
    }
}
```



## 桥接

*亦称：Bridge*

**桥接**是一种结构型设计模式，可将一个大类或一系列紧密相关的类拆分为抽象和实现两个独立的层次结构，从而能在开发时分别使用。

> 如果拥有设备和遥控两个对象，如果使用继承容易导致维度灾难，使用桥接可以将其抽象与实现分离。

```mermaid
classDiagram
direction BT
class AdvancedRemote {
  + mute() void
}
class BasicRemote {
  + power() void
  + volumeDown() void
  + volumeUp() void
}
class Device {
<<Interface>>
  + enable() void
  + disable() void
  - int volume
  - boolean enabled
}
class Remote {
<<Interface>>
  + power() void
  + volumeDown() void
  + volumeUp() void
}
class Television {
  + enable() void
  + disable() void
  - int volume
  - boolean enabled
}

AdvancedRemote  -->  BasicRemote 
BasicRemote "1" *--> " 1" Device 
BasicRemote  ..>  Remote 
Television  ..>  Device 
```

步骤1：创建一个设备接口，所有具体设备都必须实现它

```java
public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int volume);
}
```

步骤2：创建一台具体的设备

```java
public class Television implements Device {
    private boolean on = false;
    private int volume = 30;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }
}
```

步骤3：创建一个遥控器接口，所有具体遥控器都必须实现它

> 需要继承于设备，通常使用一个设备的实例作为成员变量

```java
public interface Remote {
    void power();

    void volumeDown();

    void volumeUp();
}
```

步骤4：创建一个的具体遥控器

> 通过类变量device来实现操控功能

```java
public class BasicRemote implements Remote {
    protected Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }
}
```
步骤5：此时再创建一个高级遥控器，可以实现自定义功能

```java
public class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }
}
```

步骤6：使用桥接，避免了继承的组合爆炸，同时成功将抽象与实现分离开

```java
public class MainApp {
    public static void main(String[] args) {
        Television tv=new Television();
        System.out.println(tv.getVolume());
        
        BasicRemote basicRemote=new BasicRemote(tv);
        basicRemote.volumeDown();
        System.out.println(tv.getVolume());
        
        AdvancedRemote advancedRemote=new AdvancedRemote(tv);
        advancedRemote.mute();
        System.out.println(tv.getVolume());
    }
}
```



## 组合

*亦称：对象树、Object Tree、Composite*

**组合**是一种结构型设计模式，你可以使用它将对象组合成树状结构，并且能像使用独立对象一样使用它们。

> 如果你想描述形如**菜单、子菜单、菜单项**这样的树状结构，使用组合是不错的主意。

```mermaid
classDiagram
direction BT
class Component {
<<Interface>>
  + remove(Component) void
  + getChildren() List~Component~
  + add(Component) void
  + operation() void
}
class Menu {
  + getChildren() List~Component~
  + operation() void
  + add(Component) void
  + remove(Component) void
}
class MenuItem {
  + getChildren() List~Component~
  + operation() void
  + add(Component) void
  + remove(Component) void
}
class SubMenu {
  + getChildren() List~Component~
  + operation() void
  + add(Component) void
  + remove(Component) void
}

Menu  ..>  Component 
Menu "1" *--> "*" Component 
MenuItem  ..>  Component
SubMenu "1" *--> "*" Component 
SubMenu  ..>  Component 
```

步骤1：创建一个组件接口

> 把一组相似的对象抽象为一个对象

```java
public interface Component {
    void add(Component component);

    void remove(Component component);

    List<Component> getChildren();

    void operation();
}
```

步骤2：每个层级的对象以不同的方式实现组件接口

> 可以考虑使用继承来复用代码，但需要注意成员变量冗余的问题

```java
public class Menu implements Component {
    private final String name;
    private final List<Component> children = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        component.remove(component);
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public void operation() {
        System.out.println(name);
        for (Component child : children) {
            child.operation();
        }
    }
}

public class SubMenu implements Component{
    private final String name;
    private final List<Component> children = new ArrayList<>();

    public SubMenu(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        component.remove(component);
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public void operation() {
        System.out.println("\t"+name);
        for (Component child : children) {
            child.operation();
        }
    }
}

public class MenuItem implements Component {
    private final String name;

    public MenuItem(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void remove(Component component) {
    }

    @Override
    public List<Component> getChildren() {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("\t\t" + name);
    }
}
```
步骤3：使用组合来打印出每一个菜单项目

```java
public class MainApp {
    public static void main(String[] args) {
        SubMenu subMenu = new SubMenu("SubMenu A");
        subMenu.add(new MenuItem("MenuItem A"));
        subMenu.add(new MenuItem("MenuItem B"));
        subMenu.add(new MenuItem("MenuItem C"));

        Menu menu = new Menu("Menu A");
        menu.add(subMenu);
        menu.operation();
    }
}
```



## 装饰

*亦称：装饰者模式、装饰器模式、Wrapper、Decorator*

**装饰**是一种结构型设计模式，允许你通过将对象放入包含行为的特殊封装对象中来为原对象绑定新的行为。

若需要复用使用 final 关键字修饰的类，唯一方法是使用装饰模式。

> 如果你有一杯咖啡，你想要往里面加糖加奶，但是又不想拓展咖啡的子类，那么装饰器可以做到这一点。

```mermaid
classDiagram
direction BT
class Americano
class IcedCoffee
class Coffer {
  + calculatePrice() float
}
class Decorator {
  + calculatePrice() float
}
class Drink {
  - String name
  - float price
  + calculatePrice() float
  + getters/setters()
}
class Milk
class Sugar

Americano  -->  Coffer
IcedCoffee  -->  Coffer 
Coffer  -->  Drink 
Decorator  -->  Drink 
Decorator "1" *--> "1" Drink 
Milk  -->  Decorator 
Sugar  -->  Decorator 

```

步骤1：创建一个饮料抽象类

```java
public abstract class Drink {
    private String name;
    private float price;
    public abstract float calculatePrice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
```

步骤2：创建继承于饮料的咖啡类

```java
public class Coffer extends Drink{
    @Override
    public float calculatePrice() {
        return super.getPrice();
    }
}
```

步骤3：创建具体的咖啡类(美式咖啡和冰咖啡)

```java
public class Americano extends Coffer {
    public Americano() {
        setName("Americano");
        setPrice(10);
    }
}

public class IcedCoffee extends Coffer{
    public IcedCoffee() {
        setName("Iced Coffee");
        setPrice(8);
    }
}
```

步骤4：创建继承于饮料的装饰器类

> 通过成员变量drink来完成价格的计算和名称的拼接

```java
public class Decorator extends Drink {
    private final Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float calculatePrice() {
        return super.getPrice() + drink.calculatePrice();
    }
    
    @Override
    public String getName() {
        return super.getName() + "+" + drink.getName();
    }
}
```

步骤5：创建继承于装饰器的实体类(牛奶和糖)

```java
public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        setName("Milk");
        setPrice(2);
    }
}

public class Sugar extends Decorator {
    public Sugar(Drink drink) {
        super(drink);
        setName("Sugar");
        setPrice(1);
    }
}
```

步骤6：使用装饰器来为美式咖啡加糖加奶

```java
public class MainApp {
    public static void main(String[] args) {
        Drink americano = new Americano();
        System.out.println(americano.getName() + "=" + americano.calculatePrice());
        americano = new Milk(americano);
        System.out.println(americano.getName() + "=" + americano.calculatePrice());
        americano = new Sugar(americano);
        System.out.println(americano.getName() + "=" + americano.calculatePrice());
    }
}
```



## 外观

*亦称：Facade*

**外观**是一种结构型设计模式，能为程序库、框架或其他复杂类提供一个简单的接口。

> 如果你有一系列制作早餐的智能设备，如果你希望有一个人能为你操作这些设备，这个“人”就是**外观**。

```mermaid
classDiagram
direction BT
class BreadMaker {
  + run() void
}
class CofferMaker {
  + run() void
}
class Device {
<<Interface>>
  + run() void
}
class EggSteamer {
  + run() void
}
class SmartHomeFacade {
  + makeBreakfast() void
}

BreadMaker  ..>  Device 
CofferMaker  ..>  Device 
EggSteamer  ..>  Device 
SmartHomeFacade  ..>  BreadMaker : «create»
SmartHomeFacade  ..>  CofferMaker : «create»
SmartHomeFacade  ..>  EggSteamer : «create»
```

步骤1：创建设备接口，提供设备功能

```java
public interface Device {
    void run();
}
```

步骤2：创建具体的设备实现类(面包机、咖啡机、蒸蛋机)

```java
public class BreadMaker implements Device {
    @Override
    public void run() {
        System.out.println("The BreadMaker is making bread.");
    }
}

public class CofferMaker implements Device {
    @Override
    public void run() {
        System.out.println("The CofferMaker is making coffer.");
    }
}

public class EggSteamer implements Device {
    @Override
    public void run() {
        System.out.println("The EggSteamer is steaming eggs.");
    }
}
```

步骤3：创建外观类，用于托管具体设备实现类

```java
public class SmartHomeFacade {
    public static void makeBreakfast() {
        System.out.println("The SmartHomeFacade starts making breakfast.");
        BreadMaker breadMaker = new BreadMaker();
        breadMaker.run();
        EggSteamer eggSteamer = new EggSteamer();
        eggSteamer.run();
        CofferMaker cofferMaker = new CofferMaker();
        cofferMaker.run();
        System.out.println("The SmartHomeFacade finished making breakfast.");
    }
}
```

步骤4：通过外观类便捷的做好早餐

```java
public class MainApp {
    public static void main(String[] args) {
        SmartHomeFacade.makeBreakfast();
    }
}
```



## 享元

*亦称：缓存、Cache、Flyweight*

**享元**是一种结构型设计模式，它摒弃了在每个对象中保存所有数据的方式，通过共享多个对象所共有的相同状态，让你能在有限的内存容量中载入更多对象。

> 如果你经营一家自助餐厅，每当客人点菜时，如果厨房有存货就上菜，否则就去制作，这里的“存货”就是**享元**的概念。

```mermaid
classDiagram
direction BT
class Food
class Restaurant {
  + serve(String) Food
}

Restaurant "1" *--> "*" Food 
Restaurant  ..>  Food : «create»
```

步骤1：创建食物实体类，我们通过打印内存地址来判断是否是同一盘食物。

```java
public class Food {
    private final String name;

    public Food(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "@" + Integer.toHexString(hashCode());
    }
}
```

步骤2：使用餐厅类来完成制作和上菜的逻辑

```java
public class Restaurant {
    private static final HashMap<String, Food> foodMap = new HashMap<>();

    public static Food serve(String name) {
        if (foodMap.containsKey(name)) {
            System.out.print("Already owned ");
            return foodMap.get(name);
        }
        System.out.print("Making ");
        Food food = new Food(name);
        foodMap.put(name, food);
        return food;
    }
}
```

步骤3：顾客点菜，餐厅依照秩序工作

```java
public class MainApp {
    public static void main(String[] args) {
        String[] menu = new String[]{"Beef", "Chicken", "Milk", "Beef", "Chicken", "Milk"};
        Arrays.stream(menu).forEach(item -> {
            System.out.print("Ordering " + item + " --> ");
            System.out.println(Restaurant.serve(item));
        });
    }
}
```



## 代理

*亦称：Proxy*

**代理**是一种结构型设计模式，让你能够提供对象的替代品或其占位符。代理控制着对于原对象的访问，并允许在将请求提交给对象前后进行一些处理。

> 如果你不想每次出门购物都带大量现金，那么银行卡(代理)是一个不错的主意。

```mermaid
classDiagram
direction BT
class Payment {
<<Interface>>
  + pay(float) void
}

class Cash {
  + pay(float) void
  - float amount
}
class CreditCard {
  + pay(float) void
  - checkAccess() boolean
  - boolean access
}

Cash  ..>  Payment 
CreditCard  ..>  Payment 
CreditCard "1" *--> "1" Cash 
```

步骤1：创建一个支付接口，实体类和代理都需要实现它

```java
public interface Payment {
    void pay(float price);
}
```

步骤2：创建具体的零钱类，完成支付功能

```java
public class Cash implements Payment {
    private float amount = 100;

    @Override
    public void pay(float price) {
        amount = amount - price;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Cash has " + amount + ".";
    }
}
```

步骤3：创建一个代理类(信用卡)，使用它来维护零钱，同时还可以添加“是否可用”功能

```java
public class CreditCard implements Payment {
    private final Cash cash;
    private boolean access = true;

    public CreditCard(Cash cash) {
        this.cash = cash;
    }

    @Override
    public void pay(float price) {
        if (checkAccess()) {
            cash.pay(price);
        } else {
            System.out.println("This CreditCard is not available.");
        }
    }

    private boolean checkAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "CreditCard has " + cash.getAmount() + ".";
    }
}
```

步骤4：使用代理类来完成业务逻辑，同时还可以补充一些控制功能

    public class MainApp {
        public static void main(String[] args) {
            CreditCard creditCard = new CreditCard(new Cash());
            creditCard.pay(30);
            System.out.println(creditCard);
            creditCard.setAccess(false);
            // Error! This CreditCard is not available.
            creditCard.pay(10);
        }
    }


# 行为模式

*行为模式负责对象间的高效沟通和职责委派。*

## 责任链

*亦称：职责链模式、命令链、CoR、Chain of Command、Chain of Responsibility*

**责任链**是一种行为设计模式，允许你将请求沿着处理者链进行发送。收到请求后，每个处理者均可对请求进行处理，或将其传递给链上的下个处理者。

> 如果你想实现一个对于不同级别的信息，输出级别是不同的**Logger**，那么可以考虑使用责任链。

```mermaid
classDiagram
direction BT
class AbstractLogger {
  # write(String) void
  + log(int, String) void
  # AbstractLogger nextLogger
}
class ConsoleLogger {
  # write(String) void
}
class ErrorLogger {
  # write(String) void
}
class FileLogger {
  # write(String) void
}
class LoggerChain {
   AbstractLogger loggerChain
}

ConsoleLogger  -->  AbstractLogger 
ErrorLogger  -->  AbstractLogger 
FileLogger  -->  AbstractLogger 
LoggerChain  ..>  ConsoleLogger : «create»
LoggerChain  ..>  ErrorLogger : «create»
LoggerChain  ..>  FileLogger : «create»

```

步骤1：创建一个抽象日志类，提供基础的信息和功能

> 注意：成员变量nextLogger负责存储下一个logger的引用地址

```java
public abstract class AbstractLogger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;
    protected int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    abstract protected void write(String message);

    public void log(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.log(level, message);
        }
    }
}
```

步骤2：创建不同级别的具体日志类

```java
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}

public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
```

步骤3：通过成员变量nextLogger将各个logger连接起来

> 可以考虑实现一个addFilter方法来动态添加logger

```java
public class LoggerChain {
    public static AbstractLogger getLoggerChain() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
}
```

步骤4：使用责任链来根据不同级别的信息，输出不同的日志记录

```java
public class MainApp {
    public static void main(String[] args) {
        AbstractLogger logger = LoggerChain.getLoggerChain();

        logger.log(AbstractLogger.INFO, "This is an information.");

        logger.log(AbstractLogger.DEBUG, "This is a debug level information.");

        logger.log(AbstractLogger.ERROR, "This is an error information.");
    }
}
```



## 命令

*亦称：动作、事务、Action、Transaction、Command*

**命令**是一种行为设计模式，它可将请求转换为一个包含与请求相关的所有信息的独立对象。该转换让你能根据不同的请求将方法参数化、延迟请求执行或将其放入队列中，且能实现可撤销操作。

> 如果你去一家餐厅，你需要直接和厨师交流，你是否会感到奇怪？通过服务员来交流会不会好很多？

```mermaid
classDiagram
direction BT
class Chef {
  + cooking(String) void
}

class Command {
<<Interface>>
  + execute() void
}

class Order {
  - List~String~ order
  + addItem(String) Order
}

class CookCommand {
  + execute() void
}

class Waiter {
  + processOrders() void
  + addOrder(Order) void
}

CookCommand  ..>  Command 
CookCommand "1" *--> "1" Chef 
CookCommand "1" *--> "1" Order 

Waiter  ..>  CookCommand : «create»
Waiter "1" *--> "*" Order 
```

步骤1：创建一个厨师类用于烹饪事物(Receiver)

```java
public class Chef {
    public void cooking(String name) {
        System.out.println("Cooking: " + name);
    }
}
```

步骤2：创建一个订单类，记录顾客点菜

```java
public class Order {
    private final List<String> order = new ArrayList<>();

    public Order addItem(String item) {
        order.add(item);
        return this;
    }

    public List<String> getOrder() {
        return order;
    }
}
```

步骤3：创建一个命令接口

```java
public interface Command {
    void execute();
}
```

步骤4：创建一个烹饪命令类来完成厨师烹饪的任务

```java
public class CookCommand implements Command {
    private final Order order;
    private final Chef chef;

    public CookCommand(Order order) {
        this.order = order;
        this.chef = new Chef();
    }

    @Override
    public void execute() {
        for (String item : order.getOrder()) {
            chef.cooking(item);
        }
    }
}
```

步骤5：创建一个服务员类(Invoker)

> 通过Waiter可以实现Order与Chef的解耦
>
> 可以增加一个历史命令列表，来实现事务的回滚

```java
public class Waiter {
    private final List<CookCommand> cookCommands = new ArrayList<>();

    public void addOrder(Order order) {
        cookCommands.add(new CookCommand(order));
    }

    public void processOrders() {
        for (CookCommand cookCommand:cookCommands) {
            System.out.println("Order processing begins");
            cookCommand.execute();
            System.out.println("Order processing finished");
        }
    }
}
```

步骤6：通过服务员类来进行点菜，避免顾客与厨师的直接沟通

```java
public class MainApp {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Order order = new Order();
        order.addItem("Steak").addItem("Fruit salad").addItem("Corn soup");
        waiter.addOrder(order);

        order = new Order();
        order.addItem("Pork chops").addItem("Red wine").addItem("Ice cream");
        waiter.addOrder(order);
        waiter.processOrders();
    }
}
```



## 迭代器

*亦称：Iterator*

**迭代器**是一种行为设计模式，让你能在不暴露集合底层表现形式（列表、栈和树等）的情况下遍历集合中所有的元素。

> 如果你有一个集合类，但是却有各种各样的遍历算法(正序、反序、DFS、BFS…)，这些遍历算法最终会和你的集合耦合在一起，你将会很难添加一个新的遍历算法，而且集合类的**主要职责**难道不是高效存储元素吗？为了将**存储**和**遍历**进行**解耦**，我们可以使用**迭代器**来实现。

```mermaid
classDiagram
direction BT
class BaseIterator {
  + next() String
  + hasNext() boolean
}
class Container {
<<Interface>>
  + createIterator() Iterator~?~
  + createReverseIterator() Iterator~?~
}
class Iterator~T~ {
<<Interface>>
  + hasNext() boolean
  + next() T
}
class Repository {
  + createIterator() Iterator~String~
  + createReverseIterator() Iterator~String~
}
class ReverseIterator {
  + hasNext() boolean
  + next() String
}

BaseIterator  ..>  Iterator~T~ 
Repository  ..>  BaseIterator : «create»
Repository  ..>  Container 
Repository  ..>  ReverseIterator : «create»
ReverseIterator  ..>  Iterator~T~ 

```

步骤1：创建一个迭代器接口，声明遍历所需的方法

```java
public interface Iterator<T> {
    boolean hasNext();

    T next();
}
```

步骤2：创建一个容器接口，声明获取各种迭代器的方法

```java
public interface Container {
    Iterator<?> createIterator();

    Iterator<?> createReverseIterator();
}
```

步骤3：根据迭代器接口实现各式各样的迭代方法(正序、反序、DFS、BFS…)

```java
public class BaseIterator implements Iterator<String> {
    private final List<String> collection;
    private int index = 0;

    public BaseIterator(List<String> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return collection.size() > index;
    }

    @Override
    public String next() {
        String element = collection.get(index);
        index++;
        return element;
    }
}

public class ReverseIterator implements Iterator<String> {
    private final List<String> collection;
    private int index = 0;

    public ReverseIterator(List<String> collection) {
        Collections.reverse(collection);
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return collection.size() > index;
    }

    @Override
    public String next() {
        String element = collection.get(index);
        index++;
        return element;
    }
}
```

步骤4：在一个实现容器接口的实体类中，存储数据结构和返回各式各样的迭代器
```java
public class Repository implements Container {
    private final List<String> collection = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

    @Override
    public Iterator<String> createIterator() {
        return new BaseIterator(collection);
    }

    @Override
    public Iterator<String> createReverseIterator() {
        return new ReverseIterator(collection);
    }
}
```

步骤5：客户端可以根据获取到的各种迭代器来完成迭代任务

```java
public class MainApp {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Iterator<String> iterator = repository.createIterator();
        System.out.print("Normal  iteration: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.print("\nReverse iteration: ");
        iterator = repository.createReverseIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
```



## 中介者

*亦称：调解人、控制器、Intermediary、Controller、Mediator*

**中介者**是一种行为设计模式，能让你减少对象之间混乱无序的依赖关系。该模式会限制对象之间的直接交互，迫　使它们通过一个中介者对象进行合作。

> 如果你有一套房屋想要出租，较好的方法就是通过房屋中介进行出租，可以减少你和租户的沟通。

```mermaid
classDiagram
direction BT
class HouseMediator {
  + register(Person) void
  + notify(Person, String) void
}
class Landlord {
  # receive(String) void
  # send(String) void
}
class Mediator {
<<Interface>>
  + notify(Person, String) void
  + register(Person) void
}
class Person {
  # send(String) void
  # receive(String) void
   Mediator mediator
}
class Tenant {
  # receive(String) void
  # send(String) void
}

HouseMediator  ..>  Mediator 

Landlord  -->  Person 
Tenant  -->  Person
Person "1" *--> "1" Mediator 

```



步骤1：创建一个中介者接口，提供注册用户和通知用户的功能

```java
public interface Mediator {
    void register(Person person);

    void notify(Person person, String message);
}
```

步骤2：创建一个抽象类，规定用户有发送和接收消息的功能

```java
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(String name) {
        this.name = name;
    }

    protected abstract void send(String message);

    protected abstract void receive(String message);

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
```

步骤3：在具体的房屋中介类中实现注册和通知功能

```java
public class HouseMediator implements Mediator {
    private final List<Person> users = new ArrayList<>();

    @Override
    public void register(Person person) {
        person.setMediator(this);
        users.add(person);
    }

    @Override
    public void notify(Person person, String message) {
        for (Person user : users) {
            if (!user.equals(person)) {
                user.receive(message);
            }
        }
    }
}
```

步骤4：继承于抽象类，实现房东和租户类

```java
public class Landlord extends Person {

    public Landlord(String name) {
        super(name);
    }

    @Override
    protected void send(String message) {
        System.out.println(name + " send: " + message);
        mediator.notify(this, message);
    }

    @Override
    protected void receive(String message) {
        System.out.println(name + " receive: " + message);
    }
}

public class Tenant extends Person {

    public Tenant(String name) {
        super(name);
    }

    @Override
    protected void send(String message) {
        System.out.println(name + " send: " + message);
        mediator.notify(this, message);
    }

    @Override
    protected void receive(String message) {
        System.out.println(name + " receive: " + message);
    }
}
```

步骤5：通过中介者，已注册用户的消息可以被其他用户收到

```java
public class MainApp {
    public static void main(String[] args) {
        Mediator houseMediator = new HouseMediator();
        Landlord landlord = new Landlord("Landlord");
        Tenant tenantA = new Tenant("TenantA");
        Tenant tenantB = new Tenant("TenantB");
        houseMediator.register(landlord);
        houseMediator.register(tenantA);
        houseMediator.register(tenantB);
        landlord.send("I have two houses for rent.");
        tenantA.send("I'd like to rent one of them.");
    }
}
```



## 备忘录

*亦称：快照、Snapshot、Memento*

**备忘录**是一种行为设计模式，允许在不暴露对象实现细节的情况下保存和恢复对象之前的状态。

> 如果你有一个简易的数据库，你想为其添加一个存档功能以便发生故障时可以进行恢复，那么你可以使用备忘录来实现。

```mermaid
classDiagram
direction BT
class Database {
  - int state
  + save() Memento
}
class DatabaseMemento {
  + restore() void
}
class HistoryManager {
  + saveHistory(Memento) void
  + showHistory() void
  + undo() void
}
class Memento {
<<Interface>>
  + restore() void
}
class Originator {
<<Interface>>
  + save() Memento
}

Database  ..>  Originator
DatabaseMemento  ..>  Memento 
Database  ..>  DatabaseMemento : «create»
DatabaseMemento "1" *--> "1" Database 
HistoryManager "1" *--> "*" Memento 

```



步骤1：创建一个发起人接口，提供一个存储功能

```java
public interface Originator {
    Memento save();
}
```

步骤2：创建一个备忘录接口，提供一个恢复数据功能

```java
public interface Memento {
    void restore();
}
```

步骤3：使用数据库类Originator接口

> 核心方法save将自身引用和状态作为Memento进行保存

```java
public class Database implements Originator {
    private int state;

    @Override
    public Memento save() {
        return new DatabaseMemento(this, state);
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Database{" +
                "state=" + state +
                '}';
    }
}
```

步骤4：创建一个实现Memento的数据库备份类，用于恢复数据库状态

```java
public class DatabaseMemento implements Memento {
    private final Database database;
    private final LocalDateTime date;
    private final int state;

    public DatabaseMemento(Database database, int state) {
        this.database = database;
        this.state = state;
        this.date = LocalDateTime.now();
    }

    @Override
    public void restore() {
        database.setState(state);
    }

    @Override
    public String toString() {
        return "Memento{" +
                "database=" + database +
                ", date=" + date +
                ", history=" + state +
                '}';
    }
}

```

步骤5：创建一个主管类(Caretaker)，用于添加存档和进行回滚操作

```java
public class HistoryManager {
    private final ArrayList<Memento> history = new ArrayList<>();

    public void saveHistory(Memento memento) {
        history.add(memento);
    }

    public void showHistory() {
        for (Memento memento : history) {
            System.out.println(memento);
        }
    }

    public void undo() {
        if (history.size() <= 1) {
            System.out.println("HistoryManager doesn't has history.");
            return;
        }
        int index = history.size() - 1;
        history.get(index - 1).restore();
        history.remove(index);
    }
}
```

步骤6：使用历史管理器(caretaker)进行存档和回滚

```java
public class MainApp {
    public static void main(String[] args) {
        Database database = new Database();
        HistoryManager historyManager = new HistoryManager();

        database.setState(1);
        historyManager.saveHistory(database.save());
        database.setState(2);
        historyManager.saveHistory(database.save());
        database.setState(3);
        historyManager.saveHistory(database.save());

        historyManager.showHistory();
        historyManager.undo();
        historyManager.undo();
        System.out.println("Undo two operations");
        historyManager.showHistory();
    }
}

```



## 观察者

*亦称：事件订阅者、监听者、Event-Subscriber、Listener、Observe*

**观察者**是一种行为设计模式，允许你定义一种订阅机制，可在对象事件发生时通知多个“观察”该对象的其他对象。

> 如果你正在开发一款应用，每次发布都需要通知用户。但有的用户并不想收到通知，有的用户又希望及时收到通知，那么有一种解决方案称为观察者模式。

```mermaid
classDiagram
direction BT
class AppStore {
  + publish(String) void
}
class Customer {
  + update(Object) void
}
class Publisher {
<<Abstract>>
  + notifySubscribers(Object) void
  + subscribe(Subscriber) void
  + unsubscribe(Subscriber) void
}
class Subscriber {
<<Interface>>
  + update(Object) void
}

AppStore  -->  Publisher 
Customer  ..>  Subscriber 
Publisher "1" *--> "*" Subscriber 
```

步骤1：声明一个订阅者接口，提供一个收到通知的方法

```java
public interface Subscriber {
    void update(Object context);
}
```

步骤2：创建一个发布者抽象类，提供添加和删除订阅者、发布通知的功能

```java
public abstract class Publisher {
    private final ArrayList<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(Object context) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(context);
        }
    }
}
```

步骤3：使应用商店继承于发布者类，使用父类方法来完成通知功能

```java
public class AppStore extends Publisher {
    public void publish(String context){
        System.out.println(context);
        notifySubscribers(context);
    }
}
```

步骤4：创建一个实现Subscriber的顾客类，实现收到通知的方法

```java
public class Customer implements Subscriber {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Object context) {
        System.out.println(name + " receive: " + context);
    }
}
```

步骤5：使用订阅、退订和发布的功能

```java
public class MainApp {
    public static void main(String[] args) {
        AppStore appStore = new AppStore();
        Customer customerA = new Customer("Customer A");
        Customer customerB = new Customer("Customer B");
        Customer customerC = new Customer("Customer C");
        appStore.subscribe(customerA);
        appStore.subscribe(customerB);
        appStore.subscribe(customerC);
        appStore.publish("Appstore published the first message.");
        appStore.unsubscribe(customerC);
        appStore.publish("Appstore published the second message.");
    }
}
```



## 状态

*亦称：State*

状态是一种行为设计模式，让你能在一个对象的内部状态变化时改变其行为，使其看上去就像改变了自身所属的类一样。

> 如果你在设计一个电商平台，订单含有多个状态(初始、审核、支付、出库、完成…)，为了避免大量的if，状态模式是一把利刃。

```mermaid
classDiagram
direction BT
class State {
<<Abstract>>
  + payment() void
  + outbound() void
}

class Order {
  + outbound() void
  + payment() void
  - State state
}

class InitialStatus {
  + payment() void
  + outbound() void
}
class OutBoundState {
  + payment() void
  + outbound() void
}
class PaymentState {
  + payment() void
  + outbound() void
}

InitialStatus  -->  State
PaymentState  -->  State 
OutBoundState  -->  State 
State "1" <--> "1" Order 
```

步骤1：创建一个抽象状态类，在其中保存Order对象的引用

```java
public abstract class State {
    protected Order order;

    public State(Order order) {
        this.order = order;
    }

    public abstract void payment();

    public abstract void outbound();
}

```

步骤2：创建订单实体类，在其中保存State对象的引用

```java
public class Order {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void payment() {
        state.payment();
    }

    public void outbound() {
        state.outbound();
    }
}
```

步骤3：继承于抽象类，实现具体状态(初始、支付、出库)

```java
public class InitialStatus extends State {

    public InitialStatus(Order order) {
        super(order);
    }

    @Override
    public void payment() {
        order.setState(new PaymentState(order));
        System.out.println("Successful payment");
    }

    @Override
    public void outbound() {
        System.out.println("Failure outbound");
    }
}

public class PaymentState extends State {
    public PaymentState(Order order) {
        super(order);
    }

    @Override
    public void payment() {
        System.out.println("Has already payment");
    }

    @Override
    public void outbound() {
        order.setState(new OutBoundState(order));
        System.out.println("Successful outbound");
    }
}

public class OutBoundState extends State {
    public OutBoundState(Order order) {
        super(order);
    }

    @Override
    public void payment() {
        System.out.println("Has already payment");
    }

    @Override
    public void outbound() {
        System.out.println("Has already outbound");
    }
}
```

步骤4：通过状态模式可以很方便的管理状态，甚至不需要写一行if语句

```java
public class MainApp {
    public static void main(String[] args) {
        Order order = new Order();
        order.setState(new InitialStatus(order));
        // failure: Payment is required in advance
        order.outbound();
        // ok
        order.payment();
        // ok
        order.outbound();
        // failure: has already outbound
        order.outbound();
    }
}
```



## 策略

*亦称：Strategy*

**策略**是一种行为设计模式，它能让你定义一系列算法，并将每种算法分别放入独立的类中，以使算法的对象能够相互替换。

> 如果你开发了一款汽车导航APP，几个月后，APP大受欢迎，用户想要添加自行车路线规划的功能。又过了几周，用户又想添加公共汽车路线规划的功能…此时的导航系统越发臃肿，较好的改进方法是使用策略模式。

```mermaid
classDiagram
direction BT
class Bike {
  + execute() void
}
class Bus {
  + execute() void
}
class Car {
  + execute() void
}
class Context {
  + setStrategy(Strategy) void
  + executeStrategy() void
}
class Strategy {
<<Interface>>
  + execute() void
}

Bike  ..>  Strategy 
Bus  ..>  Strategy 
Car  ..>  Strategy 
Context "1" *--> "1" Strategy 

```

步骤1：创建一个策略接口供上下文调用执行策略的方法

```java
public interface Strategy {
    void execute();
}
```

步骤2：实现具体的路径规划策略(轿车、自行车、公共汽车…)

```java
public class Bike implements Strategy {
    @Override
    public void execute() {
        System.out.println("It takes 3 hours to get to the destination by bike.");
    }
}

public class Car implements Strategy {
    @Override
    public void execute() {
        System.out.println("It takes 40 minutes to get to the destination by car.");
    }
}

public class Bus implements Strategy {
    @Override
    public void execute() {
        System.out.println("It takes 2 hours to get to the destination by bus.");
    }
}
```

步骤3：创建一个上下文类，在其中设置策略和执行策略

```java
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}
```

步骤4：通过策略模式灵活的切换出行策略

```java
public class MainApp {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new Bike());
        context.executeStrategy();
        context.setStrategy(new Bus());
        context.executeStrategy();
        context.setStrategy(new Car());
        context.executeStrategy();
    }
}
```



## 模板方法

*亦称：Template Method*

**模板方法**是一种行为设计模式，它在超类中定义了一个算法的框架，允许子类在不修改结构的情况下重写算法的特定步骤。 

> 如果你在执行一项数据挖掘的任务，你需要抽取解析各种格式的文件，然后进行分析报告。在这项任务中，除了最开始抽取和解析数据的步骤依赖于具体的文件格式，其他步骤几乎是相同的。基于此，将这项任务抽象为模板方法似乎是一个不错的主意。

```mermaid
classDiagram
direction BT
class DataMiner {
<<Abstract>>
  + mine() void
  + extractData() void
  + parseData() void
  + analyzeData() void
  + sendReport() void
}
class JsonDataMiner {
  + extractData() void
  + parseData() void
}
class XmlDataMiner {
  + extractData() void
  + parseData() void
}

JsonDataMiner  -->  DataMiner 
XmlDataMiner  -->  DataMiner 
```

步骤1：创建一个抽象数据挖掘类，在其中声明模板方法以及一系列默认和抽象的方法

> - 将需要执行的步骤列在模板方法中，本例中为mine()
> - 声明模板方法的修饰符为final，避免子类重写该方法
> - 子类必须重写抽象方法
> - 子类可以重写默认方法(可选)

```java
public abstract class DataMiner {
    public final void mine() {
        extractData();
        parseData();
        analyzeData();
        sendReport();
    }

    public abstract void extractData();

    public abstract void parseData();

    public void analyzeData() {
        System.out.println("Analyzing...");
    }

    public void sendReport() {
        System.out.println("Reporting...");
    }
}
```

步骤2：创建JSON格式的数据挖掘器，实现JSON格式的数据抽取和解析

```java
public class JsonDataMiner extends DataMiner {
    @Override
    public void extractData() {
        System.out.println("Extracting JSON...");
    }

    @Override
    public void parseData() {
        System.out.println("Parsing JSON...");
    }
}
```

步骤3：创建XML格式的数据挖掘器，实现XML格式的数据抽取和解析

```java
public class XmlDataMiner extends DataMiner {
    @Override
    public void extractData() {
        System.out.println("Extracting XML...");
    }

    @Override
    public void parseData() {
        System.out.println("Parsing XML...");
    }
}
```

步骤4：使用模板方法完成数据挖掘的任务

```java
public class MainApp {
    public static void main(String[] args) {
        DataMiner jsonDataMiner = new JsonDataMiner();
        jsonDataMiner.mine();
        DataMiner xmlDataMiner = new XmlDataMiner();
        xmlDataMiner.mine();
    }
}
```



## 访问者

*亦称：visitor*

**访问者**是一种行为设计模式，它能将算法与其所作用的对象隔离开来。

> 世界上有很多建筑物每天都在发挥他们各自的作用。突然有一天，一群本地学生想要参观这些存在了数十年的建筑物。又过了一段时间，一群外地游客又想要参观这些建筑物。难道要在稳定工作的建筑物中增加供各种访问者访问的方法吗？这很容易造成建筑物无法正常使用，而使用访问者模式可以将**参观**这种日新月异的方法与稳定存在的建筑物隔离开。

```mermaid
classDiagram
direction BT
class Bank {
  + accept(Visitor) void
}
class Building {
<<Interface>>
  + accept(Visitor) void
}
class BuildingVisitor {
  + visit(Park) void
  + visit(Bank) void
  + visit(University) void
}
class Park {
  + accept(Visitor) void
}
class University {
  + accept(Visitor) void
}
class Visitor {
<<Interface>>
  + visit(Park) void
  + visit(University) void
  + visit(Bank) void
}

Bank  ..>  Building 
BuildingVisitor  ..>  Visitor 
Park  ..>  Building 
University  ..>  Building 
```

步骤1：在建筑物接口中增加一个accept方法用于接受访问者对象

```java
public interface Building {
    void accept(Visitor visitor);
}
```

步骤2：声明访问者接口，其可以访问各种各样的建筑物

```java
public interface Visitor {
    void visit(Park park);

    void visit(Bank bank);

    void visit(University university);
}
```

步骤3：在各个开放访问的建筑物中实现accept方法

```java
public class Park implements Building {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public class Bank implements Building {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public class University implements Building {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
```

步骤4：在建筑物访问者中实现访问各种建筑物的方法

> 不支持类型重载的编程语言需要将访问方法重命名
>
> 今后若有新的访问者类，仅仅需要重写一个实现Vistor接口的类

```java
public class BuildingVisitor implements Visitor {
    @Override
    public void visit(Park park) {
        System.out.println("The visitors visited the park.");
    }

    @Override
    public void visit(Bank bank) {
        System.out.println("The visitors visited the bank.");
    }

    @Override
    public void visit(University university) {
        System.out.println("The visitors visited the university.");
    }
}
```
步骤5：通过访问者来参观各个建筑物

```java
public class MainApp {
    public static void main(String[] args) {
        Building[] buildings = new Building[]{new Park(), new Bank(), new University()};
        BuildingVisitor buildingVisitor = new BuildingVisitor();
        for (Building building : buildings) {
            building.accept(buildingVisitor);
        }
    }
}
```



***Finally, I learned 22 design patterns in 21 days from September 24 to October 14, 2022.🎉***
