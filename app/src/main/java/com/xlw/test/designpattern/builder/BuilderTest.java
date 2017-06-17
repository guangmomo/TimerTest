package com.xlw.test.designpattern.builder;

import android.util.Log;

/**
 * Created by xlw on 2017/4/2.
 */

public class BuilderTest {
    public static void main(String[] args){
       Person person=new PersonBuilder()
                .setAge(23)
                .setHigh(175)
                .setName("徐立文")
                .setPhone("18819475101")
                .setSchool("广东工业大学")
               .createPerson();
        Log.e("builder",person.toString());
    }
}
