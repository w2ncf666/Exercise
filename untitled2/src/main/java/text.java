public class text {
    public static void main(String[] args) {
        smoke(new smoking() {
            public void smoke() {
                System.out.println("不要抽烟");
            }
        });
    }
    public static void smoke(smoking s){
        s.smoke();
    }
}
