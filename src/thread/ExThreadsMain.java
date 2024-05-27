package thread;

public class ExThreadsMain {
    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        String[] names = new String[] { "太郎さん", "次郎さん", "三郎さん" };
        for (int i = 0, len = threads.length; i < len; i++) {
            threads[i] = new Thread(new MyRunnable(names[i]));
        }

        // すべてのスレッドを開始
        for (Thread thread : threads) {
            thread.start();
        }

        // すべてのスレッドの終了を待機
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 30; i++) {
                if (i % 6 == 1 ) {
                    System.out.println((i/6 + 1) +"日目");
                }
                else if (i % 6 == 2) {
                    System.out.println(name + ":家にいます");
                } else if (i % 6 == 3) {
                    System.out.println(name + ":登校中です");
                } else if (i % 6 == 4) {
                    System.out.println(name + ":学校にいます");
                } else if (i % 6 == 5) {
                    System.out.println(name + ":下校中です");
                } else {
                    System.out.println(name + ":家にいます");
                }
                try {
                    Thread.sleep(500); // 500ミリ秒待機
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}