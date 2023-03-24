package org.homework.module13.task1;

import org.homework.module13.model.user.User;
import org.homework.module13.utils.HTTPUtils;
import org.homework.module13.utils.TaskUtils;

import java.io.IOException;

public class MainTaskOne {
    public static void main(String[] args) throws IOException, InterruptedException {
        User defaultUser = TaskUtils.getDefaultUser();

        //1
        HTTPUtils.POSTUser(defaultUser);

        //2
        HTTPUtils.PUTUser(defaultUser);

        //3
        HTTPUtils.DELETEUser(defaultUser);

        //4
        System.out.println(HTTPUtils.GETAllUsers());

        //5
        System.out.println(HTTPUtils.GETUserById(1));

        //6
        System.out.println(HTTPUtils.GETUserByUsername("Bret"));
    }
}
