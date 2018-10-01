package com.security.valpro.utils;

import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

public class TaskB extends Task {
    private Mailbox<Object> result;
    TaskB(Mailbox<Object> result){
        this.result=result;
    }
    public void execute() throws Pausable,Exception{
        result.put("result from TaskB");
    }
}
