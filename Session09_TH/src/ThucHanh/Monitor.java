package ThucHanh;

class Monitor {
    void log(String msg) {
        System.out.println(TimeUtil.t() + " " + msg);
    }

    void line(String msg) {
        System.out.println(msg);
    }
}
