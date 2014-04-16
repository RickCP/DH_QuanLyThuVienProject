Các bước để deploy một project QuanLyThuVienProject với Git
 Bước 1 : Cài đặt git client : http://git-scm.com/downloads
 Bước 2:  Download eclipse Kelper nó có tích hợp sẵn plugin git
 Bước 3: Check out code về bằng 2 cách 
		Cách 1 : Dùng command line : nên tìm hiểu git mới biết dùng các lệnh 
		Cách 2: Dùng eclipse để check out về. Có thể tham khảo ở link youtube : http://www.youtube.com/watch?v=4RRPQpDoaAk
       --> Chưa quen thì dùng cách hai để deploy project lần đầu tiên.
 Bước 4 : Import project vào eclipse : Vì project đang viết theo maven nên import bằng maven project nhé
		Bước 4.1 Khi check out project về. Chuyển đến thư mục check out đó
			Gõ lệnh : mvn eclipse:eclipse
					  mvn eclipse:clean
					  Nên nhớ là mi phải cài maven, tạo biến môi trường cho nó
					  Tham khảo link : http://laptrinh.vn/d/73-cai-dat-maven-tren-windows.html nếu chưa biết.Tương tự cài đặt java environment.
 Bước 5. Config project
			- Java Build Path : Dùng JDK 7
			- Server RunTime : Dùng Tomcat 7
 --> OK.Chạy project lên . Xem ok chưa.