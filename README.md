I) Phân tích:
1.	Phân rã quá trình nghiệp vụ (Decompose Business Process)
Các bước thực hiện:
-	Nhận bảng đăng ký
-	Bắt đầu gửi bảng đăng ký
-	Nhận thời gian và địa điểm thi cho khách hàng
-	Kiểm tra xem thời gian và địa điểm thi còn slot hay không
-	Nếu không còn slot tại thời điểm đó, từ chối gửi bảng đăng ký
-	Gửi thông tin thanh toán cho người dùng 
-	Lấy thông tin thanh toán 
-	Nếu thanh toán không thành công từ  chối gửi bảng đăng ký
-	Cập nhật thông tin đăng ký
-	Gửi tin nhắn đến người dùng
-	Gửi trả thông tin đăng ký, cập nhật trạng thái đăng ký và kết thúc quy trình
2.	Loại bỏ những hành động không cần thiết
-	Nhận bảng đăng ký (được thực hiện hoàn toàn bởi người dùng)
Các bước còn lại:
-	Bắt đầu gửi bảng đăng ký
-	Nhận thời gian và địa điểm thi cho khách hàng
-	Kiểm tra xem thời gian và địa điểm thi còn slot hay không
-	Nếu không còn slot tại thời điểm đó, từ chối gửi bảng đăng ký
-	Gửi thông tin thanh toán cho người dùng
-	Nếu thanh toán không thành công từ  chối gửi bảng đăng ký
-	Cập nhật thông tin đăng ký
-	Gửi tin nhắn đến người dùng
-	Gửi trả thông tin đăng ký, cập nhật trạng thái đăng ký và kết thúc quy trình
3.	Xác định ứng viên thực thể dịch vụ
Các thực thể:

![image](https://github.com/jnp2018/team-project-n1_7/assets/108878258/94e51588-daed-42dd-ad83-6d08c40bf8e1)

 
Các bước không bất khả tri sẽ được in đậm:
-	Bắt đầu gửi bảng đăng ký
-	Nhận thời gian và địa điểm thi cho khách hàng
-	Kiểm tra xem thời gian và địa điểm thi còn slot hay không
-	Nếu không còn slot tại thời điểm đó, từ chối gửi bảng đăng ký
-	Gửi thông tin thanh toán cho người dùng
-	Nhận trạng thái thanh toán 
-	Kiểm tra thông tin thanh toán 
-	Nếu thanh toán không thành công từ  chối gửi bảng đăng ký
-	Cập nhật thông tin đăng ký
-	Gửi tin nhắn đến người dùng
-	 Kết thúc quy trình

 
-	Vẽ ToeicRegistation:
o	Get PaymentState

o	Get time and address of the test


![image](https://user-images.githubusercontent.com/108878258/233957738-cb5d00a7-e921-42e6-88b5-44f292e2f587.png)


-	Payment
o	Get Customer

o	Get PayInformation


![image](https://user-images.githubusercontent.com/108878258/233957809-3761db7f-eaaf-4e1b-bfc3-8ba1d4b863d6.png)

 
-	Còn lại 
o	Gửi thông tin thanh toán cho người dùng

o	Gửi tin nhắn đến người dùng




4.	Xác định logic quy trình cụ thể
-	Bắt đầu gửi bảng đăng ký
-	Kiểm tra xem thời gian và địa điểm thi còn slot hay không
-	Nếu không còn slot tại thời điểm đó, từ chối gửi bảng đăng ký
-	Kiểm tra thông tin thanh toán 
-	Nếu thanh toán không thành công từ  chối gửi bảng đăng ký
-	Kết thúc quy trình

-	 ToeicRegisSubmit:

o	Start


![image](https://user-images.githubusercontent.com/108878258/233957921-9c54246e-6d98-4d8f-9c34-01653dcaea08.png)


5.	Áp dụng hướng dịch vụ
6.	Xác định ứng viên thành phần dịch vụ

![image](https://github.com/jnp2018/team-project-n1_7/assets/108878258/026bda17-1f40-4d38-a251-4dbce2e645cf)


7.	Phân tích yêu cầu xử lý
8.	Xác định ứng viên dịch vụ tiện ích (utility service)
-	Còn lại các hành động khả tri là

o	Gửi thông tin thanh toán cho người dùng

o	Gửi tin nhắn đến người dùng

-	Nên tạo một utility service là :

o	Notification

	Send Message


![image](https://user-images.githubusercontent.com/108878258/233958413-877f0161-1e66-4056-8991-81007d546ef5.png)


9.	Xác định ứng vi MicroService 

-	Hành động xác nhận thông tin thanh toán là một phần của tác vụ ToeicRegisSubmisstion có thể tách ra

-	 ConfirmPayment

o	Confim

![image](https://user-images.githubusercontent.com/108878258/233958470-bee748f6-901b-49fa-86d6-be5b1f014ac0.png)


10.	 Áp dụng hướng dịch vụ
11.	 Xem xét lại các ứng viên thành phần dịch vụ
ToeicRegisSubmission

PaymentConfirm

–ToeicRegistation 

– Payment

-Notification

![image](https://user-images.githubusercontent.com/108878258/237012752-c6836ab8-56cd-46ed-a31a-25825faef87c.png)



 
12.	 Xem cách thức ứng viên tiềm năng

II)	Thiết kế by REST service and Microservice(Design)




1.	ToeicRegistation:

	Get/ ToeicRegistation/{ ToeicRegistation-id}

	Put/ ToeicRegistation/{ ToeicRegistation-id}/user

	Search/ ToeicRegistation/{ ToeicRegistation-id}

	Store/ ToeicRegistation/{ ToeicRegistation-id}/user

![image](https://user-images.githubusercontent.com/108878258/233959338-12c5db84-7fb6-486d-9491-7b4620faf982.png)

 
2.	Payment
	Get/payment/{payment-id}

	Put/payment/{payment-id}/user

	Search/payment/{payment-id}

	Store/payment/{payment-id}/user
 
![image](https://user-images.githubusercontent.com/108878258/233959286-8e0741ab-0dd3-4817-b0b0-edb9c454fe81.png)


 
3.	Utility Service 
-	 UserSystem

	Get/testtime/{date}

	Get/user/{user-id}

	Get/testplace/{date}

![image](https://user-images.githubusercontent.com/108878258/233959422-e7bde979-5e52-4dcd-86fe-d05f80bdbf5c.png)


 
4.	 MicroService Design

![image](https://user-images.githubusercontent.com/108878258/233959464-99456902-1008-4d5a-928d-c8ae7d3f4626.png)

 



-	Confirm Test Time

o	POST/start/Test/{test-id}

o	GET/task{id}

o	DELETE/task{id}

![image](https://user-images.githubusercontent.com/108878258/233959666-bc60feaf-8d10-4865-8383-a4bfe881150a.png)


-	 Confirm Register

o	GET/confirm/toeicregistation-id

o	GET/task/{id}

o	DELETE/task/{id}

![image](https://user-images.githubusercontent.com/108878258/233959733-9a7849c3-b775-44ac-979a-38df929898b9.png)

	 
5.	Event Service Contract (Entity)
-	 TestTime Decribtion

o	GET/testtime/{id}

o	PUT/ testtime/{id}

![image](https://user-images.githubusercontent.com/108878258/233959821-b1e4e9c1-2d48-4ed5-b992-03c1d970d19d.png)


6.	Utility
-	Notification

o	POST/notification/

![image](https://user-images.githubusercontent.com/108878258/233959892-dd9f55ab-4ab1-405f-8315-ab793a27104f.png)


III) Công nghệ sử dụng:

* ngôn ngữ sử dựng :java
* Phiên bản java 17
* Spring boot

Tên thành phần | Loại thành phần | Mô tả chức năng | Bên hoạt động 
-----|-----|-----|-----|
Spring Web | Web |là một phần của Spring FrameWork cung cấp các lớp và phương thức để xử lý các yêu cầu http và phản hồi các đôi tượng| Toeic-service và Payment-service
Spring DATA JPA | Database | Trợ giúp việc truy vấn cơ sở dữ liệu| Toeic-service và payment-service
MySQL Driver | Database | Kết nối với cơ sở dữ liệu MySQL | Toeic-service và Payment-service
Spring Thymleaf | Template | Nhúng dữ liệu và hiển thị trang Web | Toeic-service
Spring Devtools | Devtools | Hỗ trọ và đẩy nhanh qua trình phát triển dự án | Toeic-service và Payment-service
Spring Eureka Server | Cloud | lưu trữ các microservices trong hệ thống phân tán |Service-registry
Spring Discovery Client | Cloud | trợ giúp giao tiếp giữa các service| Toeic-service và Payment-service
PayPal SDK | Thư Viện | tích hợp thanh toán paypal vào ứng dụng | Payment-service
java mail | Thư viên | tích hợp để gửi email | Payment-service

A) Hướng dẫn cài đặt môi trường spring boot + eureka

-Tạo dự án Spring boot với Eureka Server

+ Tạo dự án Spring boot :Registry-Service

+ Trong file pom.xml thêm dependency của Eureka Server

 ![image](https://user-images.githubusercontent.com/108878258/236499552-e61e55e5-a787-4094-954c-f2756e077a7f.png)


+ cấu hình Eureka Server trong file application.properties như sau:

 
![image](https://user-images.githubusercontent.com/108878258/236499593-bbb07508-9858-4093-9d2a-3e9427e20630.png)


+ Để có thể khởi động Eureka Server thì cần thêm và chạy annotation “@EnableEurekaServer” trong class chính của ứng dụng :

 ![image](https://user-images.githubusercontent.com/108878258/236499613-7034e694-9922-436e-b3de-60c8f29e2753.png)


-Tạo dự án Spring boot với Eureka Client

+ Tạo dự án Spring boot :Toeic-Service và Payment-Service

+ Trong file pom.xml thêm dependency của Eureka Client

 ![image](https://user-images.githubusercontent.com/108878258/236499652-16f8063a-ea0f-4de0-aa80-c8903ea01b67.png)


+ cấu hình Eureka Client trong file application.properties như sau:

 
![image](https://user-images.githubusercontent.com/108878258/236499676-148c3de1-dffd-448d-9a54-4adaa02648d6.png)


![image](https://user-images.githubusercontent.com/108878258/236499714-0d915333-5dfc-4df1-b97a-06ecde0a0a15.png)


 

+ Để có thể khởi động Eureka Client thì cần thêm và chạy annotation “@EnableDiscoveryClient” trong class chính của ứng dụng :


 ![image](https://user-images.githubusercontent.com/108878258/236499747-3c25b65b-8786-4c29-b278-fb03e754a78d.png)



B) Hướng dẫn triển khai:

+ Chạy project Registry-Service để khởi động Eureka Server

+ Chạy tiếp 2 project Toeic-Service và Payment-service để triển khai service lên server:

+ Nếu thành công thì khi truy cập lên server sẽ hiển thị :

 ![image](https://user-images.githubusercontent.com/108878258/236499793-cf1aa425-36cd-456b-b36a-07609d364046.png)








