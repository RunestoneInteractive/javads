public class NullDemo3 {
    public static void main(String[] args) {
        String text = "hello";
        if (Math.random() < 0.001) {
            text = null;
        }
        System.out.println(text.toUpperCase());
    }
}
