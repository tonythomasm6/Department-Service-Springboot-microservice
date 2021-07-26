package com.microservice.user.service.service;

import com.microservice.user.service.VO.Department;
import com.microservice.user.service.VO.ResponseTemplateVO;
import com.microservice.user.service.entity.User;
import com.microservice.user.service.repository.UserRepostory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepostory userRepostory;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("in saveUser in User service");
        return userRepostory.save(user);
    }
/*ResponseTemplateVO is wrapper to encapsulate both use and its department together*/
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment in User service");
            ResponseTemplateVO vo = new ResponseTemplateVO();
            User user = userRepostory.findByUserId(userId);
            //To get department for the user, we need to make API call to the department API using rest template
//        Department department = restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(), Department.class);
        /*After registering the client with eureka, the url can be changed to application name*/
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }

    public List<User> getAllUsers(){
        return userRepostory.findAll();
    }
}
