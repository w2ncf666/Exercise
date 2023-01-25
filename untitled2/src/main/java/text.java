public class text {
    public static void main(String[] args) {
        smoke(new smoking() {
            public void smoke() {
                System.out.println("不要抽烟");
            }
        });
        String s="234";
        System.out.println(s.split("3")[0]);
    }
    public static void smoke(smoking s){
        s.smoke();
    }
}
