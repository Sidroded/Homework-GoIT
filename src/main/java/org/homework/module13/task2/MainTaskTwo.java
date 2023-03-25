package org.homework.module13.task2;

import org.homework.module13.model.user.User;
import org.homework.module13.utils.HTTPUtils;
import org.homework.module13.utils.TaskUtils;

import java.io.IOException;

public class MainTaskTwo {

    public static void main(String[] args) throws IOException, InterruptedException {
        User user = TaskUtils.getDefaultUser();
        HTTPUtils.GETAllCommentsFromLastPostOfUser(user);
    }
}
