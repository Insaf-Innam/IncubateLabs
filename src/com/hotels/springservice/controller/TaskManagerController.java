package com.hotels.springservice.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hotels.dao.TaskManagerService;
import com.hotels.springservice.domain.Hotel;

@RestController
public class TaskManagerController {

	TaskManagerService taskmanagerservice = new TaskManagerService();

	@RequestMapping(value = "/hotels", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Hotel> getAllTasks() {
		List<Hotel> hotels = taskmanagerservice.getAllHotels();
		return hotels;

	}

	@RequestMapping(value = "/hotels", method = RequestMethod.POST, headers = "Accept=application/json")
	public Hotel addHotel(@RequestBody Hotel hotel) throws ParseException {
		return taskmanagerservice.addHotel(hotel);

	}

	@RequestMapping(value = "/hotels/search", method = RequestMethod.GET)
	public ModelAndView seachHotels() {
		return new ModelAndView("searchHotels");
	}

	@RequestMapping(value = "/hotels/search/{value}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Hotel> seachHotelsByCity(@PathVariable("value") String value) {
		System.out.println("value of the input data " + value);
		List<Hotel> hotels = taskmanagerservice.searchHotelsByCity(value);
		return hotels;
	}

}
