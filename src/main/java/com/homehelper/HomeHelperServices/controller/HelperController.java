package com.homehelper.HomeHelperServices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.entity.Helper;
import com.homehelper.HomeHelperServices.service.HelperService;

@RestController
@RequestMapping("/api/helpers")
public class HelperController {

    private final HelperService helperService;

    public HelperController(HelperService helperService) {
        this.helperService = helperService;
    }

    @PostMapping("/register")
    public Helper register(@RequestBody Helper helper) {
        return helperService.registerHelper(helper);
    }

    @PostMapping("/login")
    public Helper login(@RequestBody Helper helper) {
        return helperService.login(
                helper.getEmail(),
                helper.getPassword());
    }

    @GetMapping
    public List<Helper> getAllHelpers() {
        return helperService.getAllHelpers();
    }

    @GetMapping("/{id}")
    public Helper getHelper(@PathVariable int id) {
        return helperService.getHelperById(id);
    }

    @PutMapping("/{id}")
    public Helper updateHelper(
            @PathVariable int id,
            @RequestBody Helper helper) {

        return helperService.updateHelper(id, helper);
    }

    @DeleteMapping("/{id}")
    public String deleteHelper(@PathVariable int id) {

        helperService.deleteHelper(id);

        return "Helper deleted successfully";
    }

    @GetMapping("/{id}/bookings")
    public List<Booking> getHelperBookings(@PathVariable int id) {
        return helperService.getHelperBookings(id);
    }
}