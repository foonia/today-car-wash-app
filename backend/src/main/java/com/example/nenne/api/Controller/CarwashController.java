package com.example.nenne.api.Controller;

import com.example.nenne.api.Entity.CarwashEntity;
import com.example.nenne.api.Mapper.CarwashMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CarwashController {
    //private Map<String, UserProfile> userMap;
    private CarwashMapper mapper;

    public CarwashController(CarwashMapper mapper) {
        this.mapper = mapper;
    }

	/*@PostConstruct
	public void init() {
		  userMap = new HashMap<String, UserProfile>(); userMap.put("1", new
		  UserProfile("1", "홍길동", "111-1111", "서울시 강남구 대치1동")); userMap.put("2", new
		  UserProfile("2", "홍길서", "222-2222", "서울시 강남구 대치2동")); userMap.put("3", new
		  UserProfile("3", "홍길남", "3333-3333", "서울시 강남구 대치3동"));
	}*/

    @GetMapping(value = "/api/test", produces = MediaType.APPLICATION_JSON_VALUE)	//localhost:8080/api/car-wash
    public CarwashEntity getCarwashProfile(@RequestParam("latitude") String latitude, @RequestParam("longtitude") String longtitude) {
        return mapper.getCarwash(latitude, longtitude);
        //return userMap.get(id);
    }

    @GetMapping("/api/car-wash")
    public List<CarwashEntity> getUserProfileList(@RequestParam("latitude") String latitude, @RequestParam("longtitude") String longtitude,
                                                  @RequestParam(value = "distance",required = false,defaultValue = "10") String distance) {
        return mapper.getCarwashList(latitude, longtitude, distance);
        //return new ArrayList<UserProfile>(userMap.values());
    }
/*
    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id,
                               @RequestParam("name") String name,
                               @RequestParam("phone") String phone,
                               @RequestParam("address") String address) {
        mapper.updateUserProfile(id, name, phone, address);
        //UserProfile userProfile = new UserProfile(id, name, phone, address);
        //userMap.put(id, userProfile);
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id,
                                @RequestParam("name") String name,
                                @RequestParam("phone") String phone,
                                @RequestParam("address") String address) {
        mapper.insertUserProfile(id, name, phone, address);
        //UserProfile userProfile = userMap.get(id);
        //userProfile.setName(name);
        //userProfile.setPhone(phone);
        //userProfile.setAddress(address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        mapper.deleteUserProfile(id);
        //userMap.remove(id);
    }*/
}