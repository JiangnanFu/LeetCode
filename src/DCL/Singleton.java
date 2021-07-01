package DCL;

/**
 * @author fujiangnan
 * @create 2020-12-17 13:18:40
 * @desc DCL单例
 */
public class Singleton {
    private volatile static Singleton instance;
    private Singleton() {

    }
    public static Singleton getInstance() {
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;

    }
    public static void main(String[] args) {
        System.out.println("双重检查");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }


}
