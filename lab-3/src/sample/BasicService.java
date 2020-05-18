package sample;

public class BasicService implements IService {
    @Override
    public void doJob() {
        System.out.println("Basic service");
    }
}