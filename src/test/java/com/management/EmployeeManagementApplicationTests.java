package com.management;

import com.management.jpa.entity.UserEntity;
import com.management.jpa.entity.UserPostEntity;
import com.management.jpa.repo.UserRepository;
import com.management.model.UserModel;
import com.management.mongodocument.user.PostLikeModel;
import com.management.mongorepo.PostLikeModelRepo;
import com.management.mybatis.SocialMybatisMapper;
import com.management.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.*;

@SpringBootTest
class EmployeeManagementApplicationTests {

	@Autowired
	UserService userService;


	@Autowired
	SocialMybatisMapper socialMybatisMapper;

	@Autowired
	PostLikeModelRepo postLikeModelRepo;

	@Autowired
	UserRepository userRepository;

	@Autowired
	Configuration config;

	@Test
	void contextLoads() throws IOException, TemplateException {

//		List<UserModel> jsonObjectList = socialMybatisMapper.findUsers();
//		//System.out.println(jsonObjectList);
//		//userService.addUser(null);
//		long count = postLikeModelRepo.getCountPostLikeByPostId(1l);
//		System.out.println(count);
//		System.out.println("tetintg");
//
//		UserEntity user1 = new UserEntity();
//		user1.setId(2l);
//		user1.setFirstName("fdf");
//		user1.setLastName("dsd");
//		user1.setEmail("dsdshjhjjh");
//
//
//		UserEntity user2 = new UserEntity();
//		user2.setId(2l);
//		user2.setFirstName("fdf");
//		user2.setLastName("dsd");
//		user2.setEmail("dsdsfdfdf_after");
//
//		List<UserEntity> userEntities = new ArrayList<>();
//		userEntities.add(user1);
//		userEntities.add(user2);
//
//		  userRepository.saveAll(userEntities);

		Map<String,Object> root = new HashMap<>();

		Map<String, Map<String,Object>> integerMapMap = new LinkedHashMap<>();
        Map<String,Object> map = new HashMap<>();
		map.put("plantName","plant");
		map.put("totalCount",12);

		Map<String,Object> map2 = new LinkedHashMap<>();
		map2.put("plantName","plant two");
		map2.put("totalCount",12);

		integerMapMap.put("one",map);
		integerMapMap.put("two",map2);

		root.put("root",integerMapMap);


		Template reportTemplate = config.getTemplate("report.html");
		//System.out.println(reportTemplate);
		String htmlResponse = FreeMarkerTemplateUtils.processTemplateIntoString(reportTemplate, root);
		System.out.println(htmlResponse);
	}


}
