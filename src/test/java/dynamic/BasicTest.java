package dynamic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dynamic.model.UserInfo;
import com.dynamic.service.UserInfoService;
import com.dynamic.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class BasicTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Test
	public void insertTest(){
		UserInfo info = new UserInfo();
		info.setUsername("wudi4");
		info.setPassword("wudi4");
		int count = userService.insertUser(info);
		System.out.println(count);
	}
	
	/*@Test
	public void testFind(){
		for(UserInfo info :userService.findAll()){
			System.out.println(info);
		}
	}*/

	@Test
	public void testInfo(){
		for(UserInfo info :userInfoService.findAll()){
			System.out.println(info);
		}
	}
	
}
