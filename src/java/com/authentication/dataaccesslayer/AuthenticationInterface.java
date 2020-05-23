/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.authentication.dataaccesslayer;

import com.entitymodel.RegistrationViewModel;
import com.entitymodel.UserViewModel;

/**
 *
 * @author Bishodeep
 */
public interface AuthenticationInterface {

    public UserViewModel AuthenticateUser(String username, String password);

    public boolean RegisterUser(RegistrationViewModel registerModel);
}
