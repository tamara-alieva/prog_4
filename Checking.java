public class Checking {
    static public boolean nameCheck(String name) {
        boolean f;
        f = !name.isEmpty() && name.matches("^[a-zA-Z]+");
        return f;
    }

    static public boolean intCheck(String balance) {
        boolean f;
        f = !balance.isEmpty() && balance.matches("^[0-9]+");
        return f;
    }

    static public boolean booleanCheck(String str) {
        boolean f;
        f = !str.isEmpty() && str.matches("[01]{1}");
        return f;
    }
}
