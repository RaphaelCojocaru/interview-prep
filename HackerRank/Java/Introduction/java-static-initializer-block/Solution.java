// https://www.hackerrank.com/challenges/java-static-initializer-block
    // Write your code here
    private static int B, H;
    private static boolean flag;

    static {
        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();
        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            flag = false;
        } else
            flag = true;
        sc.close();
    }