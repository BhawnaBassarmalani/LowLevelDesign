package DesignPatterns;

public class ThreadSafeSingletonImpl {
    private static ThreadSafeSingletonImpl instance;
    private String data;

    private ThreadSafeSingletonImpl(String data){
        this.data = data;
    }
    public static ThreadSafeSingletonImpl getInstance(String data){
        synchronized(ThreadSafeSingletonImpl.class){
            if(instance==null){
                instance = new ThreadSafeSingletonImpl(data);
            }
        }

        return instance;


    }

}
// even now when the instance was created , every thread has to wait before returning it, this can be solved by
//double checked locking


