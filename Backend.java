public class Backend {

    // Declare native method

    public native int calculate(int a, int b, char op);

    // Load the native library

    static {
        System.loadLibrary("calc");
    }
}
