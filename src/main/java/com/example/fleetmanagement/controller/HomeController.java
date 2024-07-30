package com.example.fleetmanagement.controller;

import com.example.fleetmanagement.model.Booking;
import com.example.fleetmanagement.model.Driver;
import com.example.fleetmanagement.repository.BookingRepository;
import com.example.fleetmanagement.repository.DriverRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping(value = {"","/","home"})
    public String displayHomePage() {
        return "index.html";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/service")
    public String service() {
        return "service";
    }

    @GetMapping("/dashboard")
    public String contact() {
        return "dashboard";
    }

    @GetMapping("/drivers")
    public String drivers(Model model) {
        model.addAttribute("drivers", driverRepository.findAll());
        return "drivers";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("bookings", bookingRepository.findAll());
        return "orders";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("driver", new Driver());
        return "register";
    }

    @PostMapping("/register")
    public String registerDriver(@Valid Driver driver, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Failed to save driver details. Please check the form for errors.");
            return "register";
        }
        driverRepository.save(driver);
        redirectAttributes.addFlashAttribute("success", "Driver registered successfully.");
        return "redirect:/register";
    }

    @GetMapping("/booking")
    public String showBooking(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking";
    }

    @PostMapping("/booking")
    public String bookService(@Valid Booking booking, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Failed to place an order. Please check the form for errors.");
            return "booking";
        }
        bookingRepository.save(booking);
        redirectAttributes.addFlashAttribute("success", "Service requested successfully.");
        return "redirect:/booking";
    }
}
