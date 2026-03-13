public class NullDemo4 {
    public static void main(String[] args) {
        String text = "hello";
        if (Math.random() < 0.001) {
            text = null;
        }
        if (text != null) {
            System.out.println(text.toUpperCase());
        } else {
            System.out.println("Text is null.");
        }
    }
}
