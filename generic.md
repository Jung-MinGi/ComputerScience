<h2>Generic</h2>
어떤 클래스나 메서드가 다양한 타입에 대해서 기능을 제공하고 싶을때 제네릭을 사용하여 클래스를 만들게 되면 코드의 재사용성을 높여준다.

▶ 클래스 or 인터페이스에 제네릭 사용법
```
public class GenericPrac <E>{...}
/**
 * 이런식으로 만들어두면 사용자쪽에서 다양한 타입으로 사용할 수 있다
 * EX) GenericPrac a = new GenericPrac<>();
 * EX) GenericPrac a = new GenericPrac<>();
 * EX) GenericPrac a = new GenericPrac<>();
 */
```
▶ 메서드에 제네릭 사용법 

클래스에 붙은 제네릭으로 동일하게 사용되는 메서드도 있지만 

특정 메서드만 다른 제네릭을 사용하게 할 수 있다.
```
public class GenericPrac <E>{
    E num;
    <T> T genericMethod1(T param){
        return param;
    }
}

/**
 * 위 클래스를 보면 클래스의 제네릭은 E이고
 * 메서드를 보면 클래스와 다른 제네릭을 사용중이다
 */
```
메서드에 독립적으로 제네릭을 사용하는 경우는 정적메서드 선언시 필요하다.

static 메서드에 클래스에 붙은 제네릭을 쓰게 두면 어떻게 될까??

static메서드는 프르그램이 메모리에 올라온 순간 같이 올라오는데, 이때 E타입을 알 수가 없기 때문에 static메서드는 독립적인 제네릭을 사용해야 한다.



※ 제네릭 제한적(?)으로 사용하는 법

특정 범위로 제한시키는 제네릭

extends, super, ? 이 세개를 사용해서 제네릭의 범위를 제한 시킬 수 있다

•  // T와 T의 자손 타입만 가능 (K는 들어오는 타입으로 지정 됨)

•  // T와 T의 부모(조상) 타입만 가능 (K는 들어오는 타입으로 지정 됨)

•  // T와 T의 자손 타입만 가능

•  // T와 T의 부모(조상) 타입만 가능

•  // 모든 타입 가능

*******아래 수정필요********

public static <T extends Comparable<T>>void sort(List<T> list)

만약 파라미터로 List list가 들어오면 

저 제네릭 부분이 <Ecar extends Comparable<Ecar>>이런 형태가 될꺼임

근데 Ecar는 comparable 를 구현하고 있지 comparable 를 구현하고 있지 않기 때문에 sort메소드 호출이 불가하다.
