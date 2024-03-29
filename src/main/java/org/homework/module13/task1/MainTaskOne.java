package org.homework.module13.task1;

import org.homework.module13.model.user.User;
import org.homework.module13.utils.HTTPUtils;
import org.homework.module13.utils.TaskUtils;

import java.io.IOException;

public class MainTaskOne {
    public static void main(String[] args) throws IOException, InterruptedException {
        User user = TaskUtils.getDefaultUser();

        //1
        HTTPUtils.POSTUser(user);

        //2
        HTTPUtils.PUTUser(user);

        //3
        HTTPUtils.DELETEUser(user);

        //4
        System.out.println(HTTPUtils.GETAllUsers());

        //5
        System.out.println(HTTPUtils.GETUserById(1));

        //6
        System.out.println(HTTPUtils.GETUserByUsername("Bret"));
    }
}
