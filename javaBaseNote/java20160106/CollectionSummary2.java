1.Java���Ͽ����ʲô��˵��һЩ���Ͽ�ܵ��ŵ㣿
ÿ�ֱ�������ж��м��ϣ������Java�汾�������ּ����ࣺVector��Stack��HashTable��Array�����ż��ϵĹ㷺ʹ�ã�Java1.2������������м��Ͻӿڡ�ʵ�ֺ��㷨�ļ��Ͽ�ܡ��ڱ�֤�̰߳�ȫ�������ʹ�÷��ͺͲ��������࣬Java�Ѿ������˺ܾá�����������Java�������У������ӿ��Լ����ǵ�ʵ�֡����Ͽ�ܵĲ����ŵ����£�
��1��ʹ�ú��ļ����ཱུ�Ϳ����ɱ�������ʵ�������Լ��ļ����ࡣ
��2������ʹ�þ����ϸ���Եļ��Ͽ���࣬����������õ���ߡ�
��3��ͨ��ʹ��JDK�����ļ����࣬���Խ��ʹ���ά���ɱ���
��4�������ԺͿɲ����ԡ�
2.���Ͽ���еķ�����ʲô�ŵ㣿
Java1.5�����˷��ͣ����еļ��Ͻӿں�ʵ�ֶ�������ʹ������������������Ϊ�����ṩһ���������ɵĶ������ͣ���ˣ����������������͵��κ�Ԫ�أ������ڱ���ʱ�����������������ʱ����ClassCastException����Ϊ�㽫���ڱ���ʱ�õ�������Ϣ������Ҳʹ�ô������࣬���ǲ���Ҫʹ����ʽת����instanceOf����������Ҳ������ʱ�����ô�����Ϊ����������ͼ����ֽ���ָ�
3.Java���Ͽ�ܵĻ����ӿ�����Щ��
CollectionΪ���ϲ㼶�ĸ��ӿڡ�һ�����ϴ���һ�������Щ����Ϊ����Ԫ�ء�Javaƽ̨���ṩ����ӿ��κ�ֱ�ӵ�ʵ�֡�
Set��һ�����ܰ����ظ�Ԫ�صļ��ϡ�����ӿڶ���ѧ���ϳ�����н�ģ�������������ϣ�����һ���ơ�
List��һ�����򼯺ϣ����԰����ظ�Ԫ�ء������ͨ�����������������κ�Ԫ�ء�List���񳤶ȶ�̬�任�����顣
Map��һ����keyӳ�䵽value�Ķ���һ��Map���ܰ����ظ���key��ÿ��key���ֻ��ӳ��һ��value��
һЩ�����Ľӿ���Queue��Dequeue��SortedSet��SortedMap��ListIterator��
4.Ϊ��Collection����Cloneable��Serializable�ӿڼ̳У�
Collection�ӿ�ָ��һ����󣬶���Ϊ����Ԫ�ء����ά����ЩԪ����Collection�ľ���ʵ�־��������磬һЩ��List��Collectionʵ�������ظ���Ԫ�أ�����������Set�Ͳ������ܶ�Collectionʵ����һ�����е�clone������Ȼ���������ŵ����ϵ�����ʵ����Ҳ��û������ġ�������ΪCollection��һ��������֡���Ҫ����ʵ�֡�
�������ʵ�ִ򽻵���ʱ�򣬿�¡�����л�������ͺ���ŷ������á����ԣ�����ʵ��Ӧ�þ�����ζ������п�¡�����л��������Ƿ���Ա���¡�����л���
�����е�ʵ������Ȩ��¡�����л������յ��¸��ٵ�����Ժ͸�������ơ��ض���ʵ��Ӧ�þ������Ƿ���Ա���¡�����л���
5.Ϊ��Map�ӿڲ��̳�Collection�ӿڣ�
����Map�ӿں�����ʵ��Ҳ�Ǽ��Ͽ�ܵ�һ���֣���Map���Ǽ��ϣ�����Ҳ����Map����ˣ�Map�̳�Collection�������壬��֮��Ȼ��
���Map�̳�Collection�ӿڣ���ôԪ��ȥ�Ķ���Map����key-value�ԣ����ṩ��ȡkey��value�б��ϵķ��������������ʺϡ�һ����󡱹淶��
6.Iterator��ʲô��
Iterator�ӿ��ṩ�����κ�Collection�Ľӿڡ����ǿ��Դ�һ��Collection��ʹ�õ�������������ȡ������ʵ����������ȡ����Java���Ͽ���е�Enumeration������������������ڵ����������Ƴ�Ԫ�ء�
7.Enumeration��Iterator�ӿڵ�����
Enumeration���ٶ���Iterator��������Ҳʹ�ø��ٵ��ڴ档Enumeration�Ƿǳ������ģ�Ҳ�����˻�������Ҫ�����ǣ���Enumeration��ȣ�Iterator���Ӱ�ȫ����Ϊ��һ���������ڱ�������ʱ��������ֹ�����߳�ȥ�޸ļ��ϡ�
������ȡ����Java���Ͽ���е�Enumeration����������������ߴӼ������Ƴ�Ԫ�أ���Enumeration����������Ϊ��ʹ���Ĺ��ܸ����������������������Ѿ��������ơ�
8.Ϊ��û����Iterator.add()�����ķ������򼯺������Ԫ�أ�
���岻������֪���ǣ�Iterator��Э�鲻��ȷ�������Ĵ���Ȼ��Ҫע�⣬ListIteratorû���ṩһ��add��������Ҫȷ��������˳��
9.Ϊ�ε�����û��һ����������ֱ�ӻ�ȡ��һ��Ԫ�أ�������Ҫ�ƶ��αꣿ
�������ڵ�ǰIterator�Ķ���ʵ�֣��������õú��٣���������ӵ��ӿ��У�ÿ���̳ж�Ҫȥʵ��������û�����塣
10.Iterater��ListIterator֮����ʲô����
��1�����ǿ���ʹ��Iterator������Set��List���ϣ���ListIteratorֻ�ܱ���List��
��2��Iteratorֻ������ǰ��������LIstIterator����˫�������
��3��ListIterator��Iterator�ӿڼ̳У�Ȼ�������һЩ����Ĺ��ܣ��������һ��Ԫ�ء��滻һ��Ԫ�ء���ȡǰ������Ԫ�ص�����λ�á�
11.����һ��List����Щ��ͬ�ķ�ʽ��
?
1
2
3
4
5
6
7
8
9
10
11
List<String> strList = new ArrayList<>();
//ʹ��for-eachѭ��
for(String obj : strList){
 System.out.println(obj);
}
//using iterator
Iterator<String> it = strList.iterator();
while(it.hasNext()){
 String obj = it.next();
 System.out.println(obj);
}
ʹ�õ����������̰߳�ȫ����Ϊ������ȷ�����ڵ�ǰ�����ļ���Ԫ�ر����ĵ�ʱ�������׳�ConcurrentModificationException��
12.ͨ��������fail-fast���ԣ���������ʲô��
ÿ�����ǳ��Ի�ȡ��һ��Ԫ�ص�ʱ��Iterator fail-fast���Լ�鵱ǰ���Ͻṹ����κθĶ�����������κθĶ������׳�ConcurrentModificationException��Collection������Iterator��ʵ�ֶ��ǰ�fail-fast����Ƶģ�ConcurrentHashMap��CopyOnWriteArrayList���ಢ����������⣩��
13.fail-fast��fail-safe��ʲô����
Iterator��fail-fast�����뵱ǰ�ļ��Ϲ�ͬ�����ã�����������ܵ��������κθĶ���Ӱ�졣Java.util���е����м����඼�����Ϊfail-fast�ģ���java.util.concurrent�еļ����඼Ϊfail-safe�ġ�Fail-fast�������׳�ConcurrentModificationException����fail-safe�������Ӳ��׳�ConcurrentModificationException��
14.�ڵ���һ�����ϵ�ʱ����α���ConcurrentModificationException��
�ڱ���һ�����ϵ�ʱ�����ǿ���ʹ�ò���������������ConcurrentModificationException������ʹ��CopyOnWriteArrayList��������ArrayList��
15.Ϊ��Iterator�ӿ�û�о����ʵ�֣�
Iterator�ӿڶ����˱������ϵķ�����������ʵ�����Ǽ���ʵ��������Ρ�ÿ���ܹ��������ڱ�����Iterator�ļ����඼�����Լ���Iteratorʵ���ڲ��ࡣ
�����������ȥѡ���������fail-fast����fail-safe�ġ����磬ArrayList��������fail-fast�ģ���CopyOnWriteArrayList��������fail-safe�ġ�
16.UnsupportedOperationException��ʲô��
UnsupportedOperationException�����ڱ���������֧�ֵ��쳣����JDK�����ѱ��������ã��ڼ��Ͽ��java.util.Collections.UnmodifiableCollection����������add��remove�������׳�����쳣��
17.��Java�У�HashMap����ι����ģ�
HashMap��Map.Entry��̬�ڲ���ʵ���д洢key-value�ԡ�HashMapʹ�ù�ϣ�㷨����put��get�����У���ʹ��hashCode()��equals()������������ͨ������key-value�Ե���put������ʱ��HashMapʹ��Key hashCode()�͹�ϣ�㷨���ҳ��洢key-value�Ե�������Entry�洢��LinkedList�У������������entry����ʹ��equals()��������鴫�ݵ�key�Ƿ��Ѿ����ڣ�������ڣ����Ḳ��value����������ڣ����ᴴ��һ���µ�entryȻ�󱣴档������ͨ������key����get����ʱ�����ٴ�ʹ��hashCode()���ҵ������е�������Ȼ��ʹ��equals()�����ҳ���ȷ��Entry��Ȼ�󷵻�����ֵ�������ͼƬ��������ϸ���ݡ�
��������HashMap�Ƚ���Ҫ������������������ϵ���ͷ�ֵ������HashMapĬ�ϵĳ�ʼ������32������ϵ����0.75����ֵ��Ϊ����ϵ���������������ۺ�ʱ���ǳ������һ��entry�����map�Ĵ�С�ȷ�ֵ���ʱ��HashMap���map�����ݽ������¹�ϣ����ʹ�ø������������������2���ݣ����������֪������Ҫ�洢������key-value�ԣ����绺������ݿ�������ȡ�����ݣ�ʹ����ȷ�������͸���ϵ����HashMap���г�ʼ���Ǹ������������
18.hashCode()��equals()�����к���Ҫ�ԣ�
HashMapʹ��Key�����hashCode()��equals()����ȥ����key-value�Ե����������������Ŵ�HashMap�л�ȡֵ��ʱ����Щ����Ҳ�ᱻ�õ��������Щ����û�б���ȷ��ʵ�֣�����������£�������ͬKeyҲ��������ͬ��hashCode()��equals()�����HashMap������Ϊ��������ͬ�ģ�Ȼ�󸲸����ǣ����ǰ����Ǵ洢����ͬ�ĵط���ͬ���ģ����в�����洢�ظ����ݵļ����඼ʹ��hashCode()��equals()ȥ�����ظ���������ȷʵ�����Ƿǳ���Ҫ��equals()��hashCode()��ʵ��Ӧ����ѭ���¹���
��1�����o1.equals(o2)����ôo1.hashCode() == o2.hashCode()����Ϊtrue�ġ�
��2�����o1.hashCode() == o2.hashCode()��������ζ��o1.equals(o2)��Ϊtrue��
19.�����ܷ�ʹ���κ�����ΪMap��key��
���ǿ���ʹ���κ�����ΪMap��key��Ȼ����ʹ������֮ǰ����Ҫ�������¼��㣺
��1���������д��equals()��������ҲӦ����дhashCode()������
��2���������ʵ����Ҫ��ѭ��equals()��hashCode()��صĹ�����ο�֮ǰ�ᵽ����Щ����
��3�����һ����û��ʹ��equals()���㲻Ӧ����hashCode()��ʹ������
��4���û��Զ���key������ʵ����ʹ֮Ϊ���ɱ�ģ�������hashCode()ֵ���Ա�����������ӵ�и��õ����ܡ����ɱ����Ҳ����ȷ��hashCode()��equals()��δ������ı䣬�����ͻ�����ɱ���ص������ˡ�
���磬����һ����MyKey����HashMap��ʹ������
?
1
2
3
4
5
6
7
//���ݸ�MyKey��name����������equals()��hashCode()��
MyKey key = new MyKey('Pankaj'); //assume hashCode=1234
myHashMap.put(key, 'Value');
// ���µĴ����ı�key��hashCode()��equals()ֵ
key.setName('Amit'); //assume new hashCode=7890
//����᷵��null����ΪHashMap�᳢�Բ��Ҵ洢ͬ��������key����key�ѱ��ı��ˣ�ƥ��ʧ�ܣ�����null
myHashMap.get(new MyKey('Pankaj'));
�Ǿ���Ϊ��String��Integer����ΪHashMap��key����ʹ�á�
20.Map�ӿ��ṩ����Щ��ͬ�ļ�����ͼ��
Map�ӿ��ṩ����������ͼ��
��1��Set keyset()������map�а���������key��һ��Set��ͼ����������map֧�ֵģ�map�ı仯���ڼ����з�ӳ��������֮��Ȼ����һ�����������ڱ���һ������ʱ����map���޸��ˣ���������������Ƴ��������⣩���������Ľ�����Ϊδ���塣����֧��ͨ��Iterator��Remove��Set.remove��removeAll��retainAll��clear��������Ԫ���Ƴ�����map���Ƴ���Ӧ��ӳ�䡣����֧��add��addAll������
��2��Collection values()������һ��map�а���������value��һ��Collection��ͼ�����collection��map֧�ֵģ�map�ı仯����collection�з�ӳ��������֮��Ȼ����һ�����������ڱ���һ��collectionʱ����map���޸��ˣ���������������Ƴ��������⣩���������Ľ�����Ϊδ���塣����֧��ͨ��Iterator��Remove��Set.remove��removeAll��retainAll��clear��������Ԫ���Ƴ�����map���Ƴ���Ӧ��ӳ�䡣����֧��add��addAll������
��3��Set<Map.Entry<K,V>> entrySet()������һ��map�Ӱ���������ӳ���һ��������ͼ�����������map֧�ֵģ�map�ı仯����collection�з�ӳ��������֮��Ȼ����һ�����������ڱ���һ������ʱ����map���޸��ˣ���������������Ƴ��������Լ��Ե��������ص�entry����setValue�⣩���������Ľ�����Ϊδ���塣����֧��ͨ��Iterator��Remove��Set.remove��removeAll��retainAll��clear��������Ԫ���Ƴ�����map���Ƴ���Ӧ��ӳ�䡣����֧��add��addAll������
