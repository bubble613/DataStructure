package com.LWY.designPattern;

public class MediatorParttern {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Colleague1 colleague1 = new Colleague1(mediator);
        Colleague2 colleague2 = new Colleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.sendMessage("吃过饭了吗？");
        colleague2.sendMessage("没有呢，你打算请客？");
    }
}

abstract class Colleague{
    protected Mediator mediator;

}

class Colleague1 extends Colleague{
    public Colleague1(Mediator mediator){
        this.mediator = mediator;
    }

    public void sendMessage(String message){
        mediator.sendMessage(message, this);
    }

    public void notify(String message) {
        System.out.println("同事1得到消息：" + message);
    }

}


class Colleague2 extends Colleague {
    public Colleague2(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void notify(String message) {
        System.out.println("同事2得到消息：" + message);
    }

}


abstract class Mediator {
    public abstract void sendMessage(String message, Colleague colleague);
}

class ConcreteMediator extends Mediator {

    private Colleague1 colleague1;
    private Colleague2 colleague2;

    public void setColleague1(Colleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(Colleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.notify(message);
        } else {
            colleague1.notify(message);
        }
    }
}

