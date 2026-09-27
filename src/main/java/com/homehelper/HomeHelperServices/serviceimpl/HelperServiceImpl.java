package com.homehelper.HomeHelperServices.serviceimpl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.entity.Helper;
import com.homehelper.HomeHelperServices.exception.HelperNotFoundException;
import com.homehelper.HomeHelperServices.repository.BookingRepository;
import com.homehelper.HomeHelperServices.repository.HelperRepository;
import com.homehelper.HomeHelperServices.service.HelperService;

@Service
public class HelperServiceImpl implements HelperService {

    private final HelperRepository helperRepository;
    private final BookingRepository bookingRepository;
    private final PasswordEncoder passwordEncoder;

    public HelperServiceImpl(
            HelperRepository helperRepository,
            BookingRepository bookingRepository,
            PasswordEncoder passwordEncoder) {

        this.helperRepository = helperRepository;
        this.bookingRepository = bookingRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Helper registerHelper(Helper helper) {

        helper.setPassword(passwordEncoder.encode(helper.getPassword()));

        return helperRepository.save(helper);
    }

    @Override
    public Helper login(String email, String password) {

        Helper helper = helperRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(password, helper.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return helper;
    }

    @Override
    public List<Helper> getAllHelpers() {
        return helperRepository.findAll();
    }

    @Override
    public Helper getHelperById(int id) {

        return helperRepository.findById(id)
                .orElseThrow(() ->
                        new HelperNotFoundException("Helper not found"));
    }

    @Override
    public Helper updateHelper(int id, Helper helper) {

        Helper existing = helperRepository.findById(id)
                .orElseThrow(() ->
                        new HelperNotFoundException("Helper not found"));

        existing.setName(helper.getName());
        existing.setEmail(helper.getEmail());
        existing.setPhone(helper.getPhone());
        existing.setService(helper.getService());
        existing.setAvailability(helper.getAvailability());

        if (helper.getPassword() != null && !helper.getPassword().isEmpty()) {
            existing.setPassword(passwordEncoder.encode(helper.getPassword()));
        }

        return helperRepository.save(existing);
    }

    @Override
    public void deleteHelper(int id) {

        Helper helper = helperRepository.findById(id)
                .orElseThrow(() ->
                        new HelperNotFoundException("Helper not found"));

        helperRepository.delete(helper);
    }

    @Override
    public List<Booking> getHelperBookings(int helperId) {

        helperRepository.findById(helperId)
                .orElseThrow(() ->
                        new HelperNotFoundException("Helper not found"));

        return bookingRepository.findBookingsByHelperId(helperId);
    }
}