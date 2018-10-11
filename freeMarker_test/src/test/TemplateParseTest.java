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
 * 模板解析测试用例
 * @author 李益勇
 *
 */
public class TemplateParseTest {
	/**
	 * 测试Excel文件的生成
	 */
	@Test
	public void excelTest(){
		List<User> userList = new ArrayList<User>(); 
		for(int i = 1 ; i < 10;i ++){
			User user = new User();
			user.setUserName("狗娃" + i);
			user.setRealName("许文强");
			user.setPassWord("123456");
			user.setAddr("上海虎头帮总舵");
			user.setAge("28");
			userList.add(user);
		}
		//测试Excel文件生成
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

		/*		//测试模板字符串解析
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

		/*		//测试生成流
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
	 * 测试Word文件的生成
	 */
	@Test
	public void wordTest(){
		Map<String,Object> data = new HashMap<String,Object>();
		List<OptionQuestions> options = new ArrayList<OptionQuestions>();
		for(int i = 1;i <= 10; i++){
			OptionQuestions option = new OptionQuestions();
			option.setContent(i + "." + "“给力”这个词出自以下哪本名著？");
			option.setOption1("A." + "《不给力啊，老湿》");
			option.setOption2("B." + "《这货不是宿敌》");
			option.setOption3("C." + "《西游记：旅程的终点》");
			option.setOption4("D." + "《屌丝也有春天》");
			options.add(option);
		}
		List<String> judges = new ArrayList<String>();
		for(int i = 1;i <= 5; i++){
			judges.add(i + "." + "正方形、长方形、平行四边形和梯形都是特殊四边形");
		}
		data.put("title", "全国人大代表考试题");
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
	 * 测试XML文件的生成
	 */
	@Test
	public void xmlTest(){
		List<User> userList = new ArrayList<User>(); 
		for(int i = 1 ; i <= 3;i ++){
			User user = new User();
			user.setUserName("狗娃" + i);
			user.setRealName("许文强");
			user.setPassWord("123456");
			user.setAddr("上海虎头帮总舵");
			user.setAge("28");
			userList.add(user);
		}
		//测试Excel文件生成
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
	 * 测试HTML文件的生成
	 */
	@Test
	public void htmlTest(){
		List<User> userList = new ArrayList<User>(); 
		for(int i = 1 ; i <= 3;i ++){
			User user = new User();
			user.setUserName("狗娃" + i);
			user.setRealName("许文强");
			user.setPassWord("123456");
			user.setAddr("上海虎头帮总舵");
			user.setAge("28");
			userList.add(user);
		}
		//测试Excel文件生成
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
