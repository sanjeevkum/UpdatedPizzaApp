package com.springmvc.pizzaapplication.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.pizzaapplication.dao.PizzaDAO;
import com.springmvc.pizzaapplication.model.Pizza;

@Controller
public class PizzaController {
	
	@Autowired
	private PizzaDAO pizzaDAO;
	
	@RequestMapping(value = "/")
	public ModelAndView getAllPizza(ModelAndView model) {
		List<Pizza> listPizza = pizzaDAO.list();
		model.addObject("listPizza",listPizza);
		model.setViewName("index");
		return model;
	}
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView addNewPizza(ModelAndView model) {
		Pizza newPizza = new Pizza();
		model.addObject("Pizza",newPizza);
		model.setViewName("pizza_form");
		return model;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView savePizza(@ModelAttribute Pizza pizza) {
		if(pizza.getId()==null) {
			pizzaDAO.save(pizza);
		}else {
			pizzaDAO.update(pizza);
		}
		return new ModelAndView("redirect:/");
	}
	
	//????????????
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public ModelAndView editPizza(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Pizza pizza = pizzaDAO.get(id);
		ModelAndView model = new ModelAndView("pizza_form");
		model.addObject("Pizza", pizza);
		return model;
	}
	
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public ModelAndView deletePizza(@RequestParam Integer id) {
		pizzaDAO.delete(id);
		return new ModelAndView("redirect:/");
	}
	
}
