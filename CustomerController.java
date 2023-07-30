package com.mysql_mvc.controllers;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql_mvc.models.Customer;
import com.mysql_mvc.repositories.CustomerRepository;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/")
	public String index(Model model)
	{
		Iterable<Customer> data = customerRepository.findAll();
		Iterator<Customer> all_customers= data.iterator();
		model.addAttribute("all_customers", all_customers);
		return "index";
	}

	@GetMapping("/add-customer")
	public String add_customer(Model model)
	{
		model.addAttribute("customer_object",new Customer() );
		return "add_customer";
	}
	
	@PostMapping("/add-customer")
	public String add_customer(@ModelAttribute Customer customer, Model model)
	{
		System.out.println(customer.getId());
		System.out.println(customer.getName());
		System.out.println(customer.getPhone());
		
		customerRepository.save(customer);
		Iterable<Customer> data = customerRepository.findAll();
		Iterator<Customer> all_customers= data.iterator();
		model.addAttribute("all_customers", all_customers);
		return "redirect:/";
	}
	
	
	@GetMapping("/edit-customer")
    public String edit_customer(@RequestParam("id") int customerId, Model model) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        model.addAttribute("customer_object", customer);
        return "edit_customer";
    }

    @PostMapping("/edit-customer")
    public String update_customer(@ModelAttribute("customer_object") Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(updatedCustomer.getId()).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setPhone(updatedCustomer.getPhone());
            customerRepository.save(existingCustomer);
        }
        return "redirect:/";
    }
	
	@GetMapping("/delete-customer")
    public String deleteCustomer(@RequestParam("id") int customerId) {
        customerRepository.deleteById(customerId);
        return "redirect:/"; 
    }
}
