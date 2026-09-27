package com.homehelper.HomeHelperServices.service;

import java.util.List;

import com.homehelper.HomeHelperServices.entity.Booking;
import com.homehelper.HomeHelperServices.entity.Helper;

public interface HelperService {

    Helper registerHelper(Helper helper);

    Helper login(String email, String password);

    List<Helper> getAllHelpers();

    Helper getHelperById(int id);

    Helper updateHelper(int id, Helper helper);

    void deleteHelper(int id);

    List<Booking> getHelperBookings(int helperId);
}