/*
|--java.lang.Object
	|--java.lang.Runtime�ࣺ
�����в�û���ṩ���캯����˵��������new������ô��ֱ���뵽�����еķ������Ǿ�̬�ġ�
���ָ����л��зǾ�̬������˵������϶����ṩ�˷�����ȡ�������
���Ҹ÷����Ǿ�̬�ģ����ҷ���ֵ�����Ǳ������͡�

������ص���Կ�������ʹ���˵������ģʽ��

		������
		Process exec(String command)��
					�ڵ����Ľ�����ִ��ָ�����ַ������
		static Runtime getRuntime();
					�����뵱ǰ Java Ӧ�ó�����ص�����ʱ����

java.lang.Process�����ࣺ
		abstract  void destroy();
					ɱ���ӽ��̡�		
*/
import java.util.*;
class  RuntimeDemo1
{
	public static void main(String[] args) 
	{
		Runtime r = Runtime.getRuntime();
		//��б��Ϊת���ַ�������Ӧ�ö��һ����б�ܡ�
		Process p = r.exec("c:\\winmine.exe");
		r.exec("D:\\BaiduYunGuanjia\\BaiduYunGuanjia.exe");

		r.exec("EditPlus.exe  SystemDemo.java");//�ü��±���java�ĵ���

		//ɱ���ӽ��̡�
		p.detroy();
	}
}
