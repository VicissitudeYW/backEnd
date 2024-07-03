package org.example.controller;

import org.apache.catalina.User;
import org.example.pojo.DataUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Reno Ng
 * CreateTime: 2024-07-03
 * Description: 登录接口
 */

@RestController
@RequestMapping("/login")
public class LogInController {
    @PostMapping
    public DataUser getUser(@RequestBody UserInput userInput) {
        DataUser dataUser = new DataUser();
        String username = userInput.getUsername();
        String password = userInput.getPassword();
        boolean is_Doctor = userInput.getIs_Doctor();


        return dataUser;
    }

    static class UserInput {
        private String username;
        private String password;
        private boolean is_Doctor;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean getIs_Doctor() {
            return is_Doctor;
        }

        public void setIs_Doctor(boolean is_Doctor) {
            this.is_Doctor = is_Doctor;
        }
    }
}
