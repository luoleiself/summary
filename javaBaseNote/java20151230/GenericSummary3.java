һ. ���͸���������Ϊʲô��Ҫ���ͣ���

���ȣ����ǿ���������μ�̵Ĵ���:

���ƴ���
 1 public class GenericTest {
 2 
 3     public static void main(String[] args) {
 4         List list = new ArrayList();
 5         list.add("qqyumidi");
 6         list.add("corn");
 7         list.add(100);
 8 
 9         for (int i = 0; i < list.size(); i++) {
10             String name = (String) list.get(i); // 1
11             System.out.println("name:" + name);
12         }
13     }
14 }
���ƴ���
������һ��List���͵ļ��ϣ��������м����������ַ������͵�ֵ��������һ��Integer���͵�ֵ��������ȫ����ģ���Ϊ��ʱlistĬ�ϵ�����ΪObject���͡���֮���ѭ���У�����������֮ǰ��list��Ҳ������Integer���͵�ֵ����������ԭ�򣬺����׳���������//1�еĴ�����Ϊ����׶�������������ʱ����֡�java.lang.ClassCastException���쳣����ˣ����´�������������в��׷��֡�

 �����ϵı�������У����Ƿ�����Ҫ�����������⣺

1.�����ǽ�һ��������뼯���У����ϲ����ס�˶�������ͣ����ٴδӼ�����ȡ���˶���ʱ���Ķ���ı������ͱ����Object���ͣ���������ʱ������ȻΪ�䱾�����͡�

2.��ˣ�//1��ȡ������Ԫ��ʱ��Ҫ��Ϊ��ǿ������ת���������Ŀ�����ͣ��Һ����׳��֡�java.lang.ClassCastException���쳣��

��ô��û��ʲô�취����ʹ�����ܹ���ס������Ԫ�ظ����ͣ����ܹ��ﵽֻҪ����ʱ���������⣬����ʱ�Ͳ�����֡�java.lang.ClassCastException���쳣�أ��𰸾���ʹ�÷��͡�

 

��.ʲô�Ƿ��ͣ�

���ͣ��������������͡���һ�ᵽ����������Ϥ�ľ��Ƕ��巽��ʱ���βΣ�Ȼ����ô˷���ʱ����ʵ�Ρ���ô������������ô����أ�����˼�壬���ǽ�������ԭ���ľ�������Ͳ������������ڷ����еı�����������ʱ����Ҳ����ɲ�����ʽ�����Գ�֮Ϊ�����βΣ���Ȼ����ʹ��/����ʱ�����������ͣ�����ʵ�Σ���

 ���ź����е㸴�ӣ��������ǿ��������Ǹ����Ӳ��÷��͵�д����

���ƴ���
 1 public class GenericTest {
 2 
 3     public static void main(String[] args) {
 4         /*
 5         List list = new ArrayList();
 6         list.add("qqyumidi");
 7         list.add("corn");
 8         list.add(100);
 9         */
10 
11         List<String> list = new ArrayList<String>();
12         list.add("qqyumidi");
13         list.add("corn");
14         //list.add(100);   // 1  ��ʾ�������
15 
16         for (int i = 0; i < list.size(); i++) {
17             String name = list.get(i); // 2
18             System.out.println("name:" + name);
19         }
20     }
21 }
���ƴ���
���÷���д������//1�������һ��Integer���͵Ķ���ʱ����ֱ������ͨ��List<String>��ֱ���޶���list������ֻ�ܺ���String���͵�Ԫ�أ��Ӷ���//2���������ǿ������ת������Ϊ��ʱ�������ܹ���סԪ�ص�������Ϣ���������Ѿ��ܹ�ȷ������String�����ˡ�

�������ķ��Ͷ��壬����֪����List<String>�У�String������ʵ�Σ�Ҳ����˵����Ӧ��List�ӿ��п϶����������βΡ���get()�����ķ��ؽ��Ҳֱ���Ǵ��β����ͣ�Ҳ���Ƕ�Ӧ�Ĵ��������ʵ�Σ��������������List�ӿڵĵľ��嶨�壺

���ƴ���
 1 public interface List<E> extends Collection<E> {
 2 
 3     int size();
 4 
 5     boolean isEmpty();
 6 
 7     boolean contains(Object o);
 8 
 9     Iterator<E> iterator();
10 
11     Object[] toArray();
12 
13     <T> T[] toArray(T[] a);
14 
15     boolean add(E e);
16 
17     boolean remove(Object o);
18 
19     boolean containsAll(Collection<?> c);
20 
21     boolean addAll(Collection<? extends E> c);
22 
23     boolean addAll(int index, Collection<? extends E> c);
24 
25     boolean removeAll(Collection<?> c);
26 
27     boolean retainAll(Collection<?> c);
28 
29     void clear();
30 
31     boolean equals(Object o);
32 
33     int hashCode();
34 
35     E get(int index);
36 
37     E set(int index, E element);
38 
39     void add(int index, E element);
40 
41     E remove(int index);
42 
43     int indexOf(Object o);
44 
45     int lastIndexOf(Object o);
46 
47     ListIterator<E> listIterator();
48 
49     ListIterator<E> listIterator(int index);
50 
51     List<E> subList(int fromIndex, int toIndex);
52 }
���ƴ���
���ǿ��Կ�������List�ӿ��в��÷��ͻ�����֮��<E>�е�E��ʾ�����βΣ����Խ��վ��������ʵ�Σ����Ҵ˽ӿڶ����У����ǳ���E�ĵط�����ʾ��ͬ�Ľ������ⲿ������ʵ�Ρ�

��Ȼ�ģ�ArrayList��ΪList�ӿڵ�ʵ���࣬�䶨����ʽ�ǣ�

���ƴ���
 1 public class ArrayList<E> extends AbstractList<E> 
 2         implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
 3     
 4     public boolean add(E e) {
 5         ensureCapacityInternal(size + 1);  // Increments modCount!!
 6         elementData[size++] = e;
 7         return true;
 8     }
 9     
10     public E get(int index) {
11         rangeCheck(index);
12         checkForComodification();
13         return ArrayList.this.elementData(offset + index);
14     }
15     
16     //...ʡ�Ե���������Ķ������
17 
18 }
���ƴ���
�ɴˣ����Ǵ�Դ����Ƕ�������Ϊʲô//1������Integer���Ͷ�����������//2��get()��������ֱ�Ӿ���String�����ˡ�

 

��.�Զ��巺�ͽӿڡ�������ͷ��ͷ���

������������У�����Ѿ������˷��͵ľ����������̡�Ҳ֪���˽ӿڡ���ͷ���Ҳ������ʹ�÷���ȥ���壬�Լ���Ӧ��ʹ�á��ǵģ��ھ���ʹ��ʱ�����Է�Ϊ���ͽӿڡ�������ͷ��ͷ�����

�Զ��巺�ͽӿڡ�������ͷ��ͷ���������JavaԴ���е�List��ArrayList���ơ����£����ǿ�һ����򵥵ķ�����ͷ������壺

���ƴ���
 1 public class GenericTest {
 2 
 3     public static void main(String[] args) {
 4 
 5         Box<String> name = new Box<String>("corn");
 6         System.out.println("name:" + name.getData());
 7     }
 8 
 9 }
10 
11 class Box<T> {
12 
13     private T data;
14 
15     public Box() {
16 
17     }
18 
19     public Box(T data) {
20         this.data = data;
21     }
22 
23     public T getData() {
24         return data;
25     }
26 
27 } 
���ƴ���
�ڷ��ͽӿڡ�������ͷ��ͷ����Ķ�������У����ǳ�������T��E��K��V����ʽ�Ĳ��������ڱ�ʾ�����βΣ����ڽ��������ⲿʹ��ʱ���������ʵ�Ρ���ô���ڲ�ͬ���������ʵ�Σ����ɵ���Ӧ����ʵ���������ǲ���һ�����أ�

���ƴ���
 1 public class GenericTest {
 2 
 3     public static void main(String[] args) {
 4 
 5         Box<String> name = new Box<String>("corn");
 6         Box<Integer> age = new Box<Integer>(712);
 7 
 8         System.out.println("name class:" + name.getClass());      // com.qqyumidi.Box
 9         System.out.println("age class:" + age.getClass());        // com.qqyumidi.Box
10         System.out.println(name.getClass() == age.getClass());    // true
11 
12     }
13 
14 }
���ƴ���
�ɴˣ����Ƿ��֣���ʹ�÷�����ʱ����Ȼ�����˲�ͬ�ķ���ʵ�Σ�����û���������������ɲ�ͬ�����ͣ����벻ͬ����ʵ�εķ��������ڴ���ֻ��һ����������ԭ��������������ͣ���ʵ����ΪBox������Ȼ�����߼������ǿ������ɶ����ͬ�ķ������͡�

����ԭ������Java�еķ�����һ���������Ŀ�ģ�������ֻ�������ڴ������׶Σ��ڱ�������У�������ȷ���鷺�ͽ���󣬻Ὣ���͵������Ϣ������Ҳ����˵���ɹ���������class�ļ����ǲ������κη�����Ϣ�ġ�������Ϣ������뵽����ʱ�׶Ρ�

�Դ��ܽ��һ�仰�������������߼��Ͽ��Կ����Ƕ����ͬ�����ͣ�ʵ���϶�����ͬ�Ļ������͡�

 

��.����ͨ���

��������Ľ��ۣ�����֪����Box<Number>��Box<Integer>ʵ���϶���Box���ͣ�������Ҫ����̽��һ�����⣬��ô���߼��ϣ�������Box<Number>��Box<Integer>�Ƿ���Կ��ɾ��и��ӹ�ϵ�ķ��������أ�

Ϊ��Ū��������⣬���Ǽ������������������:

���ƴ���
 1 public class GenericTest {
 2 
 3     public static void main(String[] args) {
 4 
 5         Box<Number> name = new Box<Number>(99);
 6         Box<Integer> age = new Box<Integer>(712);
 7 
 8         getData(name);
 9         
10         //The method getData(Box<Number>) in the type GenericTest is 
11         //not applicable for the arguments (Box<Integer>)
12         getData(age);   // 1
13 
14     }
15     
16     public static void getData(Box<Number> data){
17         System.out.println("data :" + data.getData());
18     }
19 
20 }
���ƴ���
���Ƿ��֣��ڴ���//1�������˴�����ʾ��Ϣ��The method getData(Box<Number>) in the t ype GenericTest is not applicable for the arguments (Box<Integer>)����Ȼ��ͨ����ʾ��Ϣ������֪��Box<Number>���߼��ϲ�����ΪBox<Integer>�ĸ��ࡣ��ô��ԭ������أ�

���ƴ���
 1 public class GenericTest {
 2 
 3     public static void main(String[] args) {
 4 
 5         Box<Integer> a = new Box<Integer>(712);
 6         Box<Number> b = a;  // 1
 7         Box<Float> f = new Box<Float>(3.14f);
 8         b.setData(f);        // 2
 9 
10     }
11 
12     public static void getData(Box<Number> data) {
13         System.out.println("data :" + data.getData());
14     }
15 
16 }
17 
18 class Box<T> {
19 
20     private T data;
21 
22     public Box() {
23 
24     }
25 
26     public Box(T data) {
27         setData(data);
28     }
29 
30     public T getData() {
31         return data;
32     }
33 
34     public void setData(T data) {
35         this.data = data;
36     }
37 
38 }
���ƴ���
��������У���Ȼ//1��//2���϶�����ִ�����ʾ�ġ��ڴ����ǿ���ʹ�÷�֤��������˵����

����Box<Number>���߼��Ͽ�����ΪBox<Integer>�ĸ��࣬��ô//1��//2���������д�����ʾ�ˣ���ô����ͳ����ˣ�ͨ��getData()����ȡ������ʱ������ʲô�����أ�Integer? Float? ����Number���������ڱ�̹����е�˳�򲻿ɿ��ԣ������ڱ�Ҫ��ʱ�����Ҫ���������жϣ��ҽ���ǿ������ת������Ȼ�����뷺�͵�����ì�ܣ���ˣ����߼���Box<Number>������ΪBox<Integer>�ĸ��ࡣ

�ã������ǻع�ͷ��������������ͨ������еĵ�һ�����ӣ�����֪�������Ĵ�����ʾ������ԭ���ˡ���ô��ν���أ��ܲ����ٶ���һ���µĺ����ɡ����Java�еĶ�̬������Ȼ��Υ���ģ���ˣ�������Ҫһ�����߼��Ͽ���������ʾͬʱ��Box<Integer>��Box<Number>�ĸ����һ���������ͣ��ɴˣ�����ͨ���Ӧ�˶�����

����ͨ���һ����ʹ�� ? ������������ʵ�Ρ�ע���ˣ��˴�������ʵ�Σ������������βΣ���Box<?>���߼�����Box<Integer>��Box<Number>...������Box<��������ʵ��>�ĸ��ࡣ�ɴˣ�������Ȼ���Զ��巺�ͷ���������ɴ�������

���ƴ���
 1 public class GenericTest {
 2 
 3     public static void main(String[] args) {
 4 
 5         Box<String> name = new Box<String>("corn");
 6         Box<Integer> age = new Box<Integer>(712);
 7         Box<Number> number = new Box<Number>(314);
 8 
 9         getData(name);
10         getData(age);
11         getData(number);
12     }
13 
14     public static void getData(Box<?> data) {
15         System.out.println("data :" + data.getData());
16     }
17 
18 }
���ƴ���
��ʱ�����ǻ�������������ͨ������޺�����ͨ������ޡ�����������ô�����أ�

������������У������Ҫ����һ������������getData()�ķ�������������ʵ�����н�һ�������ƣ�ֻ����Number�༰�����ࡣ��ʱ����Ҫ�õ�����ͨ������ޡ�

���ƴ���
 1 public class GenericTest {
 2 
 3     public static void main(String[] args) {
 4 
 5         Box<String> name = new Box<String>("corn");
 6         Box<Integer> age = new Box<Integer>(712);
 7         Box<Number> number = new Box<Number>(314);
 8 
 9         getData(name);
10         getData(age);
11         getData(number);
12         
13         //getUpperNumberData(name); // 1
14         getUpperNumberData(age);    // 2
15         getUpperNumberData(number); // 3
16     }
17 
18     public static void getData(Box<?> data) {
19         System.out.println("data :" + data.getData());
20     }
21     
22     public static void getUpperNumberData(Box<? extends Number> data){
23         System.out.println("data :" + data.getData());
24     }
25 
26 }
���ƴ���
��ʱ����Ȼ���ڴ���//1�����ý����ִ�����ʾ����//2 //3������������

����ͨ�������ͨ������Box<? extends Number>��ʽ���壬���Ӧ�ģ�����ͨ�������ΪBox<? super Number>��ʽ���京��������ͨ������������෴���ڴ˲�����������ˡ�

 

��.����ƪ

�����е�������Ҫ��Ϊ�˲��������е�һЩ˼����򵥾ٳ��ģ�����һ������ʵ�ʵĿ����ԡ����⣬һ�ᵽ���ͣ����Ŵ���õ����ľ����ڼ����У���ʵ����ʵ�ʵı�̹����У��Լ�����ʹ�÷���ȥ�򻯿��������ܺܺõı�֤�������������һ�Ҫע���һ���ǣ�Java��û����ν�ķ�������һ˵��

���ڷ��ͣ�����Ҫ�Ļ�����Ҫ����䱳���˼���Ŀ�ġ�
