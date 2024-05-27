package thread;

public class CountAZTenRunnable {

    // main メソッドはプログラムのエントリーポイントです。
    public static void main(String[] args){
        // 2つの文字を初期化します。
        char c1 = 97; // ASCII値 97 は 'a' です

        Thread[] threads = new Thread[26];
        for(int i = 0, len = threads.length; i < len; i ++) {
            char nowc = (char)(c1+i);
            threads[i] = new Thread(new MyRunnable(nowc));
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
        private char c;
        public MyRunnable(char c) {
            this.c = c;
        }

        public void run() {
            for(int i = 1; i <= 10; i ++) {
                String word = c + String.valueOf(i);
                System.out.println(word);
                try {
                    Thread.sleep(100); // 100ミリ秒待機
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}