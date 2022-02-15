package site.metacoding.chat_v2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServerSocket {

    // 서버에 필요한 것

    // 리스너(연결받기) - main 스레드
    ServerSocket serverSocket;
    List<고객전담스레드> 고객리스트; // heap에 뜬거 보관

    // Socket socket; 바이트 스트림 선, 전역으로 만들면 안됨(지역변수로) - > 연결 계속 받아야 하기 때문

    // 메시지 받아서 보내기(클라이언트 수에 따라)

    public MyServerSocket() {
        try {
            serverSocket = new ServerSocket(2000);
            고객리스트 = new ArrayList<>();

            while (true) { // 계속 연결받아야 하기 때문
                Socket socket = serverSocket.accept(); // accept가 연결요청 받음, 기다림(main 스레드)
                System.out.println("클라이언트 연결");

                고객전담스레드 t = new 고객전담스레드(socket); // socket 넘김
                고객리스트.add(t); // while 끝나기 전에 heap에 뜬 t 담아주기 , t가 소캣정보 가지고 있기 떄문
                System.out.println("고객리스트 크기 : " + 고객리스트.size());
                new Thread().start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 내부 클래스
    class 고객전담스레드 implements Runnable {

        Socket socket; // socket 보관하기

        // 버퍼 (버퍼정보가 고객마다 있어야 하기 때문)

        public 고객전담스레드(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

        }

    }

    public static void main(String[] args) {
        new MyServerSocket();
    }
}
