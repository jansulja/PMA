package com.tim11.pma.ftn.pmaprojekat.data.restapi;

import com.tim11.pma.ftn.pmaprojekat.converter.MyGsonHttpMessageConverter;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.dto.SearchViewModel;

import org.androidannotations.rest.spring.annotations.Body;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.FormHttpMessageConverter;

import java.util.List;

/**
 * Created by ALOHA-PC on 28-Apr-17.
 */
@Rest(rootUrl = APIConstants.ROOT_URL, converters = {MyGsonHttpMessageConverter.class,
        FormHttpMessageConverter.class})
public interface HotelAPI {

    @Get(value = APIConstants.HOTEL_PATH)
    List<Hotel> getHotels();

    @Post(value = APIConstants.HOTEL_PATH + "/ids")
    List<Hotel> getHotelsByIds(@Body Integer[] ids);

    @Post(value = APIConstants.HOTEL_PATH)
    Hotel createHotel(@Body Hotel hotel);

    @Post(value = APIConstants.HOTEL_PATH+"/search")
    List<Hotel> search(@Body SearchViewModel searchViewModel);

    @Get(APIConstants.HOTEL_PATH+"/{id}")
    Hotel getHotel(@Path int id);

}
