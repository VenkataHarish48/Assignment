package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.CarRepository;


@Controller
public class CarController {

	@Autowired
	private CarDetails cus;

	@Autowired
	private CarRepository repo;

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String initForm(Model model) {

		model.addAttribute("command", cus);
		return "addCars";
	}

	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("command") CarDetails cus, Model model) {

		int rowAdded = repo.addCars(cus);
		model.addAttribute("rowAdded", rowAdded);
		System.out.println(cus);
		return "addCars";
	}

	@ModelAttribute("brands")
	public String[] brand() {

		return new String[] { "Maruti", "Benz", "Audi", "Tata", "Bugati", "Lamburgini" };
		
	}

	@ModelAttribute("brand")
	public String[] status() {

		return new String[] { "Sold", "Unsold" };
	}

	@RequestMapping(value = "/cars/all", method = RequestMethod.GET)
	public String findAllCustomers(Model model) {

		List<CarDetails> list = repo.getAllCars();
		model.addAttribute("list", list);
		return "showCars";
		
	}
	@RequestMapping(value = "/cars/status", method = RequestMethod.GET)
	public String getCarStatus(Model model) {

	
		List<CarDetails> list =repo. getCarStatus();
		model.addAttribute("list",list);
		
		return "showStatus";

	}


	@RequestMapping(value = "/cars/brand", method = RequestMethod.POST)
	public String findCarsByBrand(@ModelAttribute("command") @RequestParam("brand")String brand,Model model) {

	List<CarDetails> list=repo.getsCarsByBrand(brand);	
	
    model.addAttribute("list", list);
		return "carBrand";

	}

   	@RequestMapping(value = "/cars/showBrand", method = RequestMethod.GET)
   	public String initFormBrand(Model model) {

   	
   		
   		model.addAttribute("command",cus);
   		
   		return "selectBrand";

   	}
}