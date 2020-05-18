package Plagin1;

import sample.IService;

public class Plagin1 implements IService {
    @Override
    public void doJob() {
        System.out.println("Service 1");
    }
}