package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import util.TemplateParseUtil;
import entity.OptionQuestions;
import entity.User;
import freemarker.template.TemplateException;

/**
 * ģ�������������
 * @author ������
 *
 */
public class TemplateParseTest {
	/**
	 * ����Excel�ļ�������
	 */
	@Test
	public void excelTest(){
		List<User> userList = new ArrayList<User>(); 
		for(int i = 1 ; i < 10;i ++){
			User user = new User();
			user.setUserName("����" + i);
			user.setRealName("����ǿ");
			user.setPassWord("123456");
			user.setAddr("�Ϻ���ͷ���ܶ�");
			user.setAge("28");
			userList.add(user);
		}
		//����Excel�ļ�����
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("userList", userList);
		try {
			TemplateParseUtil.parse("template", "excel.ftl", "tempFile/excelTest.xls", data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*		//����ģ���ַ�������
		String templateStr = "<#list userList as bean>${bean.userName}|+|${bean.passWord}|+|${bean.realName}|"
									+ "+|${bean.age}|+|${bean.addr}\n</#list>";
		try {
			String result = TemplateParseUtil.parse(templateStr, data);
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		/*		//����������
		try {
			byte[] byteArr = TemplateParseUtil.parse("template", "excel.ftl", data);
			System.out.println(new String(byteArr));
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	/**
	 * ����Word�ļ�������
	 */
	@Test
	public void wordTest(){
		Map<String,Object> data = new HashMap<String,Object>();
		List<OptionQuestions> options = new ArrayList<OptionQuestions>();
		for(int i = 1;i <= 10; i++){
			OptionQuestions option = new OptionQuestions();
			option.setContent(i + "." + "������������ʳ��������ı�������");
			option.setOption1("A." + "��������������ʪ��");
			option.setOption2("B." + "����������޵С�");
			option.setOption3("C." + "�����μǣ��ó̵��յ㡷");
			option.setOption4("D." + "����˿Ҳ�д��졷");
			options.add(option);
		}
		List<String> judges = new ArrayList<String>();
		for(int i = 1;i <= 5; i++){
			judges.add(i + "." + "�����Ρ������Ρ�ƽ���ı��κ����ζ��������ı���");
		}
		data.put("title", "ȫ���˴��������");
		data.put("options", options);
		data.put("judges",judges);
		try {
			TemplateParseUtil.parse("template", "word.ftl", "tempFile/wordTest.doc", data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����XML�ļ�������
	 */
	@Test
	public void xmlTest(){
		List<User> userList = new ArrayList<User>(); 
		for(int i = 1 ; i <= 3;i ++){
			User user = new User();
			user.setUserName("����" + i);
			user.setRealName("����ǿ");
			user.setPassWord("123456");
			user.setAddr("�Ϻ���ͷ���ܶ�");
			user.setAge("28");
			userList.add(user);
		}
		//����Excel�ļ�����
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("userList", userList);
		try {
			TemplateParseUtil.parse("template", "xml.ftl", "tempFile/xmlTest.xml", data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����HTML�ļ�������
	 */
	@Test
	public void htmlTest(){
		List<User> userList = new ArrayList<User>(); 
		for(int i = 1 ; i <= 3;i ++){
			User user = new User();
			user.setUserName("����" + i);
			user.setRealName("����ǿ");
			user.setPassWord("123456");
			user.setAddr("�Ϻ���ͷ���ܶ�");
			user.setAge("28");
			userList.add(user);
		}
		//����Excel�ļ�����
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("userList", userList);
		try {
			TemplateParseUtil.parse("template", "html.ftl", "tempFile/htmlTest.html", data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
