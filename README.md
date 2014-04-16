Các bước để deploy một project QuanLyThuVienProject với Git
 <br/>
 <b>Bước 1</b> : Cài đặt git client : http://git-scm.com/downloads
 <br/>
 <b>Bước 2:</b>  Download eclipse Kelper nó có tích hợp sẵn plugin git
 <br/>
<b> Bước 3: </b>Check out code về bằng 2 cách 
 <br/>
		Cách 1 : Dùng command line : nên tìm hiểu git mới biết dùng các lệnh 
		<br/>
		Cách 2: Dùng eclipse để check out về. Có thể tham khảo ở link youtube : http://www.youtube.com/watch?v=4RRPQpDoaAk
		<br/>
       --> Chưa quen thì dùng cách hai để deploy project lần đầu tiên.
	   <br/>
 <b>Bước 4</b> : Import project vào eclipse : Vì project đang viết theo maven nên import bằng maven project nhé
 <br/>
		        Khi check out project về. Chuyển đến thư mục check out đó
		<br/>
			Gõ lệnh : mvn eclipse:eclipse
					  mvn eclipse:clean
					  Nên nhớ là mi phải cài maven, tạo biến môi trường cho nó
					  Tham khảo link : http://laptrinh.vn/d/73-cai-dat-maven-tren-windows.html nếu chưa biết.Tương tự cài đặt java environment.
					  <br/>
 <b>Bước 5.</b> Config project
			- Java Build Path : Dùng JDK 7
			- Server RunTime : Dùng Tomcat 7
			<br/>
 --> OK.Chạy project lên . Xem ok chưa.