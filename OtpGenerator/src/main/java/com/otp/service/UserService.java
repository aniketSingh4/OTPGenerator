package com.otp.service;


import com.otp.dao.UserDao;
import com.otp.model.User;
import com.otp.util.EmailUtil;
import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService 
{
    private UserDao userDao;

    public UserService(Connection connection) {
        this.userDao = new UserDao(connection);
    }

    @Autowired
    private EmailUtil emailUtil;

    public boolean registerUser(User user) {
        boolean isInserted = userDao.insertUser(user);
        if (isInserted) {
            // Generate OTP
            String otp = OtpService.generateOtp();
            
            // Send OTP via Email using Spring Mail
            emailUtil.sendOtpEmail(user.getEmail(), otp);
            
            return true;
        }
        return false;
    }
}
