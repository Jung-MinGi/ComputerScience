<h3>Comparable와 Comparator</h3>
✓ Comparable api문서

https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html#method.summary

int compareTo(T o) 이것만 구현하면 됨

✓ Comparator api 문서

https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html#method.summary

모두 static or default메서드로 구현해야 할 메서드는 int compare(T o1,T o2)하나이다



[[오버플로우는 고려하지 않았습니다]]

• Comparable 써보기

CryptoCurrency라는 클래스가 있다고 치면 rank를 기준으로 비교해야 할때가 있고, price를 기준으로 비교하고 싶을때가 있다.
```
public class CryptoCurrency implements Comparable{
    int rank;
    int price;

    public CryptoCurrency(int rank, int price) {
        this.rank = rank;
        this.price = price;
    }

    @Override
    public int compareTo(CryptoCurrency o) {
      return this.price - o.price;//무엇을 기준으로 비교할지 정의해주면 됨
    }
}
```
Comparable의 compareTo(T o)는 매개변수가 하나이면서  compareTo는 객체 자기자신과 파라미터로 넘어온 객체가 서로 비교를 합니다

• Comparator 써보기
```
public class CryptoCurrency implements Comparator {
    int rank;
    int price;
    public CryptoCurrency(int rank, int price) {
        this.rank = rank;
        this.price = price;
    }
    @Override
    public int compare(CryptoCurrency o1, CryptoCurrency o2) {
        return o1.rank-o2.rank;
    }
}
```
Comparator의 compare(T o1,T o2)는 파라미터로 넘어온 두 객체가 서로 비교하는 것이다.

Comparator 문제점 ? 
```
public class Main {

    public static void main(String[] args){
        CryptoCurrency btc = new CryptoCurrency(1,50000);
        CryptoCurrency eth = new CryptoCurrency(2,2800);
        CryptoCurrency tmp = new CryptoCurrency(0,0);
        
        tmp.compare(btc,eth);
    }
}
```
예를 들어 btc와eth를 비교하기위해 단지 객체하나를 더 생성해 이 둘을 비교해야 합니다.

매우 비효율적입이다

※ 익명객체를 활용한 comparator사용법
```
public class Main {

    public static void main(String[] args){
        CryptoCurrency btc = new CryptoCurrency(1, 50000);
        CryptoCurrency eth = new CryptoCurrency(2, 2800);
        Comparator comparator = new Comparator<>() {
            @Override
            public int compare(CryptoCurrency o1, CryptoCurrency o2) {
                return o1.rank-o2.rank;
            }
        };
        comparator.compare(btc,eth);
    }
}
```
이렇게 사용하면 CryptoCurrency에서 Comparator을 구현할 필요가 없어진다.

또 비교를 위해 객체를 추가로 생성하지 않아 메모리낭비도 없어진다.





참고

https://st-lab.tistory.com/243
