package DesignPatterns;

public class SingletonImpl {
    private static volatile SingletonImpl instance;
    private String data;

    private SingletonImpl(String data){
        this.data = data;
    }

    public static SingletonImpl getInstance(String data){
        SingletonImpl result = instance;
        if(result==null){
            synchronized (SingletonImpl.class){
                result = instance;
                if(result==null){
                    instance = result  = new SingletonImpl(data);
                }
            }
        }
       return result;
    }

}
