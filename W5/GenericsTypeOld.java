public class GenericsTypeOld<T> {

    // private Object t;

    // public Object get() {
    //     return t;
    // }

    // public void set(Object t) {
    //     this.t = t;
    // }

    private T t;
    public T get()         { return t; }
    public void set(T t)   { this.t = t; }


    public static void main(String args[]) {
        // GenericsTypeOld type = new GenericsTypeOld();
        // type.set(6);
        // String str = (String) type.get(); // type casting, error prone and can cause ClassCastException

        GenericsTypeOld<String> type = new GenericsTypeOld<>();
        type.set("Java");
        String str = type.get();
    }
}   
