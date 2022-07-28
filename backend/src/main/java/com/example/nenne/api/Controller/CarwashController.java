package com.example.nenne.api.Controller;

import com.example.nenne.api.ApiException.ApiException;
import com.example.nenne.api.ApiException.ExceptionEnum;
import com.example.nenne.api.Entity.CarwashEntity;
import com.example.nenne.api.Entity.CarwashResponse;
import com.example.nenne.api.Mapper.CarwashMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Validated
@RestController
public class CarwashController{
    //private Map<String, UserProfile> userMap;
    private CarwashMapper mapper;

    @Value("${key.value}")
    private String key_value;

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
    public CarwashEntity getCarwashProfile(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude) {
        return mapper.getCarwash(latitude, longitude);
        //return userMap.get(id);
    }

    /*@GetMapping(value = "/api/car-wash",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarwashEntity> getUserProfileList(@RequestParam(value = "latitude") String latitude, @RequestParam("longitude") String longitude,
                                                  @RequestParam(value = "distance",required = false,defaultValue = "10") String distance,
                                                  @RequestHeader(value = "x-api-key") String key) {

        try{
            assertThat(key_value).isEqualTo(key);
        }catch (AssertionError e){
            throw new ApiException(ExceptionEnum.INTERNAL_SERVER_ERROR);
        }

        return mapper.getCarwashList(latitude, longitude, distance);

    }*/

    @GetMapping(value = "/api/car-wash",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarwashResponse> getUserProfileList(@RequestParam(value = "latitude") String latitude, @RequestParam("longitude") String longitude,
                                                                                       @RequestParam(value = "distance",required = false,defaultValue = "10") String distance,
                                                                                       @RequestHeader(value = "x-api-key") String key) {

        CarwashResponse carwashResponse = new CarwashResponse();
        List<CarwashEntity> carwashList = mapper.getCarwashList(latitude, longitude, distance);
        try{
            assertThat(key_value).isEqualTo(key);
        }catch (AssertionError e){
            throw new ApiException(ExceptionEnum.INTERNAL_SERVER_ERROR);
        }

        carwashResponse.setStatus(HttpStatus.OK);
        carwashResponse.setCode("200");
        carwashResponse.setItems(carwashList);

        return new ResponseEntity<>(carwashResponse,HttpStatus.OK);
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