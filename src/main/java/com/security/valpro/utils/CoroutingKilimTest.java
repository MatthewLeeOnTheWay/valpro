package com.security.valpro.utils;

import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

public class CoroutingKilimTest extends Task {
    //线程之间的调用
    @Override
    public void execute() throws Exception,Pausable {
        super.execute();
        Mailbox<Object> result=new Mailbox<Object>();
        Task task=new TaskB(result);
        task.start();
        Object resultObject=result.get();
        System.out.println(resultObject);
    }
}