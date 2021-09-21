package util;

public class GeneratorUtils {

    public static Long randomLong() {
        return 1l + (long) (Math.random() * (100000l - 1l));
    }

}
